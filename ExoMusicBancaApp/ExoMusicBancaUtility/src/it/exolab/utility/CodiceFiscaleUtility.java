package it.exolab.utility;

import java.time.LocalDate;

import it.exoBanca.models.Anagrafica;
import it.exolab.costanti.Const;

public class CodiceFiscaleUtility {

	private String codiceFiscale;
	private String voidString = "";

	public CodiceFiscaleUtility(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public static boolean check(Anagrafica anagrafica) {
		return new CodiceFiscaleUtility(anagrafica.getCodiceFiscale()).checkCodiceFiscale(anagrafica);
	}

	private boolean checkCodiceFiscale(Anagrafica anagrafica) {
		return checkPrefix(anagrafica.getNome(), anagrafica.getCognome(), anagrafica.getDataNascita(),anagrafica.getSesso());
	}

	private boolean checkPrefix(String nome, String cognome, LocalDate dataNascita,Character sesso) {
		String prefix = removeVocals(cognome) + removeVocals(nome) +
				Integer.toString(dataNascita.getYear()).substring(2) + generateUnicode(dataNascita,sesso);
		return similarTo(prefix, codiceFiscale);
	}

	private String removeVocals(String param) {
		String noVocalsParam = "";
		for (int i = 0; i < param.length(); i++) {
			noVocalsParam += isNotVocal(param.charAt(i)) ? param.charAt(i) : voidString;
		}
		return noVocalsParam;
	}

	private boolean isNotVocal(char character) {
		character = Character.toLowerCase(character);
		return character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u';
	}

	private boolean similarTo(String prefix, String codiceFiscale) {
		int diff = 0;
		for (int i = 0; i < prefix.length(); i++) {
			diff += prefix.charAt(i) == codiceFiscale.charAt(i) ? 0 : 1;
		}
		return diff < 3;
	}

	private String generateUnicode(LocalDate dataNascita,Character sesso) {
		String unicode = Const.CODICE_FISCALE_LETTERA_MESE[dataNascita.getMonthValue() -1] + (dataNascita.getDayOfMonth() + (sesso == Anagrafica.SESSO_DONNA ? 40 : 0));
		return unicode;
	}

}
