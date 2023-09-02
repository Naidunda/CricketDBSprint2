<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${requestScope.teamsinformation}" var="a"></c:set>
<c:set value="${requestScope.playerinformation}" var="b"></c:set>
<c:set value="${requestScope.playerstatistics}" var="c"></c:set>
<c:set value="${requestScope.matchinformation}" var="d"></c:set>

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
<script src="scripts/scripts.js"></script>
</head>

<body>
	<div class="container">
		<nav> <!-- Navigation Bar -->
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
				<li><a href="Player-Management?playerID=" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Player Management</span>
				</a></li>
				<li><a href="Team-Management?teamID=" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Team Management</span>
				</a></li>
			</ul>
		</nav> <!-- Navigation Bar End -->
		
		<section class="main"> <!-- Main-Content -->
			<div class="profile-heading"> <!-- Profile Heading -->
					<h1>
						<button onclick="history.back()" class="btn-back">
							<i class="fa-solid fa-arrow-left-long"></i>
						</button><c:out value="${a.teamName}" /></h1>
					<h2><c:out value="${a.ageGroup}" /></h2>
					<h2><c:out value="${a.location}" /></h2>
			</div> <!-- Profile heading End -->
			
			<div class="tabs"> <!--Tab Links-->
				<button class="tab-links active" onclick="openTab(event, 'Players')">
					Players</button>
				<button class="tab-links" onclick="openTab(event, 'Statistics')">
					Statistics</button>
				<button class="tab-links" onclick="openTab(event, 'Matches')">
					Matches</button>
			</div> <!--Tab Links End-->
			
			<div id="Players" class="tab-content" style="display: block"> <!--Tab Content (1) -->
				<table>
					<tr>
						<th>Player Name</th>
						<th>DOB</th>
						<th>Role</th>
					</tr>
					<tbody>
						<c:forEach var="item" items="${b}"> <!-- Creates table row for for the player's information which play for the team ("playerinformation") -->
							<tr>
								<td><a
									href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
								<td>${item.dob}</td>
								<td>${item.role}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div> <!--Tab Content (1) End -->
			
			<div id="Statistics" class="tab-content"> <!--Tab Content (2) -->
				<div class="select-menu"> <!-- Drop-down Menu -->
					<div class="select-btn" onclick="selectionTabMenu(event)">
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
				</div> <!-- Drop-down Menu End -->
				
				<div> <!--Sub-Tab Content (1) -->
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
								<c:forEach var="item" items="${c}"> <!-- Creates table row for for the player's statistics which play for the team ("playerstatistics") -->
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
										<td>${item.matches}</td>
										<td>${item.runsScored}</td>
										<td>${item.highScore}</td>
										<td>${item.battingAverage}</td>
										<td>${item.hundreds}</td>
										<td>${item.wicketsTaken}</td>
										<td>${item.bestFigures}</td>
										<td>${item.bowlingAverage}</td>
										<td>${item.fiveWickets}</td>
										<td>${item.catches}</td>
										<td>${item.stumpings}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div> <!--Sub-Tab Content (1) End -->
					
					<div id="Batting" class="statistics-content"> <!--Sub-Tab Content (2) -->
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
								<c:forEach var="item" items="${c}"> <!-- Creates table row for the player's batting statistics which play for the team ("playerstatistics") -->
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
										<td>${item.matches}</td>
										<td>${item.battingInnings}</td>
										<td>${item.notOuts}</td>
										<td>${item.highScore}</td>
										<td>${item.battingAverage}</td>
										<td>${item.battingStrikeRate}</td>
										<td>${item.fifties}</td>
										<td>${item.hundreds}</td>
										<td>${item.fours}</td>
										<td>${item.sixes}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div> <!--Sub-Tab Content (2) End -->
					
					<div id="Bowling" class="statistics-content"> <!--Sub-Tab Content (3) -->
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
								<c:forEach var="item" items="${c}"> <!-- Creates table row for the player's bowling statistics which play for the team ("playerstatistics") -->
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
										<td>${item.matches}</td>
										<td>${item.bowlingInnings}</td>
										<td>${item.ballsBowled}</td>
										<td>${item.wicketsTaken}</td>
										<td>${item.runsConceded}</td>
										<td>${item.bestFigures}</td>
										<td>${item.bowlingAverage}</td>
										<td>${item.economy}</td>
										<td>${item.bowlingStrikeRate}</td>
										<td>${item.fiveWickets}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div> <!--Sub-Tab Content (3) End -->
					
					<div id="Fielding" class="statistics-content"> <!--Sub-Tab Content (4) -->
						<table>
							<tr>
								<th>Name</th>
								<th>Matches</th>
								<th>Ct</th>
								<th>St</th>
							</tr>
							<tbody>
								<c:forEach var="item" items="${c}"> <!-- Creates table row for the player's fielding statistics which play for the team ("playerstatistics") -->
									<tr>
										<td><a
											href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
										<td>${item.matches}</td>
										<td>${item.catches}</td>
										<td>${item.stumpings}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div> <!--Sub-Tab Content (4) End -->
				</div>
			</div> <!--Tab Content (2) End -->
			
			<div id="Matches" class="tab-content"> <!--Tab Content (3) -->
				<c:forEach var="item" items="${d}"> <!-- Creates a 'module' for each match the team has played for ("matchinformation") -->
					<div class="tbl-matches">
						<div class="float-container">
							<div class="float-child-left">
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
							</div>
							<div class="float-child-right">
								<button class="btn-view-match" type="button"
									onClick="window.location.href='Match-Scorecard?matchID=${item.matchID}'">View
									Match</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div> <!--Tab Content (3) End -->
		</section> <!-- Main-Content End -->
	</div>
</body>

</html>