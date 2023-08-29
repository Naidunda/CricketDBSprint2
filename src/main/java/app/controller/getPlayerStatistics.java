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
		String sortBy = request.getParameter("sortBy");
		String direction = request.getParameter("direction");
		String search = request.getParameter("search");

		try {
			ArrayList<PlayerStatisticsDTO> players = new PlayerStatisticsDAO().getPlayerStatistics(search);

			if (sortBy.equals("Player Name")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> o1.getP_player_name().compareTo(o2.getP_player_name()));
				} else {
					players.sort((o1, o2) -> o2.getP_player_name().compareTo(o1.getP_player_name()));
				}
			} else if (sortBy.equals("Matches")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getP_matches(), o2.getP_matches()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getP_matches(), o1.getP_matches()));
				}
			} else if (sortBy.equals("Runs Scored")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getP_runs_scored(), o2.getP_runs_scored()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getP_runs_scored(), o1.getP_runs_scored()));
				}
			} else if (sortBy.equals("High Score")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(Integer.parseInt(o1.getP_high_score().replace("*", "")),
							Integer.parseInt(o2.getP_high_score().replace("*", ""))));
				} else {
					players.sort((o1, o2) -> Integer.compare(Integer.parseInt(o2.getP_high_score().replace("*", "")),
							Integer.parseInt(o1.getP_high_score().replace("*", ""))));
				}
			} else if (sortBy.equals("Batting Average")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> {
						if (o1.getP_batting_average().equals("NA")) {
							return -1;
						} else if (o2.getP_batting_average().equals("NA")) {
							return 1;
						} else {
							return Double.compare(Double.parseDouble(o1.getP_batting_average()),
									Double.parseDouble(o2.getP_batting_average()));
						}
					});

				} else {
					players.sort((o1, o2) -> {
						if (o1.getP_batting_average().equals("NA")) {
							return 1;
						} else if (o2.getP_batting_average().equals("NA")) {
							return -1;
						} else {
							return Double.compare(Double.parseDouble(o2.getP_batting_average()),
									Double.parseDouble(o1.getP_batting_average()));
						}
					});
				}
			} else if (sortBy.equals("Wickets Taken")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getP_wickets_taken(), o2.getP_wickets_taken()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getP_wickets_taken(), o1.getP_wickets_taken()));
				}
			} else if (sortBy.equals("Best Figures")) {

				players.sort((o1, o2) -> {
					Scanner best_figure_o1 = new Scanner(o1.getP_best_figures()).useDelimiter("/");
					Scanner best_figure_o2 = new Scanner(o2.getP_best_figures()).useDelimiter("/");

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
						if (o1.getP_bowling_average().equals("NA")) {
							return -1;
						} else if (o2.getP_bowling_average().equals("NA")) {
							return 1;
						} else {
							return Double.compare(Double.parseDouble(o1.getP_bowling_average()),
									Double.parseDouble(o2.getP_bowling_average()));
						}
					});

				} else {
					players.sort((o1, o2) -> {
						if (o1.getP_bowling_average().equals("NA")) {
							return 1;
						} else if (o2.getP_bowling_average().equals("NA")) {
							return -1;
						} else {
							return Double.compare(Double.parseDouble(o2.getP_bowling_average()),
									Double.parseDouble(o1.getP_bowling_average()));
						}
					});
				}
			} else if (sortBy.equals("Catches")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getP_catches(), o2.getP_catches()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getP_catches(), o1.getP_catches()));
				}
			} else if (sortBy.equals("Stumpings")) {
				if (direction.equals("fa-arrow-down-a-z")) {
					players.sort((o1, o2) -> Integer.compare(o1.getP_stumpings(), o2.getP_stumpings()));
				} else {
					players.sort((o1, o2) -> Integer.compare(o2.getP_stumpings(), o1.getP_stumpings()));
				}
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
