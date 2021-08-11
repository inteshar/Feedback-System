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


@WebServlet("/Messages")
public class StoreMessages extends HttpServlet {
    
    
    public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException
    {
        try
        {
           
            String u_name=rq.getParameter("u_name");
            String u_email=rq.getParameter("u_email");
            String msg=rq.getParameter("msg");
            
                    
            Messages M=new Messages();
            M.setU_name(u_name);
            M.setU_email(u_email);
            M.setMsg(msg);
           
            
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf=cfg.buildSessionFactory();
            Session s=sf.openSession();
           
            s.save(M);
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


