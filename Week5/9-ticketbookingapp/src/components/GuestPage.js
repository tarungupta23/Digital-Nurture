import FlightDetails from './FlightDetails';
import LoginButton from './LoginButton';

function GuestPage(props) {
  return (
    <div>
      <h1>Please sign up.</h1>
      <LoginButton onClick={props.onLoginClick} />
      <FlightDetails/>
    </div>
  );
}

export default GuestPage;
