package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarchingBand;

/**
 * Servlet implementation class modifyMarchingBandServlet
 */
@WebServlet("/modifyMarchingBandServlet")
public class modifyMarchingBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyMarchingBandServlet() {
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
		MarchingBandHelper dao = new MarchingBandHelper();
		String act = request.getParameter("doThisToItem");
		
		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllMarchingBandsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Marching Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			MarchingBand marchingBandToDelete = dao.searchForMarchingBandById(tempId);
			dao.deleteMarchingBand(marchingBandToDelete);
			getServletContext().getRequestDispatcher("/viewAllMarchingBandsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Marching Band")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			MarchingBand marchingBandToEdit = dao.searchForMarchingBandById(tempId);
			request.setAttribute("marchingBandToEdit", marchingBandToEdit);		
			getServletContext().getRequestDispatcher("/editMarchingBand.jsp").forward(request, response);
		} else if (act.equals("Add New Marching Band")) {
			getServletContext().getRequestDispatcher("/addMarchingBand.html").forward(request, response);
		}
	}

}
