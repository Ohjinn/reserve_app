import { useNavigate } from "react-router-dom";

const BlackButton = ({ content, link, linkTrue, buttonColor }) => {
  const navigate = useNavigate();
  return linkTrue ? (
    <button
      onClick={() => {
        navigate(link);
      }}
      style={{ backgroundColor: buttonColor, color: "white", margin: "10px" }}
    >
      {content}
    </button>
  ) : (
    <button
      style={{ backgroundColor: buttonColor, color: "white", margin: "10px" }}
    >
      {content}
    </button>
  );
};

export default BlackButton;
