import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

export const deleteReservation = async (reservationId) => {
  try {
    const response = await fetch(API_URL.MYPAGE + '/' + reservationId, {
      method: "DELETE",
      ...defaultFetchOptions,
      headers: {
        ...defaultFetchOptions.headers,
        Authorization: "Bearer " + localStorage.getItem("accessToken"),
      },
      body: JSON.stringify({}),
    });
    console.log('response', response);
    if (response.status === 200) {
      return { statusCode: response.status, body: response };
    } else {
      window.alert("서버에 문제가 생겼습니다.");
      return;
    }
  } catch (error) {
    alert("처리 중 문제가 생겼습니다.");
    console.log("로그아웃 실패 :", error);
  }
};
