<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${requestScope.topwickettakers}" var="a"></c:set>
<c:set value="${requestScope.topscorers}" var="b"></c:set>

<c:set value="${requestScope.matchinformation}" var="d"></c:set>
<c:set value="${requestScope.fixtureinformation}" var="e"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Dashboard</title>

<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/nav-bar.css" type="text/css" />
<link rel="stylesheet" href="css/dashboard.css" type="text/css" />

<script src="https://kit.fontawesome.com/1374555d03.js" crossorigin="anonymous"></script>
<script src="scripts/dashboard.js"></script>
</head>

<body>
	<div class="container">
		<nav>
			<ul>
				<li><a href="Dashboard" class="logo"> <span
						class="nav-item">CricketDB</span>
				</a></li>
				<li class="selected"><a href="Dashboard" class="nav-list">
						<i class="fas fa-solid fa-table-columns"></i> <span
						class="nav-item">Dashboard</span>
				</a></li>
				<li><a href="Players?sortBy=Player+Name&direction=fa-arrow-down-a-z&search=" class="nav-list"> <i
						class="fas fa-solid fa-person-running"></i> <span class="nav-item">Players</span>
				</a></li>
				<li><a href="Teams?sortBy=Team+Name&direction=fa-arrow-down-a-z&search=" class="nav-list"> <i
						class="fas fa-solid fa-people-group"></i> <span class="nav-item">Teams</span>
				</a></li>
				<li><a href="Matches?sortBy=Date&direction=fa-arrow-down-a-z&search=" class="nav-list"> <i
						class="fas fa-solid fa-calendar-days"></i> <span class="nav-item">Matches</span>
				</a></li>
				<li><a href="Management" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Management</span>
				</a></li>
			</ul>
		</nav>
		<section class="main">
			<div class="left">
				<h1 class="dashboard-heading">Most Total Runs</h1>
				<table class="tbl-dashboard">
					<tr>
						<th>Player Name</th>
						<th>Runs Scored</th>
						<th>Balls Faced</th>
					</tr>
					<tbody>
					<c:forEach end = "3" var="item" items="${b}">
						<tr>
    						<td><a href="Player-Profile?playerID=${item.p_player_id}&season=All-Time">${item.p_player_name}</a></td>
							<td>${item.p_runs_scored}</td>
							<td>${item.p_balls_faced}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<h1 class="dashboard-heading">Most Wickets Taken</h1>
				<table class="tbl-dashboard">
					<tr>
						<th>Player Name</th>
						<th>Wickets Taken</th>
						<th>Runs Conceded</th>
					</tr>
					<c:forEach end = "3" var="item" items="${a}">
						<tr>
    						<td><a href="Player-Profile?playerID=${item.p_player_id}&season=All-Time">${item.p_player_name}</a></td>
							<td>${item.p_wickets_taken}</td>
							<td>${item.p_runs_conceded}</td>
						</tr>
					</c:forEach>
				</table>
				<p class="text-btn">View the all player statistics.</p>
				<button class="btn-view-more" type="button" onclick="window.location.href='Players?sortBy=Player+Name&direction=fa-arrow-down-a-z&search='"
					id="In-Form-Button">View More</button>
			</div>
			<div class="right">
				<div class="row">
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Recent Results</h1>
							<c:forEach end = "0" var="item" items="${d}">
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
							</c:forEach>
						</div>
						<div class="float-child-right">
							<p class="text-btn">View the full list of results & fixtures.</p>
							<button class="btn-view-more" type="button"
								onclick="window.location.href='Matches?sortBy=Date&direction=fa-arrow-down-a-z&search='">View More</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Upcoming Fixture</h1>
							<c:forEach end = "0" var="item" items="${e}">
								<h2>${item.f_match_date} <span style = "font-weight: 400;font-size: 20px;">(${item.f_format} ov)</span></h2>
								<div class="float-container">
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.f_team_1_id}"><span class="team-name">${item.f_team_1_team_name}</span></a><br />
											<span class="age-group">${item.f_team_1_age_group}</span><br />
											<span style="color: white">.</span>
										</p>
									</div>
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.f_team_2_id}"><span class="team-name">${item.f_team_2_team_name}</span></a><br />
											<span class="age-group">${item.f_team_2_age_group}</span><br />
											<span style="color: white">.</span>
										</p>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="float-child-right">
							<p class="text-btn">View the full list of results & fixtures.</p>
							<button class="btn-view-more" type="button"
								onclick="window.location.href='Matches?sortBy=Date&direction=fa-arrow-down-a-z&search='">View More</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Blank</h1>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

</html>