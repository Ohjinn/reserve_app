import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";

const ReservationListItem = ({ item }) => {
  return (
    <Card sx={{ minWidth: 275, margin: "10px", padding: "5px", borderRadius: "20px"}}>
      <CardContent>
        <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
          {item.locationName} {item.chairName}번 의자
        </Typography>
        <Typography sx={{ fontSize: 14 }}>
          {item.reservationDatetime}
        </Typography>
      </CardContent>
      <CardActions style={{ justifyContent: "right" }}>
        <Button variant="outlined" size="small">
          취소
        </Button>
      </CardActions>
    </Card>
  );
};

export default ReservationListItem;
