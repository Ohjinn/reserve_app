import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import ArrowButton from "../component/ArrowButton";
import BlackButton from "../component/BlackButton";
import NewBlackButton from "../component/NewBlackButton";
import ChairSelectList from "../component/ChairSelectList";
import { chair } from "../api/Chair";

const ChairSelect = () => {
  const [isSelect, setIsSelect] = useState();
  const [data, setData] = useState();
  const location = useLocation(); // location 객체를 가져옵니다.

  // location.state가 정의되어 있을 때만 locationId와 selectedTime을 가져옵니다.
  const locationId = location.state?.locationId;
  const selectedTime = location.state?.selectedTime;

  useEffect(() => {
    chair(locationId, selectedTime).then((res) => setData(res.body));
  }, []);

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
      <div style={{ display: "flex", flexDirection: "column", margin: "10px" }}>
        <p
          style={{
            fontSize: "20px",
            fontWeight: "1000",
            padding: "10px 20px",
            margin: "0",
            justifyContent: "space-between",
          }}
        >
          의자를 선택해주세요
        </p>
        <img
          src="map.png"
          style={{ maxHeight: "400px", maxWidth: "300px", margin: "auto" }}
        />
      </div>
      <ChairSelectList
        data={data}
        isSelect={isSelect}
        setIsSelect={setIsSelect}
      />
      {isSelect ? (
        <NewBlackButton content={"예약완료"} buttonColor={"#000000"} link={"/main"}/>
      ) : (
        <BlackButton
          content={"의자를 선택해주세요"}
          link={"none"}
          linkTrue={false}
          buttonColor={"#ced4da"}
        />
      )}
    </div>
  );
};

export default ChairSelect;
