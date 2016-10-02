import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.rmi.Naming;
public class HelloYou extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException  {
		String nome = req.getParameter("nome");
		String matricula = req.getParameter("matricula");
		String nota1 = req.getParameter("nota1");
		String nota2 = req.getParameter("nota2");
		String frequencia = req.getParameter("frequencia");
      	res.setContentType("text/html");
      	PrintWriter out = res.getWriter();
      	out.println("<HTML>");
      	out.println("<HEAD>");
      	out.println("<TITLE>Hello World Sample Servlet</TITLE>");
      	out.println("</HEAD>");
      	out.println("<BODY>");
      	out.println("<CENTER><H1>Hello "+nome+matricula+nota1+nota2+frequencia+"</H1></CENTER>");
      	out.println("</BODY>");
      	out.println("</HTML>");
      	out.close();
		try
		{
			Interface_Remota obj = (Interface_Remota ) Naming.lookup("//localhost/Roteiro4");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
   }
}