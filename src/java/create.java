/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@WebServlet(urlPatterns = {"/create"})
public class create extends HttpServlet {
    
    
    public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException
    {
        try
        {
            int id=Integer.parseInt(rq.getParameter("t1"));
            String name=rq.getParameter("t2");
            String destination=rq.getParameter("t3");
                    
            faculty f=new faculty();
            f.setId(id);
            f.setName(name);
            f.setDestination(destination);  
            
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf=cfg.buildSessionFactory();
            Session s=sf.openSession();
           
            s.save(f);
            s.beginTransaction().commit();
            rs.getWriter().println("<html><body><center><a href=\"index.html\"><img src=\"img/logo.png\" id=\"photo\"></a><h1>RECORD SAVED SUCCESSFULLY</h1></center></body></html>");
            s.close();
            sf.close();
            
        }
        catch(Exception e)
        {
            
            rs.getWriter().println("<html><body><body><h1>"+e+"</h1></body></html>");
        }
            
            
            
        
                    
         }
}


