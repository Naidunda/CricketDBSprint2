package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.dao.MatchScorecardDAO;
import app.model.dao.MatchesDAO;
import app.model.dao.PlayersDAO;
import app.model.dto.BattingScorecardDTO;
import app.model.dto.BowlingScorecardDTO;
import app.model.dto.MatchesDTO;
import app.model.dto.PlayersDTO;

/**
 * Servlet implementation class getMatchScorecard
 */
@WebServlet("/getMatchScorecard")
public class getMatchScorecard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMatchScorecard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matchID = request.getParameter("matchID");
		
		try {
			MatchesDTO match = new MatchScorecardDAO().getMatchSummary(matchID);
			request.setAttribute("matchsummary", match);
			
			ArrayList<BattingScorecardDTO> battingInnings1 = new MatchScorecardDAO().getBattingScorecard(matchID, 1);
			request.setAttribute("battinginnings1", battingInnings1);
			
			ArrayList<BattingScorecardDTO> dnbInnings1 = new MatchScorecardDAO().getDidNotBat(matchID, 1);
			request.setAttribute("dnbinnings1", dnbInnings1);
			
			
			ArrayList<BowlingScorecardDTO> bowlingInnings1= new MatchScorecardDAO().getBowlingScorecard(matchID, 1);
			request.setAttribute("bowlinginnings1", bowlingInnings1);
			
			ArrayList<BattingScorecardDTO> battingInnings2 = new MatchScorecardDAO().getBattingScorecard(matchID, 2);
			request.setAttribute("battinginnings2", battingInnings2);
			
			ArrayList<BattingScorecardDTO> dnbInnings2 = new MatchScorecardDAO().getDidNotBat(matchID, 2);
			request.setAttribute("dnbinnings2", dnbInnings2);
			
			
			ArrayList<BowlingScorecardDTO> bowlingInnings2= new MatchScorecardDAO().getBowlingScorecard(matchID, 2);
			request.setAttribute("bowlinginnings2", bowlingInnings2);

			request.getRequestDispatcher("WEB-INF/pages/match-scorecard.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
