import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

export const location = async () => {
  try {
    const response = await fetch(API_URL.LOCATION, {
      method: "GET",
      ...defaultFetchOptions,
      headers: {
        ...defaultFetchOptions.headers,
        Authorization: "Bearer " + localStorage.getItem("accessToken"),
      },
    });

    if (response.status === 500) {
      window.alert("서버에 문제가 생겼습니다.");
      return;
    }
    const { locationSummaryDto } = await response.json();
    return { statusCode: response.status, body: locationSummaryDto };
  } catch (err) {
    alert("처리 중 문제가 생겼습니다.");
    console.log("요청 실패 :", err);
  }
};
