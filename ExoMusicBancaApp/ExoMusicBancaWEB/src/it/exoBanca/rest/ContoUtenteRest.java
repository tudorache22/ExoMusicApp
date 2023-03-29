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
import it.exoBanca.ejbInterfaces.ContoUtenteControllerInterface;
import it.exoBanca.models.ContoUtente;

@Path("/ContoUtenteRest")
public class ContoUtenteRest extends BaseRest<ContoUtente> {

	private ContoUtenteControllerInterface contoUtenteControllerInterface;

	final static Logger logger = Logger.getLogger(ContoUtenteRest.class);

	@POST
	@Path("/insertContoUtente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(ContoUtente contoUtente) {
		logger.info("sei nel ContoUtenteRest insert >>>" + contoUtente);
		try {
			contoUtente = new EJBFactory<ContoUtenteControllerInterface>(ContoUtenteControllerInterface.class).getEJB()
					.insert(contoUtente);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Path("/updateContoUtente")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(ContoUtente contoUtente) {
		logger.info("sei nel ContoUtenteRest update >>>" + contoUtente);
		try {
			contoUtente = new EJBFactory<ContoUtenteControllerInterface>(ContoUtenteControllerInterface.class).getEJB()
					.update(contoUtente);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findContoUtenteById/{idContoUtente}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idContoUtente") Integer idContoUtente) {
		logger.info("sei nel ContoUtenteRest findById >>>" + idContoUtente);
		try {
			ContoUtente contoUtente = new EJBFactory<ContoUtenteControllerInterface>(
					ContoUtenteControllerInterface.class).getEJB().findById(idContoUtente);
			return Response.status(201).entity(contoUtente).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findAllConti")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel ContoUtenteRest findAll >>>");
		try {
			List<ContoUtente> listaConti = new EJBFactory<ContoUtenteControllerInterface>(
					ContoUtenteControllerInterface.class).getEJB().findAll();
			return Response.status(201).entity(listaConti).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/deleteContoUtente")
	@Produces({ "application/json" })
	public Response delete(ContoUtente contoUtente) {
		logger.info("sei nel ContoUtenteRest delete >>>" + contoUtente);
		try {
			new EJBFactory<ContoUtenteControllerInterface>(ContoUtenteControllerInterface.class).getEJB()
					.delete(contoUtente);
			;
			return Response.status(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

}
