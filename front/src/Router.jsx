import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./pages/Login";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Main from "./pages/Main";
import MyPage from "./pages/MyPage";
import RoomSelect from "./pages/RoomSelect";
import TimeSelect from "./pages/TimeSelect";
import ChairSelect from "./pages/ChairSelect";

const Router = () => {
  return (
    <BrowserRouter>
      {/* <NavVar /> */}
      <Routes>
        <Route path={"/"} element={<Login />} />
        <Route path={"/signin"} element={<SignIn/>}/>
        <Route path={"/signup"} element={<SignUp/>}/>
        <Route path={"/main"} element={<Main />} />
        <Route path={"/mypage"} element={<MyPage />} />
        <Route path={"/roomselect"} element={<RoomSelect />} />
        <Route path={"/timeselect"} element={<TimeSelect />} />
        <Route path={"/chairselect"} element={<ChairSelect />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
