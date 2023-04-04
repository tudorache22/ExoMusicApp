--<ScriptOptions statementTerminator=";"/>

CREATE TABLE conto_corrente (
	numero_conto VARCHAR(20) NOT NULL,
	data_scadenza DATE,
	saldo FLOAT DEFAULT 0,
	PRIMARY KEY (numero_conto)
);

CREATE TABLE anagrafica (
	id_anagrafica INT NOT NULL,
	nome VARCHAR(100),
	cognome VARCHAR(100),
	codice_fiscale VARCHAR(16) NOT NULL,
	luogo_nascita VARCHAR(100),
	provincia VARCHAR(2),
	sesso CHAR(1),
	data_nascita DATE,
	id_utente INT,
	PRIMARY KEY (id_anagrafica)
);

CREATE TABLE hibernate_sequence (
	next_val BIGINT
);

CREATE TABLE utente (
	id_utente INT NOT NULL,
	email VARCHAR(100),
	password VARCHAR(100),
	id_anagrafica INT,
	id_ruolo INT DEFAULT 1,
	PRIMARY KEY (id_utente)
);

CREATE TABLE otp (
	id_otp INT NOT NULL,
	codice VARCHAR(6),
	creazione DATE,
	scadenza DATE,
	id_transazione INT,
	PRIMARY KEY (id_otp)
);

CREATE TABLE transazione (
	id_transazione INT NOT NULL,
	importo FLOAT,
	stato INT,
	tipo_transazione VARCHAR(100),
	data DATE,
	id_utente INT,
	PRIMARY KEY (id_transazione)
);

CREATE TABLE ruolo (
	id_ruolo INT NOT NULL,
	denominazione VARCHAR(100),
	PRIMARY KEY (id_ruolo)
);

CREATE INDEX transazione_FK ON transazione (id_utente ASC);

CREATE INDEX anagrafica_FK ON anagrafica (id_utente ASC);

CREATE INDEX utente_FK_1 ON utente (id_ruolo ASC);

CREATE INDEX utente_FK ON utente (id_anagrafica ASC);

CREATE INDEX otp_FK ON otp (id_transazione ASC);

