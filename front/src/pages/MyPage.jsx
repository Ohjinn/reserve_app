import ReservationList from "../component/ReservationList";
import ArrowButton from "../component/ArrowButton";

export default function MyPage() {
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-between",
        height: "100vh",
      }}
    >
      <ArrowButton />
      <ReservationList />
      <div></div>
    </div>
  );
}
