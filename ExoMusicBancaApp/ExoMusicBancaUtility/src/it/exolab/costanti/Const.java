package it.exolab.costanti;

public interface Const {

	public static final String MODELS_PROJECT_NAME = "ExoMusicBancaModel";

	//nomi tabelle per findAll
	public static final String TABELLA_ANAGRAFICA = "anagrafica";
	public static final String TABELLA_CONTO_CORRENTE = "conto_corrente";
	public static final String TABELLA_OTP = "otp";
	public static final String TABELLA_TRANSAZIONE = "transazione";
	public static final String TABELLA_UTENTE = "utente";

	public static final String QUERY_LOGIN = "SELECT * FROM utente WHERE email = :placeEmail: AND password = :placePassword:";
}
