import { DUMMY_DATA } from "../util/reserve";
import ReservationListItem from "./ReservationListItem";

const ReservationList = () => {
  return (
    <div style={{ display: "flex", flexDirection: "column", margin: "10px" }}>
      {DUMMY_DATA.map((item) => (
        <ReservationListItem key={item.reserveId} item={item} />
      ))}
    </div>
  );
};

export default ReservationList;
