const NewBlackButton = ({ content, buttonColor, link }) => {
  return (
    <button
    onClick={() => {console.log("hello")}}
      style={{ backgroundColor: buttonColor, color: "white", margin: "10px" }}
    >
      {content}
    </button>
  );
};

export default NewBlackButton;
