import React, { useContext, useState } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, UtenteContext } from "../App";

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const URI = "http://localhost:8080/login";
    const utenteContext = useContext(UtenteContext);
    const connessoContext = useContext(ConnessoContext);

    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }

    function saveUtente() {
        let requestBody = {
            email: email,
            password: password
        }
        fetch(URI, {
            method: "POST",
            body: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                if (null !== response && response !== "") {
                    connessoContext.setConnesso(true);
                    console.log(response)
                    console.log(connessoContext.connesso)
                    utenteContext.setUtente(response);
                    console.log(utenteContext.utente)
                    navigate("/home")
                }

            }).catch(error => {
                console.error(error);
            })
    }

    return (
        <form>
            <label for="emailLogin">Email: </label>
            <input type="text" placeholder="Inserisc la tua email" id="emailLogin" value={email} onChange={(e) => setEmail(e.target.value)} />
            <label for="passwordLogin">Password:</label>
            <input type="text" placeholder="Inserisci la password" id="passwordLogin" value={password} onChange={(e) => setPassword(e.target.value)} />
            <button type="button" className="btn btn-outline-danger" onClick={() => saveUtente()}>Accedi</button>

            <label for="">Non hai un account?</label>
            <button type="button" className="btn btn-outline-danger" onClick={() => navigate("/register")}>Registrati</button>
        </form >
    )



}

export default Login;