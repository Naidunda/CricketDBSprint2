package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sortBy = request.getParameter("sortBy"); // Get the sorting by criteria.
		String direction = request.getParameter("direction"); // Get the sorting direction.
		String search = request.getParameter("search"); // Get the search keyword.

		try {
			// Retrieve player statistics for players matching the search a using a DAO class.
			ArrayList<PlayerStatisticsDTO> players = new PlayerStatisticsDAO().getPlayerStatistics(search);

			 // Sort the players based on the specified sorting criteria and direction.
			if (sortBy.equals("Player Name")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> o1.getPlayerName().compareTo(o2.getPlayerName()));
				} else {
					players.sort((o1, o2) -> o2.getPlayerName().compareTo(o1.getPlayerName()));
				}
			} else if (sortBy.equals("Matches")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getMatches(), o2.getMatches()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getMatches(), o1.getMatches()));
				}
			} else if (sortBy.equals("Runs Scored")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getRunsScored(), o2.getRunsScored()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getRunsScored(), o1.getRunsScored()));
				}
			} else if (sortBy.equals("High Score")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(Integer.parseInt(o1.getHighScore().replace("*", "")),
							Integer.parseInt(o2.getHighScore().replace("*", ""))));
				} else {
					players.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2.getHighScore().replace("*", "")),
							Integer.parseInt(o1.getHighScore().replace("*", ""))));
				}
			} else if (sortBy.equals("Batting Average")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> {
						if (o1.getBattingAverage().equals("NA")) {
							return -1;
						} else if (o2.getBattingAverage().equals("NA")) {
							return 1;
						} else {
							return Double.compare(Double.parseDouble(o1.getBattingAverage()),
									Double.parseDouble(o2.getBattingAverage()));
						}
					});

				} else {
					players.sort((o1, o2) -> {
						if (o1.getBattingAverage().equals("NA")) {
							return 1;
						} else if (o2.getBattingAverage().equals("NA")) {
							return -1;
						} else {
							return Double.compare(Double.parseDouble(o2.getBattingAverage()),
									Double.parseDouble(o1.getBattingAverage()));
						}
					});
				}
			} else if (sortBy.equals("Wickets Taken")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getWicketsTaken(), o2.getWicketsTaken()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getWicketsTaken(), o1.getWicketsTaken()));
				}
			} else if (sortBy.equals("Best Figures")) {

				players.sort((o1, o2) -> {
					Scanner best_figure_o1 = new Scanner(o1.getBestFigures()).useDelimiter("/");
					Scanner best_figure_o2 = new Scanner(o2.getBestFigures()).useDelimiter("/");

					String temp = best_figure_o1.next();

					int wickets_o1 = 0;
					int runs_o1 = 0;

					int wickets_o2 = 0;
					int runs_o2 = 0;

					int option1;
					int option2;

					if (direction.equals("fa-arrow-down-a-z")) {
						option1 = -1;
						option2 = 1;
					} else {
						option1 = 1;
						option2 = -1;
					}

					if (temp.equals("NA")) {
						return option1;
					} else {
						wickets_o1 = Integer.parseInt(temp);
						runs_o1 = Integer.parseInt(best_figure_o1.next());

						temp = best_figure_o2.next();

						if (temp.equals("NA")) {
							return option2;
						} else {
							wickets_o2 = Integer.parseInt(temp);
							runs_o2 = Integer.parseInt(best_figure_o2.next());

							if (wickets_o1 < wickets_o2) {
								return option1;
							} else if (wickets_o1 == wickets_o2) {
								if (runs_o1 > runs_o2) {
									return option1;
								} else {
									return option2;
								}
							} else {
								return option2;
							}

						}
					}
					
				});
			} else if (sortBy.equals("Bowling Average")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> {
						if (o1.getBowlingAverage().equals("NA")) {
							return -1;
						} else if (o2.getBowlingAverage().equals("NA")) {
							return 1;
						} else {
							return Double.compare(Double.parseDouble(o1.getBowlingAverage()),
									Double.parseDouble(o2.getBowlingAverage()));
						}
					});

				} else {
					players.sort((o1, o2) -> {
						if (o1.getBowlingAverage().equals("NA")) {
							return 1;
						} else if (o2.getBowlingAverage().equals("NA")) {
							return -1;
						} else {
							return Double.compare(Double.parseDouble(o2.getBowlingAverage()),
									Double.parseDouble(o1.getBowlingAverage()));
						}
					});
				}
			} else if (sortBy.equals("Catches")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getCatches(), o2.getCatches()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getCatches(), o1.getCatches()));
				}
			} else if (sortBy.equals("Stumpings")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getStumpings(), o2.getStumpings()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getStumpings(), o1.getStumpings()));
				}
			}
			
			 // Set the sorted list as attributes in the request.
			request.setAttribute("playerstatistics", players);
			
			//Sets the sort criteria as attributes in the requests
			request.setAttribute("sortby", sortBy);
			request.setAttribute("direction", direction);
			request.setAttribute("search", search);
			
			// Forwards the request to the "players.jsp" page for rendering.
			request.getRequestDispatcher("WEB-INF/pages/players.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
