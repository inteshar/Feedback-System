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


@WebServlet(urlPatterns = {"/Deletequestion"})
public class Deletequestion extends HttpServlet {
    
    
    public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException
    {
        try
        {
            int qid=Integer.parseInt(rq.getParameter("qid")); 
            
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf=cfg.buildSessionFactory();
            Session s=sf.openSession();
           
            Q_insert Q =(Q_insert)s.load(Q_insert.class,qid);
            s.delete(Q);
            
             //rs.getWriter().println(f.getName()+"<br>"+f.getDestination());
          
             s.beginTransaction().commit();
             rs.getWriter().print("<html><body><center><a href=\"index.html\"><img src=\"img/logo.png\" id=\"photo\"></a><h1>RECORD DELETED SUCCESSFULLY</h1></center></body></html>");
        }
        catch(Exception e)
        {
            
            rs.getWriter().println("<html><body><body><h1>"+e+"</h1></body></html>");
        }
            
            
            
        
                    
         }
}


