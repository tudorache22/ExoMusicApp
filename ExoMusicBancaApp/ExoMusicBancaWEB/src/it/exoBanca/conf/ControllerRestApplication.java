package it.exoBanca.conf;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import it.exoBanca.rest.BancaRiferimentoRest;
import it.exoBanca.rest.ContoUtenteRest;
import it.exoBanca.rest.OtpRest;
import it.exoBanca.rest.TransazioneRest;
import it.exoBanca.rest.UtenteRest;

@ApplicationPath("/rest")
public class ControllerRestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(UtenteRest.class);
		set.add(BancaRiferimentoRest.class);
		set.add(ContoUtenteRest.class);
		set.add(OtpRest.class);
		set.add(TransazioneRest.class);
		return set;
	}

}
