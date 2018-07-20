package productos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;

import modelos.*;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
@SuppressWarnings("serial")
public class ProductosControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");	
		
		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		Organizacion organizacion;
		
		if(user == null){
			resp.sendRedirect(us.createLoginURL(req.getRequestURI()));}
		else if((organizacion = acceso(user.getEmail())) != null){	
			try {
				
				String idOrganizacion = String.valueOf(organizacion.getId());
				req.setAttribute("idOrganizacion",idOrganizacion);
				req.getRequestDispatcher("/WEB-INF/Vistas/Producto/add.jsp").forward(req, resp);

			} catch (ServletException e) {
				System.out.println("Error "+e.getMessage());
			}
		}else {
			resp.getWriter().write("DEBE REGISTRARSE PRIMERO <a href='/organizaciones/add'>Crear Organizacion</a>");

		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String idOrganizacion = req.getParameter("idOrganizacion");
		String nombre = req.getParameter("nombre");
		String unidad = req.getParameter("unidad");
		String precio = req.getParameter("precio");


		try{
			Long idOrganizacionLong = Long.parseLong(idOrganizacion);
			int precioInt = Integer.parseInt(precio);
			Producto producto = new Producto(idOrganizacionLong,nombre,unidad,precioInt,true);
			pm.makePersistent(producto);
		}
		catch(Exception e){
			System.out.println("Error "+e.getMessage());
		}
		finally{			
			pm.close();
			resp.sendRedirect("/productos");
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

