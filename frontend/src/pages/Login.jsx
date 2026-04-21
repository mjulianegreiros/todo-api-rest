import { useState } from 'react'
function Login(){
    const [email , setEmail] = useState('')
    const [password , setPassword] = useState('')
    return(
        <form action="" method="post">
            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder='Digite seu email'/>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder='Digite sua senha'/>
            <button type="submit">Enviar</button>
            <button type="button">Ainda não tem conta? Registe-se!</button>
        </form>
    )
}

export default Login