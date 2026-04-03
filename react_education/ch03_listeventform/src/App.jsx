import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import List from './List'
import MyTable from './MyTable'
import MyEvent from '../MyEvent'
import MyForm1 from './MyForm1'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <List/>
     <hr/>
     <MyTable/>
     <hr/>
     <MyEvent/>
     <hr/>
     <MyForm1/>
    </>
  )
}

export default App
