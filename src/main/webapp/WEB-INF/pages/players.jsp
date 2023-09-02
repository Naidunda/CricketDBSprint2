<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${requestScope.sortby}" var="a"></c:set>
<c:set value="${requestScope.direction}" var="b"></c:set>
<c:set value="${requestScope.search}" var="c"></c:set>
<c:set value="${requestScope.playerstatistics}" var="d"></c:set>


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
			<div class="tabs"> <!--Tab Links-->
				<button class="tab-links active" onclick="openTab(event, 'All')">All</button>
				<button class="tab-links" onclick="openTab(event, 'Batsmen')">Batsmen</button>
				<button class="tab-links" onclick="openTab(event, 'Bowlers')">Bowlers</button>
				<button class="tab-links" onclick="openTab(event, 'Fielders')">Fielders</button>
			</div> <!--Tab Links End-->
			
			<div class="filters"> <!-- Sort-By Bar -->
				<div class="select-menu">
					<div class="select-btn" onclick="selectionSortByMenu(event)">
						<span class="sBtn-text"><c:out value="${a}"/></span> <i
							class="fa-solid fa-chevron-down"></i>
					</div>
					<ul class="options">
						<li class="option"><span class="option-text">Player
								Name</span></li>
						<li class="option"><span class="option-text">Matches</span></li>

						<li class="option"><span class="option-text">Runs
								Scored</span></li>
						<li class="option"><span class="option-text">High
								Score</span></li>
						<li class="option"><span class="option-text">Batting
								Average</span></li>

						<li class="option"><span class="option-text">Wickets
								Taken</span></li>
						<li class="option"><span class="option-text">Best
								Figures</span></li>
						<li class="option"><span class="option-text">Bowling
								Average</span></li>

						<li class="option"><span class="option-text">Catches</span></li>
						<li class="option"><span class="option-text">Stumpings</span></li>
					</ul>
				</div>
				
				<button type="button" class="order" onClick="sortBy()">
					<i id="directionToggle" class="fa-solid <c:out value="${b}"/>"></i>
				</button>
				
				<form action="Players?" id = "playerSearchFrom" method="get"> <!-- Form determines the query criteria (SORT BY & WHERE Player_Name LIKE) -->
					<input type="hidden" id="sortby" name="sortBy" value="<c:out value="${a}"/>">
					<input type="hidden" id="direction" name="direction" value="<c:out value="${b}"/>">
					<input type="text" id="search" placeholder="Search Player Name..." name="search" value = "<c:out value="${c}"/>"> 
					<input type="submit" id="submitQuery"/>
				</form>
			</div> <!-- Sort-By Bar End -->
			
			<div id="All" class="tab-content" style="display: block"> <!-- Tab Content (1) -->
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
						<c:forEach var="item" items="${d}"> <!-- Creates table row for each player matching the search ("playerstatistics") -->
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
			</div> <!-- Tab Content (1) End -->
			
			<div id="Batsmen" class="tab-content"> <!-- Tab Content (2) -->
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
						<c:forEach var="item" items="${d}"> <!-- Creates table row for each player matching the search only showing batting statistics("playerstatistics") -->
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
			</div> <!-- Tab Content (2) End -->
			
			<div id="Bowlers" class="tab-content"> <!-- Tab Content (3) -->
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
						<c:forEach var="item" items="${d}"> <!-- Creates table row for each player matching the search only showing bowling statistics("playerstatistics") -->
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
			</div> <!-- Tab Content (3) End -->
			
			<div id="Fielders" class="tab-content"> <!-- Tab Content (4) -->
				<table class="tbl-statistics">
					<tr>
						<th>Name</th>
						<th>Matches</th>
						<th>R/O</th>
						<th>Ct</th>
						<th>St</th>
					</tr>
					<tbody>
						<c:forEach var="item" items="${d}"> <!-- Creates table row for each player matching the search only showing fielding statistics("playerstatistics") -->
							<tr>
								<td><a
									href="Player-Profile?playerID=${item.playerID}&season=All-Time">${item.playerName}</a></td>
								<td>${item.matches}</td>
								<td>${item.runOuts}</td>
								<td>${item.catches}</td>
								<td>${item.stumpings}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div> <!-- Tab Content (4) End -->
		</section> <!-- Main-Content End -->
	</div>
</body>

</html>