import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

export const logout = async () => {
  try {
    const response = await fetch(API_URL.LOGOUT, {
      method: "DELETE",
      ...defaultFetchOptions,
      headers: {
        ...defaultFetchOptions.headers,
        Authorization: "Bearer " + localStorage.getItem("accessToken"),
      },
      body: JSON.stringify({}),
    });
    if (response.status === 204) {
      return { statusCode: response.status, body: response };
    } else {
      window.alert("서버에 문제가 생겼습니다.");
      return;
    }
  } catch (error) {
    alert("처리 중 문제가 생겼습니다.");
  }
};
