import ReservationListItem from "./ReservationListItem";

const ReservationList = ({item}) => {
  return (
    <div style={{ display: "flex", flexDirection: "column", margin: "10px" }}>
      {item.map((item) => (
        <ReservationListItem key={item.reservationId} item={item} />
      ))}
    </div>
  );
};

export default ReservationList;
