import { DUMMY_TIME } from "../util/times";
import TimeSelectListItem from "./TimeSelectListItem";

const TimeSelectList = ({ data, isSelect, setIsSelect }) => {
  return (
    <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
      {data?.map((item) => (
        <TimeSelectListItem
          key={data.indexOf(item)}
          item={item}
          isSelect={isSelect}
          setIsSelect={setIsSelect}
        />
      ))}
    </div>
  );
};

export default TimeSelectList;
