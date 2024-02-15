import {createReservation} from "../api/CreateReservation"
import { useNavigate } from "react-router-dom";

const NewBlackButton = ({ content, buttonColor, selectedTime, locationId, data }) => {
  const navigate = useNavigate();
  return (
    <button
    onClick={() => {
      createReservation(selectedTime, locationId, data)
      navigate("/")
    }}
      style={{ backgroundColor: buttonColor, color: "white", margin: "10px" }}
    >
      {content}
    </button>
  );
};

export default NewBlackButton;
