import { useEffect, useState } from "react";
import ArrowButton from "../component/ArrowButton";
import RoomSelectListItem from "../component/RoomSelectListItem";
import BlackButton from "../component/BlackButton";
import { location } from "../api/Locations";

const RoomSelect = () => {
  const [isSelect, setIsSelect] = useState();
  const [data, setData] = useState();

  useEffect(() => {
    location().then((res) => setData(res.body));
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
          사용하실 휴게실 위치를 선택해주세요
        </p>
        <p
          style={{
            padding: "10px 20px",
            margin: "0",
            justifyContent: "space-between",
          }}
        >
          지역을 선택해주세요
        </p>
        {/* {api_data.map(item =>)} */}
        <div style={{ display: "flex", flexDirection: "column", gap: "10px" }}>
          {data?.map((item) => (
            <RoomSelectListItem
              key={item.locationId}
              locationId={item.locationId}
              locationName={item.locationName}
              isSelect={isSelect}
              setIsSelect={setIsSelect}
            />
          ))}
        </div>
      </div>
      {isSelect ? (
        <BlackButton
          content={"다음"}
          buttonColor={"#000000"}
          linkTrue={true}
          link={"/timeselect"}
          object={{ state: { isSelect: isSelect } }}
        />
      ) : (
        <BlackButton
          content={"휴게실을 선택해주세요"}
          link={"none"}
          linkTrue={false}
          buttonColor={"#ced4da"}
        />
      )}
    </div>
  );
};

export default RoomSelect;
