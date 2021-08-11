  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author saurabh
 */
@WebServlet(urlPatterns = {"/allview"})
public class allview extends HttpServlet {
    
    
    public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException
    {
        try
        {
           
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf=cfg.buildSessionFactory();
            Session s=sf.openSession(); 
            Query q1=s.createQuery("from faculty");
            List<faculty>l= q1.list();
            rs.getWriter().println("<html><link rel=\"stylesheet\" href=\"css.css\"><body><center><a href=\"index.html\"><img src=\"img/logo.png\" id=\"photo\"></a></center></body></html>");
            for(faculty f:l)
            
            rs.getWriter().println("<html><body><center><h3>ID: "+f.getId()+"</h3><h3>Name: "+f.getName()+"</h3><h3>Destination: "+f.getDestination()+"</h3></br></center></body></html>");
            s.beginTransaction().commit();
            s.close();
            sf.close();
           
            
            
        }
        catch(Exception e)
        {
            
            rs.getWriter().println(e);
        }
            
            
            
        
                    
         }
}


