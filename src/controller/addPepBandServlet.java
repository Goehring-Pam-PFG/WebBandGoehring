package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PepBand;

/**
 * Servlet implementation class addPepBandServlet
 */
@WebServlet("/addPepBandServlet")
public class addPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPepBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bandName = request.getParameter("bandName");
		String bandLocation = request.getParameter("bandLocation");
		String members = request.getParameter("numOfMembers");
		String level = request.getParameter("level");
		String event = request.getParameter("event");
		
		int numOfMembers = Integer.valueOf(members);
		int eventId = Integer.valueOf(event);
		int levelId = Integer.valueOf(level);
		
		PepBand newPepBand = new PepBand(numOfMembers, bandName, bandLocation, levelId, eventId);
		PepBandHelper dao = new PepBandHelper();
		dao.insertBand(newPepBand);
		
		getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
	}

}
