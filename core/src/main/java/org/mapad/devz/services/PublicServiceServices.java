package org.mapad.devz.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mapad.devz.bl.RepositoryImplHanlder;
import org.mapad.devz.bl.repository.RepositoryImpl;
import org.mapad.devz.models.PublicService;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

@Path("/publicserviceservices")
public class PublicServiceServices {
	private static RepositoryImpl<PublicService> _publicServiceRepository = 
			new RepositoryImplHanlder<PublicService>(PublicService.class).getRepository();
	
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllServices() throws Throwable {
//    	Swagger swagger = new SwaggerParser().read("http://petstore.swagger.io/v2/swagger.json");
//    	
//    	PublicService pc = new PublicService();
//    	Map<String, Swagger> versions = new HashMap<String, Swagger>();
//    	versions.put("aa|aa", swagger);
//    	pc.setVersions(versions);
//    	pc.setPublicBranch("branch");
//    	_publicServiceRepository.create(pc);
//    	return Response.ok("saved").build();
        return Response.ok(_publicServiceRepository.all()).build();
    }
    
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrUpdateService() {
        return Response.ok("blabla2").build();
    }
}
