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


@WebServlet("/student")
public class newstudent extends HttpServlet {
    
    
    public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws IOException
    {
        try
        {
            int sid=Integer.parseInt(rq.getParameter("sid"));
            long mob=Integer.parseInt(rq.getParameter("mob"));
            String uname=rq.getParameter("uname");
            String course=rq.getParameter("course");
            String email=rq.getParameter("email");
            String dob=rq.getParameter("dob");
            String pass=rq.getParameter("pass");
            
                    
            student s1=new student();
            s1.setSid(sid);
            s1.setUname(uname);
            s1.setCourse(course);
            s1.setMob(mob);
            s1.setEmail(email);
            s1.setDob(dob);
            s1.setPass(pass);
           
            
            Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sf=cfg.buildSessionFactory();
            Session s=sf.openSession();
           
            s.save(s1);
            s.beginTransaction().commit();
            rs.getWriter().println("<link rel=\"stylesheet\" href=\"css.css\"><html><body><center><a href=\"index.html\"><img src=\"img/logo.png\" id=\"photo\"></a><h1>RECORD SAVED SUCCESSFULLY</h1><a href=\"newstudent.html\">Back</a></center></body></html>");
            s.close();
            sf.close();
            
        }
        catch(Exception e)
        {
            
            rs.getWriter().println("<html><body><body><h1>"+e+"</h1></body></html>");
        }
    }
}


