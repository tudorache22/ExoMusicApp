package it.exoBanca.conf;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import it.exoBanca.models.Anagrafica;
import it.exoBanca.rest.ContoCorrenteRest;
import it.exoBanca.rest.OtpRest;
import it.exoBanca.rest.TransazioneRest;
import it.exoBanca.rest.UtenteRest;

@ApplicationPath("/rest")
public class ControllerRestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(UtenteRest.class);
		set.add(Anagrafica.class);
		set.add(ContoCorrenteRest.class);
		set.add(OtpRest.class);
		set.add(TransazioneRest.class);
		return set;
	}

}
