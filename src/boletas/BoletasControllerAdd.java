package boletas;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import modelos.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
@SuppressWarnings("serial")
public class BoletasControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");


		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		Organizacion organizacion;
		if(user == null){
			resp.sendRedirect(us.createLoginURL(req.getRequestURI()));}
		else if((organizacion = acceso(user.getEmail())) != null){	
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query query = pm.newQuery(Producto.class);
			try {
				String idOrganizacion = String.valueOf(organizacion.getId());
				
				
				query.setFilter("idOrganizacion == idParam");
				query.declareParameters("Long idParam");
				List<Producto> array = (List<Producto>)query.execute(organizacion.getId());
			
				req.setAttribute("array", array);
				req.setAttribute("idOrganizacion", idOrganizacion);
				
				
				
				req.getRequestDispatcher("/WEB-INF/Vistas/Boleta/add.jsp").forward(req, resp);
			} catch (ServletException e) {
				System.out.println("Error "+e.getMessage());
			}}
		else {
			resp.getWriter().write("Organizacion No reconocido, Puede registrarse aqui <a href='/organizaciones/add'>Crear Organizacion</a>");

		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String idOrganizacion = req.getParameter("idOrganizacion");
		String idProducto = req.getParameter("idProducto");
		String ruc = req.getParameter("ruc");
		String dni = req.getParameter("dni");
		String razonSocial = req.getParameter("razonSocial");
		String direccion = req.getParameter("direccion");
		String cantidad = req.getParameter("cantidad");



		try{
			Long idOrganizacionLong = Long.parseLong(idOrganizacion);
			Long idProductoLong = Long.parseLong(idProducto);
			int cantidadInt = Integer.parseInt(cantidad);
			
			Producto producto = pm.getObjectById(Producto.class,idProductoLong);
		
			int totalInt = producto.getPrecio()*cantidadInt;

			
			
			Boleta boleta = new Boleta(idOrganizacionLong, idProductoLong, ruc, dni, razonSocial, direccion, cantidadInt, totalInt);   
			pm.makePersistent(boleta);
		}
		catch(Exception e){
			System.out.println("Error "+e.getMessage());
		}
		finally{			
			pm.close();
			resp.sendRedirect("/boletas");
		}
	}
	public  Organizacion acceso(String gmail){

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Organizacion.class);
		query.setFilter("email == idParam");
		query.declareParameters("String idParam");

		List<Organizacion> array = (List<Organizacion>) query.execute(gmail);

		if(array.size()> 0 ){

			Organizacion organizacion = array.get(0);
			pm.close();
			return organizacion;

		}
		pm.close();
		return null;
	}	
}

