import { DUMMY_TIME } from "../util/times";
import TimeSelectListItem from "./TimeSelectListItem";

const TimeSelectList = ({ isSelect, setIsSelect }) => {
  return (
    <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
      {DUMMY_TIME.map((item) => (
        <TimeSelectListItem
          key={DUMMY_TIME.indexOf(item)}
          item={item}
          isSelect={isSelect}
          setIsSelect={setIsSelect}
        />
      ))}
    </div>
  );
};

export default TimeSelectList;
