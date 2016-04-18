package servlet.mvc.rest.controller;

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
	@Path("/checkuservalidity")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	public Response isValidUser(LoginBean bean) {
		//if(key.equals(secretKey))
		{
			String response = "";
			response = manager.validateUser(bean);
			if(response.equals(""))
			{
				return Response.ok().entity(String.valueOf("-1")).build();
			}
			else
			{
				return Response.ok().entity(String.valueOf(response)).build();
			}
		}
		/*else
		{
			Response.status(400);
			return Response.ok().build();
		}*/
		
	}
	
	@Path("/availableusername/{username}")
	@GET
	public void availableUsername(@PathParam("username") String username) {
		try{ 
		int empId = Integer.parseInt(username);
	        //logger.info("Request Param empId="+empId);
		 	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
