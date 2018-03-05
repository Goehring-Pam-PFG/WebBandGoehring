package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Band;

/**
 * Servlet implementation class modifyBandServlet
 */
@WebServlet("/modifyBandServlet")
public class modifyBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyBandServlet() {
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
		BandHelper dao = new BandHelper();
		String act = request.getParameter("doThisToItem");
		
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Band bandToDelete = dao.searchForBandById(tempId);
			dao.deleteBand(bandToDelete);
			getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Band bandToEdit = dao.searchForBandById(tempId);
			request.setAttribute("bandToEdit", bandToEdit);		
			getServletContext().getRequestDispatcher("/editBand.jsp").forward(request, response);
		} else if (act.equals("Add New Band")) {
			getServletContext().getRequestDispatcher("/addBand.html").forward(request, response);
		}
	}

}
