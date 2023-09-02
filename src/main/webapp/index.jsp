<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${requestScope.topscorers}" var="a"></c:set>
<c:set value="${requestScope.topwickettakers}" var="b"></c:set>
<c:set value="${requestScope.matchinformation}" var="c"></c:set>
<c:set value="${requestScope.fixtureinformation}" var="d"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Dashboard</title>

<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/nav-bar.css" type="text/css" />
<link rel="stylesheet" href="css/dashboard.css" type="text/css" />

<script src="https://kit.fontawesome.com/1374555d03.js" crossorigin="anonymous"></script>
<script src="scripts/scripts.js"></script>
</head>

<body>
	<div class="container">
		<nav> <!-- Navigation Bar -->
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
				<li><a href="Player-Management?playerID=" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Player Management</span>
				</a></li>
				<li><a href="Team-Management?teamID=" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Team Management</span>
				</a></li>
			</ul>
		</nav> <!-- Navigation Bar End -->
		
		<section class="main"> <!-- Main-Content -->
			<div class="left"> <!-- Left Column -->
				<h1 class="dashboard-heading">Most Total Runs</h1>
				<table class="tbl-dashboard">
					<tr>
						<th>Player Name</th>
						<th>Runs Scored</th>
						<th>Balls Faced</th>
					</tr>
					<tbody>
					<c:forEach end = "3" var="item" items="${a}">
						<tr>
    						<td><a href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
							<td>${item.runsScored}</td>
							<td>${item.ballsFaced}</td>
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
					<c:forEach end = "3" var="item" items="${b}">
						<tr>
    						<td><a href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
							<td>${item.wicketsTaken}</td>
							<td>${item.runsConceded}</td>
						</tr>
					</c:forEach>
				</table>
				<p class="text-btn">View the all player statistics.</p>
				<button class="btn-view-more" type="button" onclick="window.location.href='Players?sortBy=Player+Name&direction=fa-arrow-down-a-z&search='"
					id="In-Form-Button">View More</button>
			</div> <!-- Left Column End -->
			
			<div class="right"> <!-- Right Column -->
				<div class="row"> <!-- 1st Row -->
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Recent Results</h1>
							<c:forEach end = "0" var="item" items="${c}">
								<h2>${item.matchDate} <span style = "font-weight: 400;font-size: 20px;">(${item.format} ov)</span></h2>
								<div class="float-container">
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.teamID1}"><span class="team-name">${item.teamName1}</span></a><br />
											<span class="age-group">${item.teamAgeGroup1}</span><br />
											<span class="score">${item.inningsTotal1} /
												${item.inningsWickets1} (${item.inningsOvers1} ov)</span>
										</p>
									</div>
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.teamID2}"><span class="team-name">${item.teamName2}</span></a><br />
											<span class="age-group">${item.teamAgeGroup2}</span><br />
											<span class="score">${item.inningsTotal2} /
												${item.inningsWickets2} (${item.inningsOvers2} ov)</span>
										</p>
									</div>
								</div>
								<p class="result">${item.winMessage}</p>
							</c:forEach>
						</div>
						<div class="float-child-right">
							<p class="text-btn">View the full list of results & fixtures.</p>
							<button class="btn-view-more" type="button"
								onclick="window.location.href='Matches?sortBy=Date&direction=fa-arrow-down-a-z&search='">View More</button>
						</div>
					</div>
				</div> <!-- 1st Row End -->
				
				<div class="row"> <!-- 2nd Row -->
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Upcoming Fixture</h1>
							<c:forEach end = "0" var="item" items="${d}">
								<h2>${item.matchDate} <span style = "font-weight: 400;font-size: 20px;">(${item.format} ov)</span></h2>
								<div class="float-container">
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.teamID1}"><span class="team-name">${item.teamName1}</span></a><br />
											<span class="age-group">${item.teamAgeGroup1}</span><br />
											<span style="color: white">.</span>
										</p>
									</div>
									<div class="float-child">
										<p>
											<a href="Team-Profile?teamID=${item.teamID2}"><span class="team-name">${item.teamName2}</span></a><br />
											<span class="age-group">${item.teamAgeGroup2}</span><br />
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
				</div> <!-- 2nd Row End -->
				
				<div class="row-half"> <!-- 3rd Row -->
							<h1 class="dashboard-heading">Player Management</h1>
							<p class="text-btn">Create & edit players.</p>
							<button class="btn-view-more" type="button"
								onclick="window.location.href='Player-Management?playerID='">View More</button>
				</div> <!-- 3rd Row End -->	
				<div class="row-half second-half"> <!-- 3rd Row -->
							<h1 class="dashboard-heading">Team Management</h1>
							<p class="text-btn">Create & edit teams.</p>
							<button class="btn-view-more" type="button"
								onclick="window.location.href='Team-Management?teamID='">View More</button>
				</div> <!-- 3rd Row End -->	
			</div> <!-- Right Column End -->
		</section> <!-- Main-Content End -->
	</div>
</body>

</html>