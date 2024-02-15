import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { deleteReservation } from "../api/DeleteReservation";

const ReservationListItem = ({ item }) => {

  const onClickCancelButton = async (reservationId) => {
    const result = await deleteReservation(reservationId)
    window.location.reload()
  }
  const timeConverter = (time) => {
    let date = new Date(time);

    let month = date.getMonth() + 1; // getMonth()는 0부터 시작하기 때문에 1을 더해줍니다.
    let day = date.getDate();
    let hours = date.getHours();
    let minutes = date.getMinutes();

    let formattedDateTime = `${month}월 ${day}일 ${hours}:${
      minutes < 10 ? `0${minutes}` : minutes
    }`; // 분이 10보다 작을 경우 앞에 0.

    return formattedDateTime;
  };
  return (
    <Card
      sx={{
        minWidth: 275,
        margin: "10px",
        padding: "5px",
        borderRadius: "20px",
      }}
    >
      <CardContent>
        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
          {item.locationName} {item.chairName}번 의자
        </Typography>
        <Typography sx={{ fontSize: 14 }}>
          {timeConverter(item.reservationDateTime)}
        </Typography>
      </CardContent>
      <CardActions style={{ justifyContent: "right" }}>
        <Button variant="outlined" size="small" onClick={() => {onClickCancelButton(item.reservationId)}}>
          취소
        </Button>
      </CardActions>
    </Card>
  );
};

export default ReservationListItem;
