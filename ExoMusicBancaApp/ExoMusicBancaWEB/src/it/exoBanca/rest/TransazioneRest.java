package it.exoBanca.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import it.exoBanca.conf.EJBFactory;
import it.exoBanca.ejbInterfaces.TransazioneControllerInterface;
import it.exoBanca.models.Transazione;

@Path("/TransazioneRest")
public class TransazioneRest extends BaseRest<Transazione> {

	final static Logger logger = Logger.getLogger(TransazioneRest.class);

	@Override
	@POST
	@Path("/insertTransazione")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Transazione transazione) {
		logger.info("sei nel TransazioneRest insert >>>" + transazione);
		try {
			transazione = new EJBFactory<TransazioneControllerInterface>(TransazioneControllerInterface.class).getEJB()
					.insert(transazione);
			return getStandardResponse(transazione).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@PUT
	@Path("/updateTransazione")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(Transazione transazione) {
		logger.info("sei nel TransazioneRest update >>>" + transazione);
		try {
			transazione = new EJBFactory<TransazioneControllerInterface>(TransazioneControllerInterface.class).getEJB()
					.update(transazione);
			return getStandardResponse(transazione).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@GET
	@Path("/findTransazioneById/{idTransazione}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idTransazione") Integer idTransazione) {
		logger.info("sei nel TransazioneRest findById >>>" + idTransazione);
		try {
			Transazione transazione = new EJBFactory<TransazioneControllerInterface>(
					TransazioneControllerInterface.class).getEJB().findById(idTransazione);
			return getStandardResponse(transazione).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@GET
	@Path("/findAllTransazioni")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel TransazioneRest findAll >>>");
		try {
			List<Transazione> listaTransazioni = new EJBFactory<TransazioneControllerInterface>(
					TransazioneControllerInterface.class).getEJB().findAll();
			return getStandardResponse(listaTransazioni).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@DELETE
	@Path("/deleteTransazione")
	@Produces({ "application/json" })
	public Response delete(Transazione transazione) {
		logger.info("sei nel TransazioneRest delete >>>" + transazione);
		try {
			new EJBFactory<TransazioneControllerInterface>(TransazioneControllerInterface.class).getEJB()
					.delete(transazione);
			;
			return getStandardResponse(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
}
