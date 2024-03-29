package shop.anmachair.reservationchair.repositories.customRepository.implementation;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import shop.anmachair.reservationchair.dtos.ChairSummaryDto;
import shop.anmachair.reservationchair.dtos.TimeSummaryDto;
import shop.anmachair.reservationchair.repositories.customRepository.LocationRepositoryCustom;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static shop.anmachair.reservationchair.models.QChair.chair;
import static shop.anmachair.reservationchair.models.QReservation.reservation;
import static shop.anmachair.reservationchair.models.QTimeSlot.timeSlot;

public class LocationRepositoryImpl implements LocationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public LocationRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }


    @Override
    public List<TimeSummaryDto> findAvailableTimeList(Integer locationId) {

        Long chairCount = queryFactory
                .select(chair.count())
                .from(chair)
                .where(chair.location.id.eq(locationId))
                .fetchOne();

        // 메인 쿼리에서 각 시간대별로 전체 의자의 수와 예약된 의자의 수를 비교합니다.
        return queryFactory
                .select(Projections.constructor(TimeSummaryDto.class,
                        timeSlot.times,
                        new CaseBuilder()
                                .when(reservation.id.count().lt(chairCount))
                                .then(true)
                                .otherwise(false)))
                .from(timeSlot)
                .leftJoin(reservation)
                .on(reservation.location.id.eq(locationId)
                        .and(reservation.reservationDatetime.year().eq(LocalDate.now().getYear()))
                        .and(reservation.reservationDatetime.dayOfYear().eq(LocalDate.now().getDayOfYear()))
                        .and(reservation.reservationDatetime.hour().eq(timeSlot.times.hour()))
                        .and(reservation.reservationDatetime.minute().eq(timeSlot.times.minute())))
                .groupBy(timeSlot.timeSlot)
                .orderBy(timeSlot.timeSlot.id.asc())
                .fetch();
    }

    @Override
    public List<ChairSummaryDto> findAvailableChairList(Integer locationId, LocalTime convertedTime) {

        return queryFactory
                .select(Projections.constructor(ChairSummaryDto.class,
                        chair.id,
                        chair.chairName,
                        new CaseBuilder()
                                .when(reservation.id.count().eq(0L))
                                .then(true)
                                .otherwise(false)))
                .from(chair)
                .leftJoin(reservation)
                .on(chair.location.id.eq(locationId)
                        .and(reservation.reservationDatetime.year().eq(LocalDate.now().getYear()))
                        .and(reservation.reservationDatetime.dayOfYear().eq(LocalDate.now().getDayOfYear()))
                        .and(reservation.reservationDatetime.hour().eq(convertedTime.getHour()))
                        .and(reservation.reservationDatetime.minute().eq(convertedTime.getMinute())))
                .where(chair.location.id.eq(locationId))
                .groupBy(chair.id, chair.chairName)
                .orderBy(chair.id.asc())
                .fetch();
    }

}
