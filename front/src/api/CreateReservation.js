import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

export const createReservation = async (time, location, chairId) => {
  const timeList = time.split(":");
  console.log("datas : ", location, chairId, timeList[0], timeList[1])
  try {
    const response = await fetch(API_URL.MYPAGE, {
      method: "POST",
      ...defaultFetchOptions,
      headers: {
        ...defaultFetchOptions.headers,
        Authorization: "Bearer " + localStorage.getItem("accessToken"),
      },
      body: JSON.stringify({
        locationId: location,
        chairId: chairId,
        hour: timeList[0],
        minute: timeList[1],
      }),
    })
      .then((res) => {
        console.log(res)
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
};
