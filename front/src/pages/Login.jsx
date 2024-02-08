import Grid from "@mui/material/Grid";
import { Link } from "react-router-dom";

const Login = () => {
  return (
    <div>
      <div>
        <Grid container style={{ padding: "50% 0%" }}>
          <Grid item xs={2}></Grid>
          <Grid item xs={8}>
            <img
              alt="logo"
              src="logo.png"
              style={{ width: "100%", maxWidth: "100%" }}
            />
          </Grid>
          <Grid item xs={2}></Grid>
          <Grid item xs={2}></Grid>
          <Grid item xs={8}>
            <p style={{ textAlign: "center" }}>kt ds 안마의자 예약 시스템</p>
          </Grid>
          <Grid item xs={2}></Grid>
          <Grid item xs={2}></Grid>
          <Grid item xs={8}>
            <Link to={"/main"}>
              <img
                alt="kakaologin"
                src="kakaoLogin.png"
                style={{ width: "100%", maxWidth: "100%" }}
              />
            </Link>
          </Grid>
          <Grid item xs={2}></Grid>
        </Grid>
      </div>
    </div>
  );
};

export default Login;
