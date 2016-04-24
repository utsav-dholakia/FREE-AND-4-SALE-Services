package servlet.mvc.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servlet.mvc.rest.beans.RegisterBean;
import servlet.mvc.rest.manager.RegisterManager;

@Path("/registrationservices")
public class RegisterServices {
	static RegisterManager manager = new RegisterManager();
	static String secretKey = "1234567890"; 
	
	@Path("/newregistration")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	public Response addUser(RegisterBean bean, @HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
		if(key!=null && key.equals(secretKey))
		{
			String response = "";
			try{
				
			response = manager.enrollUser(bean);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			Response.status(400);
			return Response.ok().entity(response).build();
			
		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}	
	}
}
