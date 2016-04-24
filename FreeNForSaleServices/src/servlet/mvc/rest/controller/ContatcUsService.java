package servlet.mvc.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servlet.mvc.rest.beans.EmailBean;
import servlet.mvc.rest.beans.InventoryBean;
import servlet.mvc.rest.beans.ItemDetailBean;
import servlet.mvc.rest.beans.LoginBean;
import servlet.mvc.rest.manager.ContactUsManager;
 
@Path("/ContatcUsService")
public class ContatcUsService {
	static ContactUsManager manager = new ContactUsManager();
	static String secretKey = "1234567890"; 
	
	
	
	/**
	 * fetch more details of an item.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/SendEmail")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response FetchMoreDetails(EmailBean bean,@HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
        String response="";
		if(key!=null && key.equals(secretKey))
		{
			
			try{
				
				response=	manager.sendEmail(bean);
			}catch(Exception e){
				e.printStackTrace();
				return Response.serverError().status(400).entity(String.valueOf("-1")).build();			}
			return Response.ok().entity(response).build();			

		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
	
	
}
