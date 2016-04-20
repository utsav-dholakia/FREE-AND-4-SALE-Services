package servlet.mvc.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.manager.LoginManager;
 
@Path("/loginservices")
public class LoginServices {
	static LoginManager manager = new LoginManager();
	static String secretKey = "1234567890"; 
	
	
	/**
	 * Service to Validate user.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/checkuservalidity")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	public Response isValidUser(LoginBean bean, @HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
		if(key!=null && key.equals(secretKey))
		{
			String response = "";
			try{
				
			response = manager.validateUser(bean);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(response.equals("-1"))
			{
				Response.status(400);
				return Response.ok().entity(String.valueOf(response)).build();			}
			else
			{
				return Response.ok().entity(String.valueOf(response)).build();
			}
		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
	
	@Path("/availableusername/{username}")
	@GET
	public void availableUsername(@PathParam("username") String username) {
		try{ 
		int empId = Integer.parseInt(username);
	        //logger.info("Request Param empId="+empId);
		 	System.out.println("in");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
