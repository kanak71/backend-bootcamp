import { useState, useRef } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import MyComponent from './MyComponent'
import Counter from './Counter'
import Variable from './Variable'

function App() {

  //DOM 탐색이 된 객체, document.getElementByID("id").value;
  // useRef 객체는 .current.value
  const inputRef = useRef();

  const loginAlert = ()=>{
    alert(`환영합니다. ${inputRef.current.value}`);
    inputRef.current.focus();
  }

  return (
    <>
      <MyComponent/>
      <Counter/>
      <hr/>
      <input ref={inputRef}/>
      <button onClick={loginAlert}>아이디 출력 후 input focus</button>
      <hr/>
      <Variable/>
    </>
  )
}

export default App
