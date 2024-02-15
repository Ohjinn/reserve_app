import LogoutIcon from "@mui/icons-material/Logout";
import { useNavigate } from "react-router-dom";
import { logout } from "../api/Logout";

const LogoutButton = () => {
  const navigate = useNavigate();

  const onClickLogoutButton = async () => {
    const result = await logout();
    if (result.statusCode === 204) {
        localStorage.removeItem("accessToken");
        navigate("/")
    } else {
        alert("서버에 문제가 있습니다. 잠시 후 시도해주세요");
    }
    
  };
  return (
    <>
      <LogoutIcon
        color="primary"
        aria-label="로그아웃"
        onClick={onClickLogoutButton}
        style={{
            marginTop: "50px",
            marginBottom: "30px",
            marginLeft: "30px",
            size: "large",
          }}
      />
    </>
  );
};

export default LogoutButton;
