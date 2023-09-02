<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${requestScope.playerprofile}" var="a"></c:set>
<c:set value="${requestScope.seasonsPlayed}" var="b"></c:set>
<c:set value="${requestScope.playerstats}" var="c"></c:set>
<c:set value="${requestScope.playerteams}" var="d"></c:set>
<c:set value="${requestScope.matchinformation}" var="e"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Player Profile</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/player-profile.css" />

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
				<li class="selected"><a
					href="Players?sortBy=Player+Name&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-person-running"></i>
						<span class="nav-item">Players</span>
				</a></li>
				<li><a
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
						</button><c:out value="${a.playerName}" /></h1>
					<h2><c:out value="${a.dob}" /></h2>
					<h2><c:out value="${a.role}" /></h2>
			</div> <!-- Profile heading End -->
			
			<div class="tabs"> <!-- Tab Links -->
				<button class="tab-links active"
					onclick="openTab(event, 'Statistics')">Statistics</button>
				<button class="tab-links" onclick="openTab(event, 'Teams')">Teams</button>
				<button class="tab-links" onclick="openTab(event, 'Matches')">Matches</button>
			</div> <!-- Tab Links End -->
			
			<div id="Statistics" class="tab-content" style="display: block"> <!--Tab Content (1) -->
				<form id="StatisticsForm" action="Player-Profile?playerID=${player_id}" method="get">
					<div class="select-menu"> <!-- Drop-down Menu -->
						<div class="select-btn" onclick="selectionMenu(event)">
							<span class="sBtn-text">${season}</span> <i class="fa-solid fa-chevron-down"></i>
						</div>
						<input type="hidden" name="playerID" id="selectedSeason" value="${player_id}"> 
						<ul class="options">
							<li class="option">
								<span class="option-text">
									<input type="submit" name="season" id="selectedSeason" value="All-Time">
								</span></li>
							<c:forEach var="item" items="${b}"> <!-- Creates a drop-down option for every season a player has played specific to their Player_ID -->
								<li class="option"><span class="option-text"><input
										type="submit" name="season" id="selectedSeason"
										value="${item.season}"></span></li>
							</c:forEach>
						</ul>
					</div> <!-- Drop-down Menu End -->
				</form>
				
				<div>
					<h2>Batting & Fielding</h2>
					<table>
						<tr>
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
							<th>Ct</th>
							<th>St</th>
						</tr>
						<tbody>
							<c:forEach var="item" items="${c}"> <!-- Creates table row for the player's batting and fielding statistics which is ("playerstats") -->
								<tr>
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
									<td>${item.catches}</td>
									<td>${item.stumpings}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<h2>Bowling</h2>
					<table>
						<tr>
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
						<c:forEach var="item" items="${c}"> <!-- Creates table row for the player's bowling statistics which is ("playerstats") -->
							<tr>
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
					</table>
				</div>
			</div> <!--Tab Content (1) End -->
			
			<div id="Teams" class="tab-content"> <!--Tab Content (2) -->
				<c:forEach var="item" items="${d}"> <!-- Creates a 'module' for each team the player has played for ("playerteams") -->
					<div class="tbl-team align-left">
						<div class="float-child-left">
							<h2>
								<span class="team-name">${item.teamName}</span><br> <span
									class="age-group">${item.ageGroup}</span><br> <span
									class="location">${item.location}</span>
							</h2>
						</div>
						<div class="float-child-right">
							<button type="button" class="btn-view-team"
								onClick="window.location.href='Team-Profile?teamID=${item.teamID}'">View
								Team</button>
						</div>
					</div>
				</c:forEach>
			</div> <!--Tab Content (2) End -->
			
			<div id="Matches" class="tab-content"> <!--Tab Content (3) -->
				<c:forEach var="item" items="${e}"> <!-- Creates a 'module' for each match the player has played ("matchinformation") -->
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