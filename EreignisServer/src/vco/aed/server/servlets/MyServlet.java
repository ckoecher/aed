package vco.aed.server.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SessionFactory sf = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static SessionFactory getSessionFactory() {
		if (MyServlet.sf == null) {
			//ServiceRegistry serviceRegistry;
	    	Configuration configuration = new Configuration();
		    configuration.configure();
		    //serviceRegistry = new SessionFactoryServiceRegistryImpl().applySettings(configuration.getProperties()).buildServiceRegistry()
		    sf = configuration.buildSessionFactory();
		}
		return sf;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sf = getSessionFactory(); 
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		
		try {
			tx.begin();
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			session.close();
		}
		
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
