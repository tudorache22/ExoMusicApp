package it.exolab.controllerService;

import java.util.List;

import it.exolab.client.ClientAbbonamento;
import it.exolab.converterJson.ConverterJson;
import it.exolab.models.Abbonamento;

public class AbbonamentoControllerService {

	public Abbonamento serviceAbbonamentoBase(Abbonamento abbonamento) {
		String json = new ConverterJson().convertToJson(abbonamento);
		String risposta = new ClientAbbonamento().callAbbonamentoBase(json);
		if (null != risposta) {
			abbonamento = new ConverterJson().convertToAbbonamento(risposta);
			return abbonamento;
		} else {
			System.out.println("non ha funzionato");
			return abbonamento;
		}
	}

	public Abbonamento serviceAbbonamentoExtra(Abbonamento abbonamento) {
		String json = new ConverterJson().convertToJson(abbonamento);
		String risposta = new ClientAbbonamento().callAbbonamentoExtra(json);
		if (null != risposta) {
			abbonamento = new ConverterJson().convertToAbbonamento(risposta);
			return abbonamento;
		} else {
			System.out.println("non ha funzionato");
			return abbonamento;
		}
	}

	public Abbonamento serviceAbbonamentoPremium(Abbonamento abbonamento) {
		String json = new ConverterJson().convertToJson(abbonamento);
		String risposta = new ClientAbbonamento().callAbbonamentoPremium(json);
		if (null != risposta) {
			abbonamento = new ConverterJson().convertToAbbonamento(risposta);
			return abbonamento;
		} else {
			System.out.println("non ha funzionato");
			return abbonamento;
		}
	}

	public List<Abbonamento> tuttiAbbonamenti() {
		String risposta = new ClientAbbonamento().callAllAbbonamenti();
		if (null != risposta) {
			List<Abbonamento> lista = new ConverterJson().convertList(risposta);
			return lista;
		} else {
			System.out.println("non ha funzionato");
			return null;
		}
	}

}
