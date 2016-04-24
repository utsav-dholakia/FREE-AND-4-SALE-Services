package servlet.mvc.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servlet.mvc.rest.beans.CartBean;
import servlet.mvc.rest.beans.ViewCartBean;
import servlet.mvc.rest.manager.TransactionManager;
 
@Path("/TransactionService")
public class TransactionService {
	static TransactionManager manager = new TransactionManager();
	static String secretKey = "1234567890"; 
	
	
	
	/**
	 * get Cart.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/getTransactionHistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionHistory(@HeaderParam("secretKey")String key,CartBean bean) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
        List<ViewCartBean> cartList=new ArrayList<ViewCartBean>();
        if(key!=null && key.equals(secretKey))
		{
			
			try{
				cartList=manager.getTransHistory(bean);
			}catch(Exception e){
				e.printStackTrace();
				return Response.serverError().status(400).entity(String.valueOf("-1")).build();

			}
			
			return Response.ok().entity(cartList).build();
		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
	
	
}
