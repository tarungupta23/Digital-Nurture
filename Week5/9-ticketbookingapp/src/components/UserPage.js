import FlightDetails from './FlightDetails';
import LogoutButton from './LogoutButton';

function UserPage(props) {
  function handleBooking(flight) {
    alert("Ticket booked successfully!");
  }

  return (
    <div>
      <h1>Welcome back!</h1>
      <LogoutButton onClick={props.onLogoutClick} />
      <FlightDetails/>
      <button onClick={handleBooking}>Book Ticket</button>
    </div>
  );
}

export default UserPage;
