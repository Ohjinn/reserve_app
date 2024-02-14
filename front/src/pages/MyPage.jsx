import { useEffect, useState } from "react";
import ReservationList from "../component/ReservationList";
import ArrowButton from "../component/ArrowButton";
import { mypage } from "../api/MyPage"

export default function MyPage(){
  const [data, setData] = useState();

  useEffect(() => {
    mypage().then(res => setData(res.body))
  }, [])
  
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
      {data && <ReservationList item={data} />}
      <div></div>
    </div>
  );
}
