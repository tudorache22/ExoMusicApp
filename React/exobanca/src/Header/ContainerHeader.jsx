import React, { useContext } from "react";
import { useHistory } from "react-router-dom";
import { ConnessoContext, UtenteContext } from "../App";

const ContainerHeader = () => {

    const connessoContext = useContext(ConnessoContext);
    const utenteContext = useContext(UtenteContext);


    const history = useHistory();
    function navigate(path) {
        history.push(path)
    }

    if (connessoContext.connesso === true) {
        return (
            <div>
                <p>Benvenuto {utenteContext.utente.anagrafica.nome}</p>
<<<<<<< HEAD
                <button type="button" className="btn btn-outline-danger" onClick={() => console.log(utenteContext.utente)}>Stampa utente in console</button>
=======
>>>>>>> e7903ff8abd542778dd20b9e914c867e9811a23f
                <label>Vuoi fare il LogOut?</label>
                <button type="text" onClick={() => { connessoContext.setConnesso(false); navigate("/login") }}></button>
            </div>
        )
    }
    else {
        return (
            <div></div>
        )
    }

}

export default ContainerHeader;