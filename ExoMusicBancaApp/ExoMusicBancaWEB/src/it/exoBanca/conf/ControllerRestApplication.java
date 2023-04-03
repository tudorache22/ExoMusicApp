package it.exoBanca.conf;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import it.exoBanca.rest.AnagraficaRest;
import it.exoBanca.rest.ContoCorrenteRest;
import it.exoBanca.rest.OtpRest;
import it.exoBanca.rest.TransazioneRest;
import it.exoBanca.rest.UtenteRest;

@ApplicationPath("/rest")
public class ControllerRestApplication extends Application {

	private Set<Class<?>> classes;
	private Set<Object> singletons;

	public ControllerRestApplication() {
		super();
		CorsFilter corsFilter = new CorsFilter();
		corsFilter.getAllowedOrigins().add("*");
		corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");

		singletons = new HashSet<Object>();
		singletons.add(corsFilter);

		classes = new HashSet<>();
		classes.add(UtenteRest.class);
		classes.add(AnagraficaRest.class);
		classes.add(ContoCorrenteRest.class);
		classes.add(OtpRest.class);
		classes.add(TransazioneRest.class);

	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
