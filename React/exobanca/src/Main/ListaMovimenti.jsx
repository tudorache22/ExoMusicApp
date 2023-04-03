import React, { useContext, useEffect, useState } from "react";
import { UtenteContext } from "../App";

const ListaMovimenti = () => {

    const utenteContext = useContext(UtenteContext);
    const URI = "" + utenteContext.utente.idUtente;
    const [listaTransazioni, setListaTransazioni] = useState([]);

    function cercaMovimenti() {
        fetch(URI, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                setListaTransazioni(response);
            })
    };

    useEffect(() => {
        cercaMovimenti();
    }, []);


    return (
        <div>

        </div>
    )


}

export default ListaMovimenti;