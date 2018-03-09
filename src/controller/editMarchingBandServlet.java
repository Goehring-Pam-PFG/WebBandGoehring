package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarchingBand;

/**
 * Servlet implementation class editMarchingBandServlet
 */
@WebServlet("/editMarchingBandServlet")
public class editMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editMarchingBandServlet() {
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
		MarchingBandHelper dao = new MarchingBandHelper();
		
		String bandName = request.getParameter("bandName");
		System.out.println(bandName);
		String bandLocation = request.getParameter("bandLocation");
		String members = request.getParameter("numOfMembers");
		String typesOfProps = request.getParameter("TypeofProps"); 
		System.out.println("Type of Props: " + typesOfProps);
		//String hasPropsStr = request.getParameter("Has props");
		//String hasColorGuardStr = request.getParameter("Has colorguard"); 

		int numOfMembers = Integer.valueOf(members);
		//boolean hasProps = hasPropsStr.equalsIgnoreCase("yes");
		//boolean hasColorGuard = hasColorGuardStr.equalsIgnoreCase("yes");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		MarchingBand marchingBandToUpdate = dao.searchForMarchingBandById(tempId);
		marchingBandToUpdate.setBandName(bandName);
		marchingBandToUpdate.setBandLocation(bandLocation);
		marchingBandToUpdate.setNumOfMembers(numOfMembers);
		//marchingBandToUpdate.setHasColorGuard(hasColorGuard);
		//marchingBandToUpdate.setHasProps(hasProps);
		marchingBandToUpdate.setTypesOfProps(typesOfProps);
		
		dao.updateMarchingBand(marchingBandToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllMarchingBandsServlet").forward(request, response);
	}

}
