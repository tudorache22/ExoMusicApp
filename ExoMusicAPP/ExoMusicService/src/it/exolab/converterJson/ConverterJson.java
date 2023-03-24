package it.exolab.converterJson;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.exolab.models.Abbonamento;

public class ConverterJson {

	public Abbonamento convertToAbbonamento(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Abbonamento abbonamento = mapper.readValue(json, Abbonamento.class);
			return abbonamento;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String convertToJson(Abbonamento abbonamento) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(abbonamento);
			return json;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Abbonamento> convertList(String json) {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("converto: " + json);

		try {
			List<Abbonamento> lista = mapper.readValue(json, new TypeReference<List<Abbonamento>>() {
			});
			return lista;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
