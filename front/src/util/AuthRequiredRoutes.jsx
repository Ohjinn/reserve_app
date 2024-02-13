import { Navigate, Outlet } from 'react-router-dom';

const AuthRequiredRoutes = () => {
    return localStorage.getItem('accessToken')? <Outlet /> : <Navigate to={"/"} />;
  };
  
  export default AuthRequiredRoutes;