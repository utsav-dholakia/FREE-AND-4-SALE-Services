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

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.beans.RegisterBean;
import servlet.mvc.rest.manager.ProfileManager;
import servlet.mvc.rest.manager.RegisterManager;

@Path("/profileservices")
public class ProfileServises {
	static ProfileManager manager = new ProfileManager();
	static String secretKey = "1234567890"; 
	
	@Path("/getprofile")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//  @Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProfile(LoginBean bean, @HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
		if(key!=null && key.equals(secretKey))
		{
			RegisterBean response = new RegisterBean();
			try{
				
			response = manager.getProfile(bean);
			}catch (Exception e) {
				e.printStackTrace();
				return Response.serverError().status(400).entity(String.valueOf("-1")).build();
			}
			
			return Response.ok().entity(response).build();
		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}	
	}
	
	@Path("/updateprofile")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//  @Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProfile(RegisterBean bean, @HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
		if(key!=null && key.equals(secretKey))
		{
			RegisterBean response = new RegisterBean();
			try{
				
			response = manager.updateNgetProfile(bean);
			}catch (Exception e) {
				e.printStackTrace();
				return Response.serverError().status(400).entity(String.valueOf("-1")).build();
			}
			
			return Response.ok().entity(response).build();
		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}	
	}
}
