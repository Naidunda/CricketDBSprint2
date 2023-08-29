<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${requestScope.matchinformation}" var="a"></c:set>
<c:set value="${requestScope.fixtureinformation}" var="b"></c:set>

<c:set value="${requestScope.sortby}" var="d"></c:set>
<c:set value="${requestScope.direction}" var="e"></c:set>
<c:set value="${requestScope.search}" var="f"></c:set>

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
<script src="scripts/matches.js"></script>
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
					href="Teams?sortBy=Team+Name&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-people-group"></i>
						<span class="nav-item">Teams</span>
				</a></li>
				<li class="selected"><a
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
			<!--Tab Links-->
			<div class="tabs">
				<button class="tab-links active" onclick="openTab(event, 'Results')">Results</button>
				<button class="tab-links" onclick="openTab(event, 'Fixtures')">Fixtures</button>
			</div>
			<div class="filters">
				<div class="select-menu">
					<div class="select-btn" onclick="selectionMenu(event)">
						<span class="sBtn-text"><c:out value="${d}" /></span> <i
							class="fa-solid fa-chevron-down"></i>
					</div>
					<ul class="options">
						<li class="option"><span class="option-text">Date</span></li>
						<li class="option"><span class="option-text">Format</span></li>
					</ul>
				</div>
				<button type="button" class="order" onClick="sortBy()">
					<i id="directionToggle" class="fa-solid <c:out value="${e}"/>"></i>
				</button>
				<form action="Matches?" id="playerSearchFrom" method="get">
					<input type="hidden" id="sortby" name="sortBy"
						value="<c:out value="${d}"/>"> <input type="hidden"
						id="direction" name="direction" value="<c:out value="${e}"/>">
					<input type="text" id="search" placeholder="Search Team Name..."
						name="search" value="<c:out value="${f}"/>"> <input
						type="submit" id="submitQuery" />
				</form>
			</div>
			<!--Tab Content-->
			<div id="Results" class="tab-content" style="display: block">
				<c:forEach var="item" items="${a}">
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
			<div id="Fixtures" class="tab-content">
				<c:forEach var="item" items="${b}">
					<div class="tbl-fixtures">
						<h2>${item.f_match_date} <span style = "font-weight: 400;font-size: 20px;">(${item.f_format} ov)</span></h2>
						<div class="float-container">
							<div class="float-child">
								<p>
									<a href="Team-Profile?teamID=${item.f_team_1_id}"><span class="team-name">${item.f_team_1_team_name}</span></a><br />
									<span class="age-group">${item.f_team_1_age_group}</span><br />
								</p>
							</div>
							<div class="float-child">
								<p>
									<a href="Team-Profile?teamID=${item.f_team_2_id}"><span class="team-name">${item.f_team_2_team_name}</span></a><br />
									<span class="age-group">${item.f_team_2_age_group}</span><br />
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</div>
</body>
</html>
