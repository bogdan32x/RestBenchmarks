package ro.bogdanmariesan.rest.jaxrs.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import ro.bogdanmariesan.rest.jaxrs.response.GenericResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by bogdan.mariesan on 1/26/2015.
 */
@Component
@Path("/")
public class RestEasyRestController {

    @Path("/benchmark")
    @GET
    @Produces({MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse exampleGet() {
        return new GenericResponse();
    }
}
