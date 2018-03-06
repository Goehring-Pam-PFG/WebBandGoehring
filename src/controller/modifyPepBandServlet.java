package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PepBand;

/**
 * Servlet implementation class modifyPepBandServlet
 */
@WebServlet("/modifyPepBandServlet")
public class modifyPepBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyPepBandServlet() {
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
		PepBandHelper dao = new PepBandHelper();
		String act = request.getParameter("doThisToItem");
		
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllPepBandsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Pep Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PepBand pepBandToDelete = dao.searchForPepBandById(tempId);
			dao.deletePepBand(pepBandToDelete);
			getServletContext().getRequestDispatcher("/viewAllPepBandsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Pep Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PepBand pepBandToEdit = dao.searchForPepBandById(tempId);
			request.setAttribute("pepBandToEdit", pepBandToEdit);		
			getServletContext().getRequestDispatcher("/editPepBand.jsp").forward(request, response);
		} else if (act.equals("Add New Pep Band")) {
			getServletContext().getRequestDispatcher("/addPepBand.html").forward(request, response);
		}
	}

}
