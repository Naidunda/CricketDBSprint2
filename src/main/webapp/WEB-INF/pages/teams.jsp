<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${requestScope.teamsinformation}" var="a"></c:set>
<c:set value="${requestScope.sortby}" var="b"></c:set>
<c:set value="${requestScope.direction}" var="d"></c:set>
<c:set value="${requestScope.search}" var="e"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Teams</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/teams.css" />

<script src="https://kit.fontawesome.com/1374555d03.js"
	crossorigin="anonymous"></script>
<script src="scripts/teams.js"></script>
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
				<li><a href="Players?sortBy=Player+Name&direction=fa-arrow-down-a-z&search=" class="nav-list"> <i
						class="fas fa-solid fa-person-running"></i> <span class="nav-item">Players</span>
				</a></li>
				<li class="selected"><a href="Teams?sortBy=Team+Name&direction=fa-arrow-down-a-z&search=" class="nav-list"> <i
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
			<!--Tab Links-->
			<div class="tabs">
				<button class="tab-links active" onclick="openTab(event, 'All')">All</button>
				<button class="tab-links" onclick="openTab(event, 'Schools')">School</button>
				<button class="tab-links" onclick="openTab(event, 'Clubs')">Clubs</button>
			</div>
			<div class="filters">
				<div class="select-menu">
					<div class="select-btn" onclick="selectionMenu(event)">
						<span class="sBtn-text"><c:out value="${b}"/></span> <i
							class="fa-solid fa-chevron-down"></i>
					</div>

					<ul class="options">
						<li class="option"><span class="option-text">Team Name</span></li>
						<li class="option"><span class="option-text">Age Group</span></li>
						<li class="option"><span class="option-text">Location</span></li>
					</ul>
				</div>
				<button type="button" class="order" onClick="sortBy()">
					<i id="directionToggle" class="fa-solid <c:out value="${d}"/>"></i>
				</button>
				<form action="Teams?" id = "playerSearchFrom" method="get">
					<input type="hidden" id="sortby" name="sortBy" value="<c:out value="${b}"/>">
					<input type="hidden" id="direction" name="direction" value="<c:out value="${d}"/>">
					<input type="text" id="search" placeholder="Search Team Name..." name="search" value = "<c:out value="${e}"/>"> 
					<input type="submit" id="submitQuery"/>
				</form>
			</div> 
			
			<!--Tab Content-->
			<div id="All" class="tab-content" style="display: block">
				<c:forEach var="item" items="${a}">
					<div class="tbl-team align-left">
						<div class="float-child-left">
							<h2>
								<span class="team-name">${item.t_team_name}</span><br> <span
									class="age-group">${item.t_age_group}</span><br> <span
									class="location">${item.t_location}</span>
							</h2>
						</div>
						<div class="float-child-right">
							<button type="button" class="btn-view-team"
								onClick="window.location.href='Team-Profile?teamID=${item.t_team_id}'">View
								Team</button>
						</div>
					</div>
 				</c:forEach>
			</div>
			
			<div id="Schools" class="tab-content">
				<c:forEach var="item" items="${a}">
					<c:set var = "club" scope = "request" value = "${item.t_is_club}" />
					<c:if test="${club == 'false'}"> 
						<div class="tbl-team align-left">
							<div class="float-child-left">
								<h2>
									<span class="team-name">${item.t_team_name}</span><br> <span
										class="age-group">${item.t_age_group}</span><br> <span
										class="location">${item.t_location}</span>
								</h2>
							</div>
							<div class="float-child-right">
								<button type="button" class="btn-view-team"
									onClick="window.location.href='Team-Profile?teamID=${item.t_team_id}'">View
									Team</button>
							</div>
						</div>
					</c:if>
 				</c:forEach>
			</div>
			<div id="Clubs" class="tab-content">
				<c:forEach var="item" items="${a}">
					<c:set var = "club" scope = "request" value = "${item.t_is_club}" />
					<c:if test="${club == true}"> 
						<div class="tbl-team align-left">
							<div class="float-child-left">
								<h2>
									<span class="team-name">${item.t_team_name}</span><br> <span
										class="age-group">${item.t_age_group}</span><br> <span
										class="location">${item.t_location}</span>
								</h2>
							</div>
							<div class="float-child-right">
								<button type="button" class="btn-view-team"
									onClick="window.location.href='Team-Profile?teamID=${item.t_team_id}'">View
									Team</button> 
							</div>
						</div>
					</c:if>
 				</c:forEach>
			</div>
		</section>
	</div>
</body>

</html>