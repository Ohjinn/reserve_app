package shop.anmachair.reservationchair.repositories.customRepository.implementation;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import shop.anmachair.reservationchair.dtos.ReservationSummaryDto;
import shop.anmachair.reservationchair.repositories.customRepository.ReservationRepositoryCustom;

import java.util.List;

import static shop.anmachair.reservationchair.models.QChair.chair;
import static shop.anmachair.reservationchair.models.QLocation.location;
import static shop.anmachair.reservationchair.models.QReservation.reservation;

public class ReservationRepositoryImpl implements ReservationRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ReservationRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<ReservationSummaryDto> findByUserIdLeftJoinLocationChair(String userId) {
        return queryFactory
                .select(Projections.constructor(ReservationSummaryDto.class,
                        reservation.id,
                        reservation.user.id,
                        chair.chairName,
                        location.locationName,
                        reservation.reservationDatetime,
                        reservation.createdAt))
                .from(reservation)
                .leftJoin(location)
                .on(reservation.location.id.eq(location.id))
                .leftJoin(chair)
                .on(reservation.chair.id.eq(chair.id))
                .where(reservation.user.id.eq(userId))
                .fetch();
    }
}
