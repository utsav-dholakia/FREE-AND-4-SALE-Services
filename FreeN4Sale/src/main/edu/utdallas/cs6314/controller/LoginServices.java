package main.edu.utdallas.cs6314.controller;


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

import main.edu.utdallas.cs6314.model.Department;
import main.edu.utdallas.cs6314.utility.HibernateUtil;
 
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
		 int empId = Integer.parseInt(username);
	        //logger.info("Request Param empId="+empId);
		 Session session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			Department d= (Department) session.get(Department.class, empId);
			session.getTransaction().commit();
			System.out.println(d.getDname());

	}
}
