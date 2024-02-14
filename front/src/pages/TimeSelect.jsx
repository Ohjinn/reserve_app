import { useLocation } from "react-router-dom";
import { useEffect, useState } from "react";
import ArrowButton from "../component/ArrowButton";
import BlackButton from "../component/BlackButton";
import TimeSelectList from "../component/TimeSelectList";
import { time } from "../api/Time";

const TimeSelect = () => {
  const [isSelect, setIsSelect] = useState();
  const [data, setData] = useState();
  const location = useLocation(); // location 객체를 가져옵니다.

  // useEffect(() => console.log(isSelect), [isSelect]);
  useEffect(() => {
    if (location.state) {
      const locationId = location.state.isSelect;
      time(locationId).then((res) => {
        let updatedData = res.body.map((item) => {
          let parts = item.time.split(":");
          let newTime = parts[0] + ":" + parts[1];
          return {
            ...item,
            time: newTime,
          };
        });
        setData(updatedData);
      });
    }
  }, [location]);

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
          시간을 선택해주세요
        </p>
        <TimeSelectList
          data={data}
          isSelect={isSelect}
          setIsSelect={setIsSelect}
        />
      </div>
      {isSelect ? (
        <BlackButton
          content={"다음"}
          link={"/chairselect"}
          linkTrue={true}
          buttonColor={"#000000"}
          object={{
            state: {
              locationId: location.state.isSelect,
              selectedTime: isSelect,
            },
          }}
        />
      ) : (
        <BlackButton
          content={"시간을 선택해주세요"}
          link={"none"}
          linkTrue={false}
          buttonColor={"#ced4da"}
        />
      )}
    </div>
  );
};

export default TimeSelect;
