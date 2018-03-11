package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;

/**
 * Servlet implementation class editBandServlet
 */
@WebServlet("/editBandServlet")
public class editBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBandServlet() {
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
		
		BandHelper dao = new BandHelper();
		
		String bandName = request.getParameter("bandName");
		String bandLocation = request.getParameter("bandLocation");
		//String members = request.getParameter("numOfMembers");

		Integer numOfMembers = Integer.parseInt(request.getParameter("numOfMembers"));
		Integer levelOfBand = Integer.parseInt(request.getParameter("level"));
		
		//String stringLevelOfBand = request.getParameter("levelBandId");
		//int levelBandId = Integer.valueOf(stringLevelOfBand);
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Band bandToUpdate = dao.searchForBandById(tempId);
		bandToUpdate.setBandName(bandName);
		bandToUpdate.setBandLocation(bandLocation);
		bandToUpdate.setNumOfMembers(numOfMembers);
		bandToUpdate.setLevelBandId(levelOfBand);;
		bandToUpdate.setCostOfParticipation(numOfMembers, levelOfBand);
		
		dao.updateBand(bandToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
	}

}
