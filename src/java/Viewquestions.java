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


@WebServlet(urlPatterns = {"/Viewquestions"})
public class Viewquestions extends HttpServlet {
    
    
    public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException
    {
        try
        {
            int qid=Integer.parseInt(rq.getParameter("qid")); 
            
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf=cfg.buildSessionFactory();
            Session s=sf.openSession();
           
            Q_insert Q =(Q_insert)s.load(Q_insert.class,qid);
            
             rs.getWriter().println("<link rel=\"stylesheet\" href=\"css.css\"><html><body><center><a href=\"index.html\"><img src=\"img/logo.png\" id=\"photo\"></a><h3>Question ID: "+Q.getQid()+"</h3></br></br><h3>Question 1: "+Q.getQ1()+"</h3></br></br><h3>Question 2: "+Q.getQ2()+"</h3></br></br><h3>Question 3: "+Q.getQ3()+"</h3></br></br><h3>Question 4: "+Q.getQ4()+"</h3></br></br><h3>Question 5: "+Q.getQ5()+"</h3></br></br></center></body></html>");
          
             s.beginTransaction().commit();
        }
        catch(Exception e)
        {
            
            rs.getWriter().println("<html><body><body><h3>No data with given ID found.</h3><p>Error: "+e+"</p></body></html>");
        }
            
            
            
        
                    
         }
}


