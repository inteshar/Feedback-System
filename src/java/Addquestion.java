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
import java.util.Date;


@WebServlet("/Addquestion")
public class Addquestion extends HttpServlet {
    
    
    public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException
    {
        try
        {
            int qid=Integer.parseInt(rq.getParameter("qid"));
            String q1=rq.getParameter("q1");
            String q2=rq.getParameter("q2");
            String q3=rq.getParameter("q3");
            String q4=rq.getParameter("q4");
            String q5=rq.getParameter("q5");
            
                    
            Q_insert Q=new Q_insert();
            Q.setQid(qid);
            Q.setQ1(q1);
            Q.setQ2(q2);
            Q.setQ3(q3);
            Q.setQ4(q4);
            Q.setQ5(q5);
           
            
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf=cfg.buildSessionFactory();
            Session s=sf.openSession();
           
            s.save(Q);
            s.beginTransaction().commit();
            rs.getWriter().println("<link rel=\"stylesheet\" href=\"css.css\"><html><body><center><a href=\"index.html\"><img src=\"img/logo.png\" id=\"photo\"></a><h1>RECORD SAVED SUCCESSFULLY</h1></center></body></html>");
            s.close();
            sf.close();
            
        }
        catch(Exception e)
        {
            
            rs.getWriter().println("<html><body><body><h1>"+e+"</h1></body></html>");
        }
    }
}


