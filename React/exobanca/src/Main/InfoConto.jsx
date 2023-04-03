import React, { useContext } from "react";
import { ConnessoContext, ContoCorrenteContext, UtenteContext } from "../App";

const InfoConto = () => {

    const contoCorrenteContext = useContext(ContoCorrenteContext);
    const utenteContext = useContext(UtenteContext);

    if (contoCorrenteContext.contoCorrente !== null) {
        return (
            <form>
                <h2>Conto Corrente</h2>
                <p>Il tuo conto:</p>
                <b>{contoCorrenteContext.contoCorrente.numeroConto}</b>
                <p>Il tuo saldo attuale è di:</p>
                <h1>{contoCorrenteContext.contoCorrente.saldo}</h1>
            </form>
        )
    }
    else {
        return (
            <form>
                <p>Conto Corrente non attivato</p>
            </form>
        )
    }


}

export default InfoConto;