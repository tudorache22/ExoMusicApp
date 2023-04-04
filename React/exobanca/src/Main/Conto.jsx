import React, { useContext, useEffect, useState } from "react";
import { ConnessoContext, ContoCorrenteContext, UtenteContext } from "../App";

const Conto = () => {
<<<<<<< HEAD
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
=======
    // const utenteContext = useContext(UtenteContext);
    // const contoCorrenteContext = useContext(ContoCorrenteContext);
    // const [movimenti, setMovimenti] = useState([]);
    // const URIconto = "" + utenteContext.utente.idUtente;
    // const URImovimenti = "" + utenteContext.utente.idUtente;
    // var costanteIndex = 0;

    // function trovaConto() {
    //     fetch(URIconto, {
    //         method: "GET",
    //         headers: {
    //             'Content-type': 'application/json;charset=UTF-8'
    //         }
    //     }).then(responseJson => responseJson.json())
    //         .then(response => {
    //             console.log(response);
    //             contoCorrenteContext.setContoCorrente(response);
    //         })
    //         .catch(error => {
    //             console.log(error);
    //         })
    // }

    // function trovaMovimenti() {

    //     fetch(URImovimenti, {
    //         method: "GET",
    //         headers: {
    //             'Content-type': 'application/json;charset=UTF-8'
    //         }
    //     }).then(responseJson => responseJson.json())
    //         .then(response => {
    //             setMovimenti(response);
    //         })
    //         .catch(error => {
    //             console.log(error);
    //         })

    // }


    // useEffect(() => {
    //     trovaConto();
    //     trovaMovimenti();
    // }, []);

    // return (
    //     <div>
    //         <form>
    //             <h1>Il tuo Conto</h1>
    //             <p>conto:</p>
    //             <b>{contoCorrenteContext.conto.numeroConto}</b>
    //             <h4>Il tuo conto attuale è di </h4>
    //             <h2>{contoCorrenteContext.conto.saldo}</h2>
    //         </form>
    //         <form>
    //             <table>
    //                 <thead>
    //                     <tr>
    //                         <th scope="col">#</th>
    //                         <th scope="col">Importo</th>
    //                         <th scope="col">Stato</th>
    //                         <th scope="col">Info</th>
    //                     </tr>
    //                 </thead>
    //             </table>
    //             {movimenti.length > 0 ?
    //                 <tbody>
    //                     {movimenti.map(movimento => {
    //                         <tr>
    //                             <th>{costanteIndex + 1}</th>
    //                             <td>{movimento.importo}</td>
    //                             <td>{movimento.stato}</td>
    //                             <button>Info</button>
    //                         </tr>
    //                     })}

    //                 </tbody> :

    //                 <div>
    //                     <p>Non ci sono movimenti</p>
    //                 </div>}

    //         </form>
    //     </div>
    // )
>>>>>>> e7903ff8abd542778dd20b9e914c867e9811a23f

}

export default Conto;