<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${requestScope.sortby}" var="a"></c:set>
<c:set value="${requestScope.direction}" var="b"></c:set>
<c:set value="${requestScope.search}" var="c"></c:set>
<c:set value="${requestScope.matchinformation}" var="d"></c:set>
<c:set value="${requestScope.fixtureinformation}" var="e"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>CricketDB | Matches</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/matches.css" />

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
				<li><a
					href="Teams?sortBy=Team+Name&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-people-group"></i>
						<span class="nav-item">Teams</span>
				</a></li>
				<li class="selected"><a
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
			<div class="tabs"> <!--Tab Links-->
				<button class="tab-links active" onclick="openTab(event, 'Results')">Results</button>
				<button class="tab-links" onclick="openTab(event, 'Fixtures')">Fixtures</button>
			</div> <!--Tab Links End-->
			
			<div class="filters"> <!-- Sort-By Bar -->
				<div class="select-menu">
					<div class="select-btn" onclick="selectionSortByMenu(event)">
						<span class="sBtn-text"><c:out value="${a}" /></span> <i
							class="fa-solid fa-chevron-down"></i>
					</div>
					<ul class="options">
						<li class="option"><span class="option-text">Date</span></li>
						<li class="option"><span class="option-text">Format</span></li>
					</ul>
				</div>
				
				<button type="button" class="order" onClick="sortBy()">
					<i id="directionToggle" class="fa-solid <c:out value="${b}"/>"></i>
				</button>
				
				<form action="Matches?" id="playerSearchFrom" method="get">  <!-- Form determines the query criteria (SORT BY & WHERE Team_Name LIKE) -->
					<input type="hidden" id="sortby" name="sortBy" value="<c:out value="${a}"/>"> <input type="hidden" id="direction" name="direction" value="<c:out value="${b}"/>">
					<input type="text" id="search" placeholder="Search Team Name..." name="search" value="<c:out value="${c}"/>"> <input type="submit" id="submitQuery" />
				</form> <!-- Sort-By Bar End -->
			</div> <!-- Sort-By Bar End -->
			
			<div id="Results" class="tab-content" style="display: block"> <!-- Tab Content (1) -->
				<c:forEach var="item" items="${d}"> <!-- Creates a 'module' for each match ("matchinformation") -->
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
			</div> <!-- Tab Content (1) End -->
			
			<div id="Fixtures" class="tab-content"> <!-- Tab Content (2) -->
				<c:forEach var="item" items="${e}"> <!-- Creates a 'module' for each fixture ("fixtureinformation") -->
					<div class="tbl-fixtures">
						<h2>${item.matchDate} <span style = "font-weight: 400;font-size: 20px;">(${item.format} ov)</span></h2>
						<div class="float-container">
							<div class="float-child">
								<p>
									<a href="Team-Profile?teamID=${item.teamID1}"><span class="team-name">${item.teamName1}</span></a><br />
									<span class="age-group">${item.teamAgeGroup1}</span><br />
								</p>
							</div>
							<div class="float-child">
								<p>
									<a href="Team-Profile?teamID=${item.teamID2}"><span class="team-name">${item.teamName2}</span></a><br />
									<span class="age-group">${item.teamAgeGroup2}</span><br />
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div> <!-- Tab Content (2) End -->
		</section> <!-- Main-Content End -->
	</div>
</body>
</html>
