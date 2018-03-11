package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;

/**
 * Servlet implementation class addBandServlet
 */
@WebServlet("/addBandServlet")
public class addBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bandName = request.getParameter("bandName");
		String members = request.getParameter("numOfMembers");
		String bandLocation = request.getParameter("bandLocation");
		String level = request.getParameter("level");
		
		int numOfMembers = Integer.valueOf(members);
		int levelId = Integer.valueOf(level);
		
		Band newBand = new Band(numOfMembers, bandName, bandLocation, levelId);
		BandHelper dao = new BandHelper();
		dao.insertBand(newBand);
		
		getServletContext().getRequestDispatcher("/addBand.html").forward(request, response);
	}

}
