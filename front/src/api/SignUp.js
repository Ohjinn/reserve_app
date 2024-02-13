import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

export const signup = async (id, password) => {
    try {
        const response = await fetch(API_URL.SIGNUP, {
            method: 'POST',
            ...defaultFetchOptions,
            body: JSON.stringify({
                username: id,
                password: password,
            }),
        }).then((res) => {
            if (res.status === 400) {
                window.alert("중복된 아이디 입니다.")
            } else if (res.status === 500) {
                window.alert("서버에 문제가 생겼습니다.")
            } else {
                return { statusCode: res.status, body: res.json() };
            }
        });
        return response;

    } catch (err) {

        console.log('회원가입 실패 :', err);
    }
};