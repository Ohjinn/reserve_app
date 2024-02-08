import { useEffect, useState } from "react";
import ArrowButton from "../component/ArrowButton";
import BlackButton from "../component/BlackButton";
import TimeSelectList from "../component/TimeSelectList";

const TimeSelect = () => {
  const [isSelect, setIsSelect] = useState();
  useEffect(() => console.log(isSelect), [isSelect]);
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
        <TimeSelectList isSelect={isSelect} setIsSelect={setIsSelect} />
      </div>
      {isSelect ? (
        <BlackButton
          content={"다음"}
          link={"/chairselect"}
          linkTrue={true}
          buttonColor={"#000000"}
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
