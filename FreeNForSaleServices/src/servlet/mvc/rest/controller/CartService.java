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
import servlet.mvc.rest.beans.UpdateCartBean;
import servlet.mvc.rest.beans.ViewCartBean;
import servlet.mvc.rest.manager.CartManager;
 
@Path("/CartService")
public class CartService {
	static CartManager manager = new CartManager();
	static String secretKey = "1234567890"; 
	
	
	/**
	 * Add to Cart.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/addToCart")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response addToCart(@HeaderParam("secretKey")String key,CartBean bean) throws URISyntaxException {
        URI tempRedirect=new URI("../error.jsp");
        String response = "success";
		if(key!=null && key.equals(secretKey))
		{
			
			try{
				
				manager.addToCart(bean);
			}catch(Exception e){
				e.printStackTrace();
				return Response.serverError().status(400).entity(String.valueOf("-1")).build();

			}
			
			return Response.ok().entity(String.valueOf(response)).build();
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
	@Path("/getCart")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getCart(@HeaderParam("secretKey")String key,CartBean bean) throws URISyntaxException {
        URI tempRedirect=new URI("../error.jsp");
        List<ViewCartBean> cartList=new ArrayList<ViewCartBean>();
        if(key!=null && key.equals(secretKey))
		{
			
			try{
				cartList=manager.getCart(bean);
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
	
	/**
	 * Update Cart.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/saveUpdateCart")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response saveUpdateCart(@HeaderParam("secretKey")String key,UpdateCartBean bean) throws URISyntaxException {
        URI tempRedirect=new URI("../error.jsp");
        String response = "success";

        if(key!=null && key.equals(secretKey))
		{
			
			try{
			manager.saveUpdate(bean);
			}catch(Exception e){
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
	
	/**
	 * Purchase Cart.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/purchaseCart")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response purchaseCart(@HeaderParam("secretKey")String key,UpdateCartBean bean) throws URISyntaxException {
        URI tempRedirect=new URI("../error.jsp");
        String response = "success";

        if(key!=null && key.equals(secretKey))
		{
			
			try{
			response =manager.purchaseCart(bean);
			}catch(Exception e){
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
