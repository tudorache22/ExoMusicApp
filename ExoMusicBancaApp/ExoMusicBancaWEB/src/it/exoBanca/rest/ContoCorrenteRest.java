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
import it.exoBanca.ejbInterfaces.ContoCorrenteControllerInterface;
import it.exoBanca.ejbInterfaces.UtenteControllerInterface;
import it.exoBanca.models.ContoCorrente;
import it.exoBanca.models.Utente;
import it.exolab.utility.ContoCorrenteUtility;

@Path("/ContoCorrenteRest")
public class ContoCorrenteRest extends BaseRest<ContoCorrente> {

	final static Logger logger = Logger.getLogger(ContoCorrenteRest.class);

	@Override
	@POST
	@Path("/insertContoCorrente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(ContoCorrente contoCorrente) {
		logger.info("sei nel ContoCorrenteRest insert >>>" + contoCorrente);
		try {
			contoCorrente = new EJBFactory<ContoCorrenteControllerInterface>(ContoCorrenteControllerInterface.class)
					.getEJB().insert(contoCorrente);
			return getStandardResponse(contoCorrente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@PUT
	@Path("/updateContoCorrente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(ContoCorrente contoCorrente) {
		logger.info("sei nel ContoCorrenteRest update >>>" + contoCorrente);
		try {
			contoCorrente = new EJBFactory<ContoCorrenteControllerInterface>(ContoCorrenteControllerInterface.class)
					.getEJB().update(contoCorrente);
			return getStandardResponse(contoCorrente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@GET
	@Path("/findByIdUtente/{idUtente}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idUtente") Integer idUtente) {
		logger.info("sei nel ContoCorrenteRest findByIdUtente >>>" + idUtente);
		try {
			Utente utente = new EJBFactory<UtenteControllerInterface>(UtenteControllerInterface.class).getEJB().findById(idUtente);
			ContoCorrente contoCorrente = new EJBFactory<ContoCorrenteControllerInterface>(ContoCorrenteControllerInterface.class)
					.getEJB().findByNumeroConto(ContoCorrenteUtility.getNumeroConto(utente.getAnagrafica()));
			return getStandardResponse(contoCorrente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@GET
	@Path("/findAllConti")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel ContoCorrenteRest findAll >>>");
		try {
			List<ContoCorrente> listaConti = new EJBFactory<ContoCorrenteControllerInterface>(
					ContoCorrenteControllerInterface.class).getEJB().findAll();
			return getStandardResponse(listaConti).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@Override
	@DELETE
	@Path("/deleteContoCorrente")
	@Produces({ "application/json" })
	public Response delete(ContoCorrente contoCorrente) {
		logger.info("sei nel ContoCorrenteRest delete >>>" + contoCorrente);
		try {
			new EJBFactory<ContoCorrenteControllerInterface>(ContoCorrenteControllerInterface.class).getEJB()
					.delete(contoCorrente);
			;
			return getStandardResponse(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
