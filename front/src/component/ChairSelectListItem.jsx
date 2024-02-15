const ChairSelectListItem = ({item, isSelect, setIsSelect}) => {
    return item.possible ? (
      isSelect === item.chairId ? (
        // 선택 된 놈
        <div
          style={{
            border: "1px solid #28CDC8",
            backgroundColor: "#28CDC8",
            borderRadius: "10px",
            margin: "3%",
            width: "70px",
            height: "40px",
            justifyContent: "center",
            alignItems: "center",
            display: "flex",
          }}
        >
          {item.chairName}
        </div>
      ) : (
        // 선택 안된놈
        <div
          style={{
            border: "1px solid #28CDC8",
            borderRadius: "10px",
            margin: "3%",
            width: "70px",
            height: "40px",
            justifyContent: "center",
            alignItems: "center",
            display: "flex",
            color: "black"
          }}
          onClick={() => {
            setIsSelect(item.chairId);
          }}
        >
          {item.chairName}
        </div>
      )
    ) : (
      // 선택 불가능한 놈들
      <div
        style={{
          border: "1px solid",
          backgroundColor: "grey",
          borderRadius: "10px",
          margin: "3%",
          width: "70px",
          height: "40px",
          justifyContent: "center",
          alignItems: "center",
          display: "flex",
        }}
      >
        {item.chairName}
      </div>
    );
  };
  
  export default ChairSelectListItem;
  