import { DUMMY_CHAIR } from "../util/chairs";
import TimeSelectListItem from "./TimeSelectListItem";

const ChairSelectList = ({ isSelect, setIsSelect }) => {
  return (
    <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
      {DUMMY_CHAIR.map((item) => (
        <TimeSelectListItem
          key={DUMMY_CHAIR.indexOf(item)}
          item={item}
          isSelect={isSelect}
          setIsSelect={setIsSelect}
        />
      ))}
    </div>
  );
};

export default ChairSelectList;
