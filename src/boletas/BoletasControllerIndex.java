package boletas;
import java.io.IOException;
import java.util.ArrayList;
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
public class BoletasControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");

		UserService us = UserServiceFactory.getUserService();
		User user = us.getCurrentUser();
		Organizacion organizacion;
		if(user == null){
			resp.sendRedirect(us.createLoginURL(req.getRequestURI()));}
		
		else if((organizacion = acceso(user.getEmail())) != null){	
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Query query = pm.newQuery(Boleta.class);
			try{
				query.setFilter("idOrganizacion == idParam");
				query.declareParameters("Long idParam");
			
				List<Boleta> array = (List<Boleta>)query.execute(organizacion.getId());
				
				List<Producto> array2 = new ArrayList<Producto>();
				
				Producto producto;
				for(Boleta boleta : array){
					producto = pm.getObjectById(Producto.class,boleta.getIdProducto());
					array2.add(producto);
				}		
				
				req.setAttribute("array", array);
				req.setAttribute("array2", array2);
				
				req.getRequestDispatcher("/WEB-INF/Vistas/Boleta/index.jsp").forward(req, resp);


			} catch (ServletException e) {
				System.out.println("Error "+e.getMessage());
			}
			finally {
				query.closeAll();
				pm.close();
			}
		}
		else {
			resp.getWriter().write("DEBE REGISTRARSE PRIMERO <a href='/organizaciones/add'>Crear Organizacion</a>");

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


