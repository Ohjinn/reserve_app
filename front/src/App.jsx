import "./App.css";
import { useState } from "react";
import Router from "./Router";

  
function App() {
  const [count, setCount] = useState(0);

  const name = "호진";

  return (
    <>
      <div>
        <Router></Router>
      </div>
    </>
  );
}

export default App;
