import { useState } from 'react'
import {BrowserRouter , Routes , Route} from 'react-router-dom'
import Login from './pages/Login.jsx'
import Register from './pages/Register.jsx'
import Todos from './pages/Todos.jsx'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <BrowserRouter>
      <Routes>
        <Route path='/login' element={<Login/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/todos' element={<Todos/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
