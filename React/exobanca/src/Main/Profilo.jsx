import React, { useContext } from "react";
import { UtenteContext } from "../App";

const Profilo = () => {
    const utenteContext = useContext(UtenteContext);
    const anagrafica = utenteContext.utente.anagrafica;

    return (
        <div>
            <form style={{ fontSize: "30px" }}>
                nome : {anagrafica.nome}<br />
                cognome : {anagrafica.cognome}<br />
                luogo nascita : {anagrafica.luogoNascita}<br />
                data nascita : {anagrafica.dataNascita}<br />
                provincia : {anagrafica.provincia}<br />
                sesso : {anagrafica.sesso}
            </form>
        </div >
    )

}

export default Profilo;