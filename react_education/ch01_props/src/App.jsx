import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import Hello from './Hello'
import Wrapper from './Wrapper'

function App() {

  return (
    <Wrapper>
      <Hello name="Properties 전달" color="red"/>
      <Hello color="blue"/>

      <div className='circle'></div>
    </Wrapper>
  )
}


export default App
