import Button from "@mui/material/Button";
import ArrowButton from "../component/ArrowButton";
import LogoutButton from "../component/LogoutButton";

const Main = () => {
  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-between",
        height: "100vh",
      }}
    >
      <LogoutButton />
      <div style={{ display: "flex", flexDirection: "column", margin: "10px" }}>
        <Button
          href="/roomselect"
          size="large"
          variant="outlined"
          style={{
            width: "95%",
            m: 1,
            color: "black",
            borderColor: "gray",
            ":hover": { borderColor: "black" },
            margin: "1vh",
            borderRadius: "10px"
          }}
        >
          예약하기
        </Button>
        <Button
          href="/mypage"
          size="large"
          variant="outlined"
          style={{
            width: "95%",
            m: 1,
            color: "black",
            borderColor: "gray",
            ":hover": { borderColor: "black" },
            margin: "1vh",
            borderRadius: "10px"
          }}
        >
          예약관리
        </Button>
      </div>
      <div></div>
    </div>
  );
};
export default Main;
