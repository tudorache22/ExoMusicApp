package it.exolab.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import it.exolab.controllerService.AbbonamentoControllerService;
import it.exolab.interfaces.AbbonamentoInterface;
import it.exolab.models.Abbonamento;

@Named
@SessionScoped
public class AbbonamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2414797046317356295L;
	private Abbonamento abbonamento;
	private List<Abbonamento> listaAbbonamenti;

	@EJB
	AbbonamentoInterface abbonamentoInterface;

	@PostConstruct
	public void init() {
		abbonamento = new Abbonamento();
	}

	public void allAbbonamenti() {
		System.out.println("Sei nel bean abbonamenti");
		AbbonamentoControllerService service = new AbbonamentoControllerService();
		listaAbbonamenti = service.tuttiAbbonamenti();
		System.out.println(listaAbbonamenti);
	}

	public Abbonamento getAbbonamento() {
		return abbonamento;
	}

	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}

	public List<Abbonamento> getListaAbbonamenti() {
		return listaAbbonamenti;
	}

	public void setListaAbbonamenti(List<Abbonamento> listaAbbonamenti) {
		this.listaAbbonamenti = listaAbbonamenti;
	}

}
