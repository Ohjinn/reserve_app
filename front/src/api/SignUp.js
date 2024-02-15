import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

export const signup = async (id, password) => {
  try {
    const response = await fetch(API_URL.SIGNUP, {
      method: "POST",
      ...defaultFetchOptions,
      body: JSON.stringify({
        username: id,
        password: password,
      }),
    });

    if (response.status === 400) {
      window.alert("중복된 아이디 입니다.");
      return;
    } else if (response.status === 500) {
      window.alert("서버에 문제가 생겼습니다.");
      return;
    }

    const result = await response.json();
    return { statusCode: response.status, body: result };
  } catch (err) {
    alert("처리 중 문제가 생겼습니다.");
  }
};
