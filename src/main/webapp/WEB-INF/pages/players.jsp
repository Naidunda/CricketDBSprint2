<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${requestScope.playerstatistics}" var="b"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Players</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/players.css" />

<script src="https://kit.fontawesome.com/1374555d03.js"
	crossorigin="anonymous"></script>
<script src="scripts/players.js"></script>
</head>

<body>
	<div class="container">
		<nav>
			<ul>
				<li><a href="index.jsp" class="logo"> <span
						class="nav-item">CricketDB</span>
				</a></li>
				<li><a href="index.jsp" class="nav-list"> <i
						class="fas fa-solid fa-table-columns"></i> <span class="nav-item">Dashboard</span>
				</a></li>
				<li class="selected"><a href="players.jsp" class="nav-list">
						<i class="fas fa-solid fa-person-running"></i> <span
						class="nav-item">Players</span>
				</a></li>
				<li><a href="teams.jsp" class="nav-list"> <i
						class="fas fa-solid fa-people-group"></i> <span class="nav-item">Teams</span>
				</a></li>
				<li><a href="matches.jsp" class="nav-list"> <i
						class="fas fa-solid fa-calendar-days"></i> <span class="nav-item">Matches</span>
				</a></li>
				<li><a href="management.jsp" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Management</span>
				</a></li>
			</ul>
		</nav>
		<section class="main">
			<!--Tab Links-->
			<div class="tabs">
				<button class="tab-links active" onclick="openTab(event, 'All')">All</button>
				<button class="tab-links" onclick="openTab(event, 'Batsmen')">Batsmen</button>
				<button class="tab-links" onclick="openTab(event, 'Bowlers')">Bowlers</button>
				<button class="tab-links" onclick="openTab(event, 'Fielders')">Fielders</button>
			</div>
			<div class="filters">
				<button type="button">
					<i class="fa-solid fa-sort"></i>Sort By
				</button>
				<button type="button" class="order" onClick="sortBy()">
					<i id="SortBy" class="fa-solid fa-arrow-down-a-z"></i>
				</button>
				<button type="button">
					<i class="fa-solid fa-filter"></i>Filter
				</button>
				<input type="text" placeholder="Search..">
			</div>
			<!--Tab Content-->
			<div id="All" class="tab-content" style="display: block">
				<table class="tbl-statistics">
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
								<td><a href="player-profile.html">${item.p_player_name}</a></td>
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
			<div id="Batsmen" class="tab-content">
				<table class="tbl-statistics">
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
								<td><a href="player-profile.html">${item.p_player_name}</a></td>
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
			<div id="Bowlers" class="tab-content">
				<table class="tbl-statistics">
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
								<td><a href="player-profile.html">${item.p_player_name}</a></td>
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
			<div id="Fielders" class="tab-content">
				<table class="tbl-statistics">
					<tr>
						<th>Name</th>
						<th>Matches</th>
						<th>R/O</th>
						<th>Ct</th>
						<th>St</th>
					</tr>
					<tbody>
						<c:forEach var="item" items="${b}">
							<tr>
								<td><a href="player-profile.html">${item.p_player_name}</a></td>
								<td>${item.p_matches}</td>
								<td>${item.p_run_outs}</td>
								<td>${item.p_catches}</td>
								<td>${item.p_stumpings}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</div>
</body>

</html>