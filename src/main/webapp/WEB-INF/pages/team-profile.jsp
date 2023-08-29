<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${requestScope.teamsinformation}" var="a"></c:set>
<c:set value="${requestScope.playerstatistics}" var="b"></c:set>
<c:set value="${requestScope.playerinformation}" var="d"></c:set>
<c:set value="${requestScope.matchinformation}" var="e"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Team Profile</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/team-profile.css" />

<script src="https://kit.fontawesome.com/1374555d03.js"
	crossorigin="anonymous"></script>
<script src="scripts/team-profile.js"></script>
</head>

<body>
	<div class="container">
		<nav>
			<ul>
				<li><a href="Dashboard" class="logo"> <span
						class="nav-item">CricketDB</span>
				</a></li>
				<li><a href="Dashboard" class="nav-list"> <i
						class="fas fa-solid fa-table-columns"></i> <span class="nav-item">Dashboard</span>
				</a></li>
				<li><a
					href="Players?sortBy=Player+Name&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-person-running"></i>
						<span class="nav-item">Players</span>
				</a></li>
				<li class="selected"><a
					href="Teams?sortBy=Team+Name&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-people-group"></i>
						<span class="nav-item">Teams</span>
				</a></li>
				<li><a
					href="Matches?sortBy=Date&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-calendar-days"></i>
						<span class="nav-item">Matches</span>
				</a></li>
				<li><a href="Management" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Management</span>
				</a></li>
			</ul>
		</nav>
		<section class="main">
			<div class="profile-heading">
				<c:forEach var="item" items="${a}">
					<h1>
						<button onclick="history.back()" class="btn-back">
							<i class="fa-solid fa-arrow-left-long"></i>
						</button>${item.t_team_name}</h1>
					<h2>${item.t_age_group}</h2>
					<h2>${item.t_location}</h2>
				</c:forEach>
			</div>
			<!--Tab Links-->
			<div class="tabs">
				<button class="tab-links active" onclick="openTab(event, 'Players')">
					Players</button>
				<button class="tab-links" onclick="openTab(event, 'Statistics')">
					Statistics</button>
				<button class="tab-links" onclick="openTab(event, 'Matches')">
					Matches</button>
			</div>
			<!--Tab Content-->
			<div id="Players" class="tab-content" style="display: block">
				<table>
					<tr>
						<th>Player Name</th>
						<th>DOB</th>
						<th>Role</th>
					</tr>
					<tbody>
						<c:forEach var="item" items="${d}">
							<tr>
								<td><a
									href="Player-Profile?playerID=${item.p_player_id}&season=All-Time">${item.p_player_name}</a></td>
								<td>${item.p_dob}</td>
								<td>${item.p_role}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div id="Statistics" class="tab-content">
				<div class="select-menu">
					<div class="select-btn" onclick="selectionMenu(event)">
						<span class="sBtn-text">All</span> <i
							class="fa-solid fa-chevron-down"></i>
					</div>

					<ul class="options">
						<li class="option"><span class="option-text">All</span></li>
						<li class="option"><span class="option-text">Batting</span></li>
						<li class="option"><span class="option-text">Bowling</span></li>
						<li class="option"><span class="option-text">Fielding</span>
						</li>
					</ul>
				</div>
				<div>
					<div id="All" class="statistics-content" style="display: block">
						<table>
							<tr>
								<th>Name</th>
								<th>Matches</th>
								<th>Runs</th>
								<th>HS</th>
								<th>Bat Ave</th>
								<th>100</th>
								<th>Wkts</th>
								<th>BBI</th>
								<th>Bowl Ave</th>
								<th>5</th>
								<th>Ct</th>
								<th>St</th>
							</tr>
							<tbody>
								<c:forEach var="item" items="${b}">
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.p_player_id}&season=All-Time">${item.p_player_name}</a></td>
										<td>${item.p_matches}</td>
										<td>${item.p_runs_scored}</td>
										<td>${item.p_high_score}</td>
										<td>${item.p_batting_average}</td>
										<td>${item.p_hundreds}</td>
										<td>${item.p_wickets_taken}</td>
										<td>${item.p_best_figures}</td>
										<td>${item.p_bowling_average}</td>
										<td>${item.p_five_wickets}</td>
										<td>${item.p_catches}</td>
										<td>${item.p_stumpings}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="Batting" class="statistics-content">
						<table>
							<tr>
								<th>Name</th>
								<th>Matches</th>
								<th>Inn</th>
								<th>NO</th>
								<th>HS</th>
								<th>Avg</th>
								<th>SR</th>
								<th>50s</th>
								<th>100s</th>
								<th>4s</th>
								<th>6s</th>
							</tr>
							<tbody>
								<c:forEach var="item" items="${b}">
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.p_player_id}&season=All-Time">${item.p_player_name}</a></td>
										<td>${item.p_matches}</td>
										<td>${item.p_batting_innings}</td>
										<td>${item.p_not_outs}</td>
										<td>${item.p_high_score}</td>
										<td>${item.p_batting_average}</td>
										<td>${item.p_batting_strike_rate}</td>
										<td>${item.p_fifties}</td>
										<td>${item.p_hundreds}</td>
										<td>${item.p_fours}</td>
										<td>${item.p_sixes}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="Bowling" class="statistics-content">
						<table>
							<tr>
								<th>Name</th>
								<th>Matches</th>
								<th>Inn</th>
								<th>Balls</th>
								<th>Wkts</th>
								<th>Runs</th>
								<th>BBI</th>
								<th>Ave</th>
								<th>Econ</th>
								<th>SR</th>
								<th>5W</th>
							</tr>
							<tbody>
								<c:forEach var="item" items="${b}">
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.p_player_id}&season=All-Time">${item.p_player_name}</a></td>
										<td>${item.p_matches}</td>
										<td>${item.p_bowling_innings}</td>
										<td>${item.p_balls_bowled}</td>
										<td>${item.p_wickets_taken}</td>
										<td>${item.p_runs_conceded}</td>
										<td>${item.p_best_figures}</td>
										<td>${item.p_bowling_average}</td>
										<td>${item.p_economy}</td>
										<td>${item.p_bowling_strike_rate}</td>
										<td>${item.p_five_wickets}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div id="Fielding" class="statistics-content">
						<table>
							<tr>
								<th>Name</th>
								<th>Matches</th>
								<th>Ct</th>
								<th>St</th>
							</tr>
							<tbody>
								<c:forEach var="item" items="${b}">
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.p_player_id}&season=All-Time">${item.p_player_name}</a></td>
										<td>${item.p_matches}</td>
										<td>${item.p_catches}</td>
										<td>${item.p_stumpings}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div id="Matches" class="tab-content">
				<c:forEach var="item" items="${e}">
					<div class="tbl-matches">
						<div class="float-container">
							<div class="float-child-left">
								<h2>${item.m_match_date} <span style = "font-weight: 400;font-size: 20px;">(${item.m_format} ov)</span></h2>
								<div class="float-container">
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.m_team_1_id}"><span class="team-name">${item.m_team_1_team_name}</span></a><br />
											<span class="age-group">${item.m_team_1_age_group}</span><br />
											<span class="score">${item.m_innings_1_total} /
												${item.m_innings_1_wickets} (${item.m_innings_1_overs} ov)</span>
										</p>
									</div>
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.m_team_2_id}"><span class="team-name">${item.m_team_2_team_name}</span></a><br />
											<span class="age-group">${item.m_team_2_age_group}</span><br />
											<span class="score">${item.m_innings_2_total} /
												${item.m_innings_2_wickets} (${item.m_innings_2_overs} ov)</span>
										</p>
									</div>
								</div>
								<p class="result">${item.m_win_message}</p>
							</div>
							<div class="float-child-right">
								<button class="btn-view-match" type="button"
									onClick="window.location.href='Match-Scorecard?matchID=${item.m_match_id}'">View
									Match</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</div>
</body>

</html>