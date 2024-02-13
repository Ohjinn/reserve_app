import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./pages/Login";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Main from "./pages/Main";
import MyPage from "./pages/MyPage";
import RoomSelect from "./pages/RoomSelect";
import TimeSelect from "./pages/TimeSelect";
import ChairSelect from "./pages/ChairSelect";
import NotFound from "./pages/NotFound";
import AuthRequiredRoutes from "./util/AuthRequiredRoutes";
import AuthManageRoutes from "./util/AuthManageRoutes";

const Router = () => {
  return (
    <BrowserRouter>
      {/* <NavVar /> */}
      <Routes>
        <Route element={<AuthManageRoutes />}>
          <Route path={"/"} element={<Login />} />
          <Route path={"/signin"} element={<SignIn />} />
          <Route path={"/signup"} element={<SignUp />} />
        </Route>
        <Route element={<AuthRequiredRoutes />}>
          <Route path={"/main"} element={<Main />} />
          <Route path={"/mypage"} element={<MyPage />} />
          <Route path={"/roomselect"} element={<RoomSelect />} />
          <Route path={"/timeselect"} element={<TimeSelect />} />
          <Route path={"/chairselect"} element={<ChairSelect />} />
        </Route>
        <Route path="/*" element={<NotFound />}/>
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
