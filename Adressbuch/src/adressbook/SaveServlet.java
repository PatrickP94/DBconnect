package adressbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Adress adr = new Adress();
		adr.setAddressform(request.getParameter("addressform"));
		adr.setBirthday(request.getParameter("birthday"));
		adr.setChristianname(request.getParameter("christianname"));
		adr.setCity(request.getParameter("city"));
		adr.setCountry(request.getParameter("country"));
		adr.setEmail(request.getParameter("email"));
		adr.setMobile(request.getParameter("mobile"));
		adr.setName(request.getParameter("name"));
		adr.setNumber(Integer.parseInt(request.getParameter("number")));
		adr.setPhone(request.getParameter("phone"));
		adr.setPostcode(request.getParameter("postcode"));
		adr.setStreet(request.getParameter("street"));
		try {
			adr.save();
		} catch (Exception e) {
		}
		
		if (adr.fehler==true){
			PrintWriter out = response.getWriter();
			out.println("<h1>Änderungen erfolgreich gespeichert</h1><br><br>");
			if(request.getParameter("id")==null){
				out.println("<a href='/Adressbuch/AddressList.jsp' class='btn btn-default'>Zurück</a>");
			}
			else{
				out.println("<a href='/Adressbuch/Address.jsp?id="+request.getParameter("id")+"class='btn btn-default'>Zurück</a>");
			}
		}
		if (adr.fehler==false){
			PrintWriter out = response.getWriter();
			out.println("<h1>Änderungen erfolgreich gespeichert</h1><br><br>");
			if(request.getParameter("id")==null){
				out.println("<a href='/Adressbuch/AddressList.jsp' class='btn btn-default'>Zurück</a>");
			}
			else{
				out.println("<a href='/Adressbuch/Address.jsp?id="+request.getParameter("id")+"'class='btn btn-default'>Zurück</a>");
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
