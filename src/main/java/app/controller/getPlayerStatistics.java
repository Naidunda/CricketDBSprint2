package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.dao.PlayerStatisticsDAO;
import app.model.dto.PlayerStatisticsDTO;


/**
 * Servlet implementation class getPlayerStatistics
 */
@WebServlet("/getPlayerStatistics")
public class getPlayerStatistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPlayerStatistics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sortBy = request.getParameter("sortBy");
		String direction = request.getParameter("direction");
		String search = request.getParameter("search");

		try {
			ArrayList<PlayerStatisticsDTO> players = new PlayerStatisticsDAO().getPlayerStatistics(search);
			
			if (sortBy.equals("Player Name")) {
				players.sort((o1, o2) -> o1.getP_player_name().compareTo(o2.getP_player_name()));
			}
			
			request.setAttribute("playerstatistics", players);
			request.setAttribute("sortby", sortBy);
			request.setAttribute("direction", direction);
			request.setAttribute("search", search);
			
			request.getRequestDispatcher("WEB-INF/pages/players.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
