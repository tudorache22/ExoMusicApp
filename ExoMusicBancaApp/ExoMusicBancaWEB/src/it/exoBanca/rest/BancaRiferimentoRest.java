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
import it.exoBanca.ejbInterfaces.BancaRiferimentoControllerInterface;
import it.exoBanca.models.BancaRiferimento;

@Path("/BancaRifermentoRest")
public class BancaRiferimentoRest extends BaseRest<BancaRiferimento> {

	private BancaRiferimentoControllerInterface bancaRiferimentoControllerInterface;

	final static Logger logger = Logger.getLogger(BancaRiferimentoRest.class);

	@POST
	@Path("/insertBancaRiferimento")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(BancaRiferimento bancaRiferimento) {
		logger.info("sei nel BancaRiferimentoRest insert >>>" + bancaRiferimento);
		try {
			bancaRiferimentoControllerInterface = new EJBFactory<BancaRiferimentoControllerInterface>(
					BancaRiferimentoControllerInterface.class).getEJB();
			bancaRiferimento = bancaRiferimentoControllerInterface.insert(bancaRiferimento);
			return Response.status(201).entity(bancaRiferimento).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Path("/updateBancaRiferimento")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(BancaRiferimento bancaRiferimento) {
		logger.info("sei nel BancaRiferimentoRest update >>>" + bancaRiferimento);
		try {
			bancaRiferimento = new EJBFactory<BancaRiferimentoControllerInterface>(
					BancaRiferimentoControllerInterface.class).getEJB().update(bancaRiferimento);
			return Response.status(201).entity(bancaRiferimento).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findBancaRiferimentoById/{idBancaRiferimento}")
	@Produces({ "application/json" })
	public Response findById(@PathParam("idBancaRiferimento") Integer idBancaRiferimento) {
		logger.info("sei nel BancaRiferimentoRest findById >>>" + idBancaRiferimento);
		try {
			BancaRiferimento bancaRiferimento = new EJBFactory<BancaRiferimentoControllerInterface>(
					BancaRiferimentoControllerInterface.class).getEJB().findById(idBancaRiferimento);
			return Response.status(201).entity(bancaRiferimento).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/findAllBanche")
	@Produces({ "application/json" })
	public Response findAll() {
		logger.info("sei nel BancaRiferimentoRest findAll >>>");
		try {
			BancaRiferimentoControllerInterface bancaRiferimentoControllerInterface = new EJBFactory<BancaRiferimentoControllerInterface>(
					BancaRiferimentoControllerInterface.class).getEJB();
			List<BancaRiferimento> listaBanche = bancaRiferimentoControllerInterface.findAll();
			return Response.status(201).entity(listaBanche).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@DELETE
	@Path("/deleteBancaRiferimento")
	@Produces({ "application/json" })
	public Response delete(BancaRiferimento bancaRiferimento) {
		logger.info("sei nel BancaRiferimentoRest delete >>>" + bancaRiferimento);
		try {
			new EJBFactory<BancaRiferimentoControllerInterface>(BancaRiferimentoControllerInterface.class).getEJB()
					.delete(bancaRiferimento);
			;
			return Response.status(202).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
}
