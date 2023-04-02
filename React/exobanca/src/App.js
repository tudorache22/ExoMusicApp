import logo from './logo.svg';
import './App.css';
import { createContext, useState } from 'react';
import Header from './Header/Header';
import Main from './Main/Main';
import NavBar from './NavBar/NavBar';
import Footer from './Footer/Footer';

export const UtenteContext = createContext();
export const ConnessoContext = createContext();
export const AnagraficaContext = createContext();

function App() {

  const [anagrafica, setAnagrafica] = useState({
    idAnagrafica: "",
    nome: "",
    cognome: "",
    codiceFiscale: "",
    luogoDiNascita: "",
    provincia: "",
    dataNascita: "",
    sesso: ""
  })

  const [utente, setUtente] = useState({
    idUtente: "",
    password: "",
    email: "",
    ruolo: "",
    anagrafica: anagrafica
  })

  const [connesso, setConnesso] = useState(false);

  const connessoContext = {
    connesso: connesso,
    setConnesso: setConnesso
  }

  const anagraficaContext = {
    anagrafica: anagrafica,
    setAnagrafica: setAnagrafica
  }

  const utenteContext = {
    utente: utente,
    setUtente: setUtente
  };


  return (
    <div className='row'>
      <UtenteContext.Provider value={utenteContext}>
        <AnagraficaContext.Provider value={anagraficaContext}>
          <ConnessoContext.Provider value={connessoContext}>
            <div className='col-12'>
              <Header />
            </div>
            <div className='col-12'>
              <NavBar />
            </div>
            <div className='col-12'>
              <Main />
            </div>
            <div className='col-12'>
              <Footer />
            </div>
          </ConnessoContext.Provider>
        </AnagraficaContext.Provider>
      </UtenteContext.Provider>
    </div>
  )
}

export default App;
