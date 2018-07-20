package organizaciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import controller.PMF;
import modelos.*;
import javax.jdo.PersistenceManager;
@SuppressWarnings("serial")
public class OrganizacionesControllerAdd extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
			try {
				req.getRequestDispatcher("/WEB-INF/Vistas/Organizacion/add.jsp").forward(req, resp);
			} catch (ServletException e) {
				System.out.println("Error "+e.getMessage());
			}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		String nombre = req.getParameter("nombre");
		String gmail = req.getParameter("gmail");
		try{

			Organizacion organizacion = new Organizacion(nombre,gmail);
			pm.makePersistent(organizacion);
		}
		catch(Exception e){
			System.out.println("Error "+e.getMessage());
		}
		finally{			
			pm.close();
			resp.sendRedirect("/organizaciones");
		}
	}
}

