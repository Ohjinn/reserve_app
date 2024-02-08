import { useEffect, useState } from "react";
import ArrowButton from "../component/ArrowButton";
import BlackButton from "../component/BlackButton";
import ChairSelectList from "../component/ChairSelectList";

const ChairSelect = () => {
  const [isSelect, setIsSelect] = useState();
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
        <img src="map.png" style={{ maxHeight: "400px", maxWidth: "300px", margin:"auto"}} />
      </div>
      <ChairSelectList isSelect={isSelect} setIsSelect={setIsSelect} />
      {isSelect ? (
        <BlackButton
          content={"다음"}
          link={"/chairselect"}
          linkTrue={true}
          buttonColor={"#000000"}
        />
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
