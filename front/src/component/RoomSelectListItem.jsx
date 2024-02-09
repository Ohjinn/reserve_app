import Circle from "../assets/circle.svg";
import SelectCircle from "../assets/select_circle.svg";

const RoomSelectListItem = ({
  locationId,
  locationName,
  isSelect,
  setIsSelect,
}) => {
  return (
    <div
      style={{
        border: isSelect === locationId ? "2px solid black" : "1px solid black",
        borderRadius: "20px",
        padding: "10px 20px",
        display: "flex",
        justifyContent: "space-between",
      }}
      onClick={() => {
        if (isSelect === locationId) {
          setIsSelect(null);
        } else {
          setIsSelect(locationId);
        }
      }}
    >
      <div>
        <p style={{ fontWeight: "800", fontSize: "25px", margin: "0", color: "black" }}>방배</p>
        <p style={{ margin: 0, color: "black" }}>{locationName}</p>
      </div>
      {isSelect === locationId && <img src={SelectCircle} />}
      {isSelect !== locationId && <img src={Circle} />}
    </div>
  );
};

export default RoomSelectListItem;
