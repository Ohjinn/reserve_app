import { Navigate, Outlet } from 'react-router-dom';

const AuthManageRoutes = () => {
    return localStorage.getItem('accessToken') ? <Navigate to={"/main"} /> : <Outlet />;
  };
  
  export default AuthManageRoutes;