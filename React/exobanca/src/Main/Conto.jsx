import React, { useContext, useEffect, useState } from "react";
import { ContoCorrenteContext, UtenteContext } from "../App";

const Conto = () => {
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

}

export default Conto();