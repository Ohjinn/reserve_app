import { API_URL } from "../util/path";
import { defaultFetchOptions } from "../util/option";

export const time = async (locationId) => {
  try {
    const response = await fetch(
      API_URL.LOCATION + "/" + locationId + "/times",
      {
        method: "GET",
        ...defaultFetchOptions,
        headers: {
          ...defaultFetchOptions.headers,
          Authorization: "Bearer " + localStorage.getItem("accessToken"),
        },
      }
    );

    if (response.status === 500) {
      window.alert("서버에 문제가 생겼습니다.");
      return;
    }
    const { timeSummaryDtoList } = await response.json();
    console.log("timeSummaryDtoList", timeSummaryDtoList)
    return { statusCode: response.status, body: timeSummaryDtoList };
  } catch (err) {
    alert("처리 중 문제가 생겼습니다.");
    console.log("요청 실패 :", err);
  }
};
