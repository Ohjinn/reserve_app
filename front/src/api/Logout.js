import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

// TODO
export const logout = async () => {
    try {
        const response = await fetch(API_URL.LOGOUT, {
          method: "DELETE",
          ...defaultFetchOptions,
          headers: localStorage.getItem("accessToken"),
          body: JSON.stringify({}),
        })
          .then((res) => {
            return { statusCode: res.status, body: res.json() };
          })
          .then(async (res) => {
            return { statusCode: res.statusCode, body: await res.body };
          });
        return response;
      } catch (error) {
        alert("아이디 또는 비밀번호가 잘못됐습니다.");
        console.log("로그인 실패 :", error);
      }
}