import ChairSelectListItem from "./ChairSelectListItem";

const ChairSelectList = ({ data, isSelect, setIsSelect }) => {
  console.log('data', data)
  return (
    <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
      {data?.map((item) => (
        <ChairSelectListItem
          key={item.chairName}
          item={item}
          isSelect={isSelect}
          setIsSelect={setIsSelect}
        />
      ))}
    </div>
  );
};

export default ChairSelectList;
