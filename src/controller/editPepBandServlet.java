package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PepBand;

/**
 * Servlet implementation class editPepBandServlet
 */
@WebServlet("/editPepBandServlet")
public class editPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPepBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PepBandHelper dao = new PepBandHelper();
		
		String bandName = request.getParameter("bandName");
		String bandLocation = request.getParameter("bandLocation");
		String members = request.getParameter("numOfMembers");
		String event = request.getParameter("event");

		int numOfMembers = Integer.valueOf(members);
		int eventId = Integer.valueOf(event);
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		PepBand pepBandToUpdate = dao.searchForPepBandById(tempId);
		pepBandToUpdate.setBandName(bandName);
		pepBandToUpdate.setBandLocation(bandLocation);
		pepBandToUpdate.setNumOfMembers(numOfMembers);
		pepBandToUpdate.setEventId(eventId);
		
		dao.updatePepBand(pepBandToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPepBandsServlet").forward(request, response);
	}

}
