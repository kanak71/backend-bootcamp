import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom'
import Home from './Home';
import { Container } from './Container';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/*BrowserRouter는 React Router에서 가장 일반적으로 사용되는 라우터 유형중 하나
        HTML의 History API를 사용하여 페이지 전환을 한다*/}
        <BrowserRouter>
          <nav>
            <Link to="/">HOME</Link>
            <Link to="/content">Content</Link>
          </nav>

          <Routes>
            <Route path="/" element={<Home/>}></Route>
            <Route path="/content" element={<Container/>}></Route>
          </Routes>
        </BrowserRouter>
    </>
  )
}

export default App
