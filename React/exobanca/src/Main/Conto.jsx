import React, { useContext, useEffect, useState } from "react";
import { ConnessoContext, ContoCorrenteContext, UtenteContext } from "../App";

const Conto = () => {
    const connessoContext = useContext(ConnessoContext);
    const [transazioni, setTransazioni] = useState([]);
    const URIconto = "http://127.0.0.1:8080/ExoMusicBancaWEB-0.0.1-SNAPSHOT/rest/ContoCorrenteRest/findByIdUtente/";
    const URImovimenti = "";
    const utenteContext = useContext(UtenteContext);
    const contoCorrenteContext = useContext(ContoCorrenteContext);

    function trovaConto() {
        fetch(URIconto + utenteContext.utente.idUtente, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                console.log(response);
                contoCorrenteContext.setContoCorrente(response);
            })
            .catch(error => {
                console.log(error);
            })
    }

    function trovaTransazioni() {

        fetch(URImovimenti + utenteContext.utente.idUtente, {
            method: "GET",
            headers: {
                'Content-type': 'application/json;charset=UTF-8'
            }
        }).then(responseJson => responseJson.json())
            .then(response => {
                setTransazioni(response);
            })
            .catch(error => {
                console.log(error);
            })

    }

    useEffect(() => {
        trovaConto();
        trovaTransazioni();
    }, []);

    return connessoContext.connesso ? (
        <div>
            <form>
                <h1>Il tuo Conto</h1>
                <h2>{contoCorrenteContext.contoCorrente.numeroConto}</h2>

                <h4>Il tuo saldo attuale è di {contoCorrenteContext.contoCorrente.saldo} €</h4>

            </form>
            <form>
                <table>
                    <thead>
                        <tr>
                            <th scope="col">Importo</th>
                            <th scope="col">Stato</th>
                            <th scope="col">Info</th>
                        </tr>
                    </thead>
                </table>
                {transazioni.length > 0 ?
                    <div>
                        {transazioni.map}

                    </div> :

                    <div>
                    </div>}

            </form>
        </div>
    )
        : (
            <div>

                <p>non connesso</p>
            </div>
        )

}

export default Conto;