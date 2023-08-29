<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${requestScope.matchsummary}" var="a"></c:set>

<c:set value="${requestScope.battinginnings1}" var="b"></c:set>
<c:set value="${requestScope.dnbinnings1}" var="c"></c:set>
<c:set value="${requestScope.bowlinginnings1}" var="d"></c:set>

<c:set value="${requestScope.battinginnings2}" var="e"></c:set>
<c:set value="${requestScope.dnbinnings2}" var="f"></c:set>
<c:set value="${requestScope.bowlinginnings2}" var="g"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Match Scorecard</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/match-scorecard.css" />

<script src="https://kit.fontawesome.com/1374555d03.js"
	crossorigin="anonymous"></script>
<script src="scripts/match-scorecard.js"></script>
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
				<li><a
					href="Teams?sortBy=Date&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-people-group"></i>
						<span class="nav-item">Teams</span>
				</a></li>
				<li class="selected"><a
					href="Matches?sortBy=Date&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-calendar-days"></i>
						<span class="nav-item">Matches</span>
				</a></li>
				<li><a href="management" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Management</span>
				</a></li>
			</ul>
		</nav>
		<section class="main">
			<h1>Match Summary</h1>

			<div class="scorecard-content float-container">
				<div class="float-child left-align">
					<p>
						<a href="Team-Profile?teamID=<c:out value="${a.m_team_1_id}"/>"><c:out
								value="${a.m_team_1_team_name}" /> (<c:out
								value="${a.m_team_1_age_group}" />)</a>
					</p>
				</div>
				<div class="float-child right-align">
					<p>
						<c:out value="${a.m_innings_1_wickets}" />
						/
						<c:out value="${a.m_innings_1_total}" />
						(
						<c:out value="${a.m_innings_1_overs}" />
						ov)
					</p>
				</div>
			</div>

			<div class="scorecard-content float-container">
				<div class="float-child left-align">
					<p>
						<a href="Team-Profile?teamID=<c:out value="${a.m_team_2_id}"/>"><c:out
								value="${a.m_team_2_team_name}" />(<c:out
								value="${a.m_team_1_age_group}" />)</a>
					</p>
				</div>
				<div class="float-child right-align">
					<p>
						<c:out value="${a.m_innings_2_wickets}" />
						/
						<c:out value="${a.m_innings_2_total}" />
						(
						<c:out value="${a.m_innings_2_overs}" />
						ov)
					</p>
				</div>
			</div>

			<div class="tabs">
				<button class="tab-links active"
					onclick="openTab(event, 'First-Innings')">1st Innings</button>
				<button class="tab-links" onclick="openTab(event, 'Second-Innings')">2nd
					Innings</button>
			</div>


			<div id="First-Innings" class="tab-content" style="display: block">
				<h1>
					<c:out value="${a.m_team_1_team_name}" />
				</h1>
				<h2>50 ovs maximum</h2>
				<table class="scorecard">
					<tr>
						<th>Batsman Name</th>
						<th></th>
						<th>R</th>
						<th>B</th>
						<th>4's</th>
						<th>6's</th>
						<th>SR</th>
					</tr>
					<tbody>
						<c:forEach var="item" items="${b}">
							<tr>
								<td><a
									href="Player-Profile?playerID=${item.s_batsman_id}&season=All-Time">${item.s_batsman_name}</a></td>
								<td>${item.s_dismissal_message}</td>
								<td>${item.s_runs_scored}</td>
								<td>${item.s_balls_faced}</td>
								<td>${item.s_fours}</td>
								<td>${item.s_sixes}</td>
								<td>${item.s_strike_rate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>
					Did not bat:
					<c:forEach var="item" items="${c}">
						<a
							href="Player-Profile?playerID=${item.s_batsman_id}&season=All-Time">${item.s_batsman_name}</a>, 
						</c:forEach>
				</p>

				<h1>
					<c:out value="${a.m_team_2_team_name}" />
				</h1>
				<table class="scorecard">
					<tr>
						<th>Bowler Name</th>
						<th>Ov</th>
						<th>M</th>
						<th>R</th>
						<th>W</th>
						<th>Eco</th>
						<th>Avg</th>
						<th>Wi</th>
						<th>NB</th>
					</tr>
					<c:forEach var="item" items="${d}">
						<tr>
							<td><a
								href="Player-Profile?playerID=${item.s_bowler_id}&season=All-Time">${item.s_bowler_name}</a></td>
							<td>${item.s_overs}</td>
							<td>${item.s_maidens}</td>
							<td>${item.s_runs_conceded}</td>
							<td>${item.s_wickets_taken}</td>
							<td>${item.s_economy}</td>
							<td>${item.s_average}</td>
							<td>${item.s_wide}</td>
							<td>${item.s_no_ball}</td>

						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="Second-Innings" class="tab-content">
				<h1>
					<c:out value="${a.m_team_2_team_name}" />
				</h1>
				<h2>50 ovs maximum</h2>
				<table class="scorecard">
					<tr>
						<th>Batsman Name</th>
						<th></th>
						<th>R</th>
						<th>B</th>
						<th>4's</th>
						<th>6's</th>
						<th>SR</th>
					</tr>
					<tbody>
						<c:forEach var="item" items="${e}">
							<tr>
								<td><a
									href="Player-Profile?playerID=${item.s_batsman_id}&season=All-Time">${item.s_batsman_name}</a></td>
								<td>${item.s_dismissal_message}</td>
								<td>${item.s_runs_scored}</td>
								<td>${item.s_balls_faced}</td>
								<td>${item.s_fours}</td>
								<td>${item.s_sixes}</td>
								<td>${item.s_strike_rate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>
					Did not bat:
					<c:forEach var="item" items="${f}">
						<a
							href="Player-Profile?playerID=${item.s_batsman_id}&season=All-Time">${item.s_batsman_name}</a>, 
						</c:forEach>
				</p>
				<h1>
					<c:out value="${a.m_team_1_team_name}" />
				</h1>
				<table class="scorecard">
					<tr>
						<th>Bowler Name</th>
						<th>Ov</th>
						<th>M</th>
						<th>R</th>
						<th>W</th>
						<th>Eco</th>
						<th>Wi</th>
						<th>NB</th>
					</tr>
					<c:forEach var="item" items="${g}">
						<tr>
							<td><a
								href="Player-Profile?playerID=${item.s_bowler_id}&season=All-Time">${item.s_bowler_name}</a></td>
							<td>${item.s_overs}</td>
							<td>${item.s_maidens}</td>
							<td>${item.s_runs_conceded}</td>
							<td>${item.s_wickets_taken}</td>
							<td>${item.s_economy}</td>
							<td>${item.s_average}</td>
							<td>${item.s_wide}</td>
							<td>${item.s_no_ball}</td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</div>
</body>

</html>