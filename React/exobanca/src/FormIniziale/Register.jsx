import React, { Component, useContext, useState } from "react";
import { useHistory } from "react-router-dom";
import { AnagraficaContext, ConnessoContext, UtenteContext } from "../App";


const Register = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const URIutente = "http://localhost:8080/ExoMusicBancaWEB-0.0.1-SNAPSHOT/rest/UtenteRest/insertUtente";

    const utenteContext = useContext(UtenteContext);
    const connessoContext = useContext(ConnessoContext);
    const anagraficaContext = useContext(AnagraficaContext);

    const history = useHistory();

    function navigate(path) {
        history.push(path);
    }


    function saveUtente() {
        let requestBody = {
            anagrafica: anagraficaContext.anagrafica,
            email: email,
            password: password
        };
        console.log(requestBody);
        fetch(URIutente, {
            method: "POST",
            requestBody: JSON.stringify(requestBody),
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                if (null != response) {
                    utenteContext.setUtente(response);
                    connessoContext.setConnesso(true);
                    navigate("/home");
                }
            })
            .catch(error => {
                console.error(error);
            })
    }

    return (

        <form>
            <label for="emailRegister">Email:</label>
            <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} id="emailRegister" />
            <label for="passwordRegister">Password:</label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} id="passwordRegister" />

            <button type="button" className="btn btn-outline-danger" onClick={() => saveUtente()} >Registrati</button>
            <label for="bottoneLogin">Hai già un account?</label>
            <button type="button" className="btn btn-outline-danger" onClick={() => navigate("/login")}> Accedi</button>
        </form>
    )


}

export default Register;