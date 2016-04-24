package servlet.mvc.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servlet.mvc.rest.beans.CartBean;
import servlet.mvc.rest.beans.ReviewBean;
import servlet.mvc.rest.manager.ReviewManager;
 
@Path("/ReviewServices")
public class ReviewServices {
	static ReviewManager manager = new ReviewManager();
	static String secretKey = "1234567890"; 
	
	
	/**
	 * get Cart.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/getReviews")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getCart(@HeaderParam("secretKey")String key,CartBean bean) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
        Map<Integer, ReviewBean> reviews=new HashMap<Integer, ReviewBean>();
        if(key!=null && key.equals(secretKey))
		{
			
			try{
				reviews=manager.getReviews(bean);
			}catch(Exception e){
				e.printStackTrace();
				return Response.serverError().status(400).entity(String.valueOf("-1")).build();

			}
			
			return Response.ok().entity(reviews).build();
		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
	
	/**
	 * get Cart.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/saveReviews")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response saveReviews(@HeaderParam("secretKey")String key,List<ReviewBean> bean) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
        Map<Integer, ReviewBean> reviews=new HashMap<Integer, ReviewBean>();
        if(key!=null && key.equals(secretKey))
		{
			try{
				reviews=manager.saveReviews(bean);
			}catch(Exception e){
				e.printStackTrace();
				return Response.serverError().status(400).entity(String.valueOf("-1")).build();

			}
			
			return Response.ok().entity(reviews).build();
		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
}
