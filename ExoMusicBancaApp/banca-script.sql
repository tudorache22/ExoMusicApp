--<ScriptOptions statementTerminator=";"/>

CREATE TABLE anagrafica (
	id_anagrafica INT NOT NULL,
	nome VARCHAR(100),
	cognome VARCHAR(100),
	codice_fiscale VARCHAR(16) NOT NULL,
	luogo_nascita VARCHAR(100),
	provincia VARCHAR(2),
	sesso CHAR(1),
	PRIMARY KEY (id_anagrafica)
);

CREATE TABLE otp (
	id_otp INT NOT NULL,
	codice VARCHAR(6),
	creazione DATE,
	scadenza DATE,
	id_transazione INT,
	PRIMARY KEY (id_otp)
);

CREATE TABLE utente (
	id_utente INT NOT NULL,
	email VARCHAR(100),
	password VARCHAR(100),
	id_anagrafica INT,
	PRIMARY KEY (id_utente)
);

CREATE TABLE transazione (
	id_transazione INT NOT NULL,
	importo FLOAT,
	stato INT,
	tipo_transazione VARCHAR(100),
	data DATE,
	PRIMARY KEY (id_transazione)
);

CREATE TABLE conto_corrente (
	numero_conto VARCHAR(20) NOT NULL,
	data_scadenza DATE,
	saldo FLOAT DEFAULT 0.99,
	PRIMARY KEY (numero_conto)
);

CREATE INDEX otp_FK ON otp (id_transazione ASC);

