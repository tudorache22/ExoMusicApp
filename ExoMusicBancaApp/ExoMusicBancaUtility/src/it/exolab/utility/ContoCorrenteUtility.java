package it.exolab.utility;

import java.time.LocalDateTime;

import it.exoBanca.models.Anagrafica;
import it.exolab.costanti.Const;

public class ContoCorrenteUtility {

	private final String voidString = "";

	public static String getNumeroConto(Anagrafica anagrafica) {
		return new ContoCorrenteUtility().generaContoCorrenteByAnagrafica(anagrafica);
	}

	private String generaContoCorrenteByAnagrafica(Anagrafica anagrafica) {
		int hashCodeId = Math.abs(anagrafica.getIdAnagrafica().hashCode());
		int hashCodeCognome = Math.abs(anagrafica.getCognome().hashCode());
		int hashCodeNascita = Math.abs(anagrafica.getLuogoNascita().hashCode());

		String stringaNumerica = getStringaNumericaConto(hashCodeId,hashCodeCognome,hashCodeNascita);
		String suffisso = getSuffissoConto(anagrafica.getDataNascita());
		return (isItalian() ? Const.PREFISSO_IT : Const.PREFISSO_EE) + stringaNumerica + suffisso;
	}

	private String getStringaNumericaConto(Integer...integers) {
		String number = voidString;
		String result = voidString;

		for(int n:integers) {
			number += n + voidString;
		}

		for(int i = 0;i<15;i++) {
			result += number.charAt(i);
		}
		return result;
	}

	private String getSuffissoConto(LocalDateTime data) {
		char random_1 = Const.CHARS_FOR_CONTO_CORRENTE_1.charAt(data.getDayOfMonth());
		char random_2 = Const.CHARS_FOR_CONTO_CORRENTE_2.charAt(data.getDayOfMonth());
		char random_3 = Const.CHARS_FOR_CONTO_CORRENTE_3.charAt(data.getMonthValue());
		return random_1+voidString+random_2+voidString+random_3;
	}

	private boolean isItalian() {
		//implementare una logica di verifica per controllare se il luogo di nascita corriponde ad un luogo italiano.
		return true;
	}
}
