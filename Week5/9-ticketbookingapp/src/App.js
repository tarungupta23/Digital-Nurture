import { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  function handleLoginClick() {
    setIsLoggedIn(true);
  }

  function handleLogoutClick() {
    setIsLoggedIn(false);
  }

  return (
    <div>
      {isLoggedIn ? (
        <UserPage onLogoutClick={handleLogoutClick} />
      ) : (
        <GuestPage onLoginClick={handleLoginClick} />
      )}
    </div>
  );
}

export default App;
