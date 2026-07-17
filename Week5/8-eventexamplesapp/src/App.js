import { useState } from 'react';
import './App.css';

function sayWelcome(name) {
  alert("Hello! " + name);
}

function App() {
  const [count, setCount] = useState(0);
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  function increment() {
    setCount(count + 1);
  }

  function decrement() {
    setCount(count - 1);
  }

  function handleClick(e) {
    alert("I was clicked");
  }

  function handleSubmit(e) {
    e.preventDefault();
    const converted = Number(amount) * 80;
    alert("Converting to  " + currency + " Amount is  " + converted);
  }

  return (
    <div>
      <h2>{count}</h2>
      <button onClick={increment}>Increment</button>
      <br/>
      <button onClick={decrement}>Decrement</button>
      <br/>
      <button onClick={() => sayWelcome('Member1')}>Say welcome</button>
      <br/>
      <button onClick={handleClick}>Click on me</button>

      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <label>Amount: </label>
        <input type="text" value={amount} onChange={(e) => setAmount(e.target.value)} />
        <br/><br/>
        <label>Currency: </label>
        <input type="text" value={currency} onChange={(e) => setCurrency(e.target.value)} />
        <br/><br/>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
