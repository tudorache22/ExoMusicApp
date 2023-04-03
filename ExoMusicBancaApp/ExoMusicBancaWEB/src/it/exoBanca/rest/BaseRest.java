package it.exoBanca.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.CorsHeaders;

public abstract class BaseRest<T> {

	abstract Response insert(T model);

	abstract Response update(T model);

	abstract Response findById(Integer idModel);

	abstract Response findAll();

	abstract Response delete(T model);

	private final String ACCEPT_ALL = "*";
	private final String CONTENT_TYPE = "Content-type";

	private ResponseBuilder setHeader(ResponseBuilder response) {
		return response.header(CorsHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,ACCEPT_ALL)
		.header(CorsHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST,PUT,DELETE,GET")
		.header(CorsHeaders.ACCESS_CONTROL_ALLOW_HEADERS, CONTENT_TYPE);

	}

	protected ResponseBuilder getStandardResponse(T entity) {
		ResponseBuilder response = Response.status(201);
		return setHeader(response).entity(entity);

	}
	protected ResponseBuilder getStandardResponse(List<T> entity) {
		ResponseBuilder response = Response.status(201);
		return setHeader(response).entity(entity);
	}
	protected ResponseBuilder getStandardResponse(Integer statusCode) {
		ResponseBuilder response = Response.status(statusCode);
		return setHeader(response);
	}

}
