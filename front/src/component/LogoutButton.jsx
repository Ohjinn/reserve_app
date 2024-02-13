import LogoutIcon from '@mui/icons-material/Logout';
import { logout } from '../api/Logout';

const LogoutButton = () => {
    const onClickLogoutButton = async () => {
        const result = await logout();
        console.log(result);
    }
    return <>
        <LogoutIcon
            color="primary"
            aria-label="로그아웃"
            onClick={onClickLogoutButton}
            style={{ marginTop: "50px", marginBottom: "30px", marginRight: "30px", size: "large" }}
        />
    </>
}

export default LogoutButton;