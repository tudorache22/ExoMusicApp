import React from "react";

const ModalMovimento = (props) => {

    return (
        <div className="modal-dialog modal-dialog-centered">
            <div className="modal-content">
                <div className="modal-header">
                    <h3>Info Movimento</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div className="modal-body">
                    <p>Importo: {props.importo}</p>
                    <p>Stato: {props.stato}</p>
                    <p>Tipo Transazione: {props.tipoTransazione}</p>
                    <p>Data: {props.data}</p>
                </div>
            </div>
        </div>
    )

}

export default ModalMovimento;