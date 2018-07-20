package organizaciones;

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
public class OrganizacionesControllerIndex extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query query = pm.newQuery(Organizacion.class);
		try{

			List<Organizacion> array = (List<Organizacion>)query.execute("select from Organizacion");

			req.setAttribute("array", array);

			req.getRequestDispatcher("/WEB-INF/Vistas/Organizacion/index.jsp").forward(req, resp);

		} catch (ServletException e) {
			System.out.println("Error "+e.getMessage());
		}
		finally {
			query.closeAll();
			pm.close();
		}



	}


}


