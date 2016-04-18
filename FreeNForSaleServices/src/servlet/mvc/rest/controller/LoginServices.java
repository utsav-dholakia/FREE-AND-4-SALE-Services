package servlet.mvc.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import servlet.mvc.rest.model.Category;
import servlet.mvc.rest.model.Department;
import servlet.mvc.rest.utility.HibernateUtil;
 
@Path("/loginservices")
public class LoginServices {
	@Path("/checkuservalidity")
	@POST
	@Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
	public Response isValidUser(MultivaluedMap<String, String> formParam) {
		boolean response = false;
		if(formParam.getFirst("password").equals("admin")){
			response = true;
		}
		else{
			response = false;
		}
		return Response.ok().entity(String.valueOf(response)).build();
	}
	
	@Path("/availableusername/{username}")
	@GET
	public void availableUsername(@PathParam("username") String username) {
		try{ 
		int empId = Integer.parseInt(username);
	        //logger.info("Request Param empId="+empId);
		 Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			Category d= (Category) session.get(Category.class, empId);
			session.getTransaction().commit();
			System.out.println(d.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
