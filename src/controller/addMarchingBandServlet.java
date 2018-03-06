package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarchingBand;

/**
 * Servlet implementation class addMarchingBandServlet
 */
@WebServlet("/addMarchingBandServlet")
public class addMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMarchingBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String bandName = request.getParameter("bandName");
		String bandLocation = request.getParameter("bandLocation");
		String members = request.getParameter("numOfMembers");
		String level = request.getParameter("level");
		String typesOfProps = request.getParameter("Type of Props"); 
		String hasPropsStr = request.getParameter("Has props");
		String hasColorGuardStr = request.getParameter("Has colorguard"); 
		
		int numOfMembers = Integer.valueOf(members);
		int levelId = Integer.valueOf(level);
		boolean hasProps = hasPropsStr.equalsIgnoreCase(hasPropsStr);
		boolean hasColorGuard = hasColorGuardStr.equalsIgnoreCase(hasColorGuardStr);
		
		MarchingBand newMarchingBand = new MarchingBand(numOfMembers, bandName, bandLocation, levelId, hasProps, hasColorGuard, typesOfProps);
		MarchingBandHelper dao = new MarchingBandHelper();
		dao.insertBand(newMarchingBand);
		
		getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response); */
		
		String bandName = request.getParameter("bandName");
		System.out.println("Name of Band: " + bandName);
		
		String members = request.getParameter("numOfMembers");
		System.out.println("String nmbr of mumber: " + members);
		int numOfMembers = Integer.valueOf(members);
		
		String bandLocation = request.getParameter("bandLocation");
		System.out.println("Location: " + bandLocation);

		String level = request.getParameter("level");
		System.out.println("Level: " + level);
		int levelId = Integer.valueOf(level);
		
		
		String stringHasProps = request.getParameter("hasProps");
		System.out.println("Has Props: " + stringHasProps);
		boolean hasProps = Boolean.getBoolean(stringHasProps); 
		
		
		String typesOfProps = request.getParameter("typesOfProps");
		
//		if (hasProps == "2") {
//			String typesOfProps = request.getParameter("typesOfProps");
//		}else {
//			String typesOfProps = " ";
//		}
		
		String stringHasColorGuard = request.getParameter("hasColorGuard");
		System.out.println("has color guard: " + stringHasColorGuard);
		boolean hasColorGuard = Boolean.getBoolean(stringHasColorGuard); 
//		String stringCostOfParticipation = request.getParameter("stringCostOfParticipation");
//		double costOfParticipation = Double.valueOf(stringCostOfParticipation);
	//	int levelOfBand = Integer.valueOf(stringLevelOfBand);
	//	String bandType = request.getParameter("bandType");
	

		MarchingBand newMarchingBand = new MarchingBand(numOfMembers, bandName, bandLocation, levelId, hasProps, hasColorGuard, typesOfProps);
		MarchingBandHelper dao = new MarchingBandHelper();

		dao.insertBand(newMarchingBand);

		getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response);
	}

}
