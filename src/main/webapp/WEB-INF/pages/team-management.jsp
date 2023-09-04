<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${requestScope.team}" var="a"></c:set>
<c:set value="${requestScope.teams}" var="b"></c:set>
<c:set value="${requestScope.teamplayers}" var="c"></c:set>
<c:set value="${requestScope.nonteamplayers}" var="d"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>CricketDB | Team Management</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/team-management.css" />

<script src="https://kit.fontawesome.com/1374555d03.js"
	crossorigin="anonymous"></script>
<script src="scripts/team-management.js"></script>

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
				<li><a
					href="Matches?sortBy=Date&direction=fa-arrow-down-a-z&search="
					class="nav-list"> <i class="fas fa-solid fa-calendar-days"></i>
						<span class="nav-item">Matches</span>
				</a></li>
				<li><a href="Player-Management?playerID=" class="nav-list">
						<i class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Player
							Management</span>
				</a></li>
				<li class="selected"><a href="Team-Management?teamID="
					class="nav-list"> <i class="fas fa-solid fa-chart-line"></i> <span
						class="nav-item">Team Management</span>
				</a></li>
			</ul>
		</nav> <!-- Navigation Bar End -->

		<section class="main"> <!-- Main-Content -->

			<div class="teams">
				<div class="left"> <!-- Left Column -->
					<iframe name="teams" style="display: none;"></iframe>

					<h1>Create A Team</h1>

					<form action="PostCreateTeam" method="post" target="teams">

						<input type="text" id="team-name" name="team-name"
							placeholder="Enter Team Name..." required /> <input type="text"
							id="location" name="location"
							placeholder="Enter Team's Location..." required />

						<h2>Select Team's Age Group:</h2>
						<div class="select-menu age-group"> <!-- Drop-down Menu -->
							<div class="select-btn"
								onclick="selectionMenu(event, 'age-group')">
								<span class="sBtn-text">Open</span> <i
									class="fa-solid fa-chevron-down"></i>
							</div>
							<ul class="options">
								<li class="option"><span class="option-text">Open</span></li>
								<li class="option"><span class="option-text">U19</span></li>
								<li class="option"><span class="option-text">U17</span></li>
								<li class="option"><span class="option-text">U15</span></li>
								<li class="option"><span class="option-text">U13</span></li>
								<li class="option"><span class="option-text">U11</span></li>
							</ul>
						</div> <!-- Drop-down Menu End -->
						
						<h2>Is the team a club:</h2>
						<div class="select-menu is-club"> <!-- Drop-down Menu -->
							<div class="select-btn" onclick="selectionMenu(event, 'is-club')">
								<span class="sBtn-text">No</span> <i
									class="fa-solid fa-chevron-down"></i>
							</div>
							<ul class="options">
								<li class="option"><span class="option-text">Yes</span></li>
								<li class="option"><span class="option-text">No</span></li>
							</ul>
						</div> <!-- Drop-down Menu End -->

						<input type="hidden" id="age-group" name="age-group" value="Open" />
						<input type="hidden" id="is-club" name="is-club" value="No" /> <input
							type="submit" id="submitQuery" />
					</form>
				</div> <!-- Left Column End-->

				<div class="right">
					<h1>Edit Team</h1>
					<div class="float-child">
						<div class="dropdown">
							<button onclick="myFunction()" class="dropbtn">Dropdown</button>
							<div id="myDropdown" class="dropdown-content">
								<input type="text" placeholder="Search for team.." id="myInput"
									onkeyup="filterFunction()">
								<c:forEach var="item" items="${b}">
									<a
										href="Team-Management?teamID=<c:out value = "${item.teamID}"/>">
										<span class="option-text">${item.teamName}</span>
									</a>
								</c:forEach>
							</div>

						</div>

						<form action="PostEditTeam" method="post" target="teams">

							<input type="text" id="team-name" name="team-name"
								placeholder="Enter Team Name..."
								value="<c:out value = "${a.teamName}"/>" required /> <input
								type="text" id="location" name="location"
								placeholder="Enter Team's Location"
								value="<c:out value = "${a.location}"/>" required />
								
							<h2>Select Team's Age Group:</h2>
							<div class="select-menu age-group-edit">
								<div class="select-btn"
									onclick="selectionMenu(event, 'age-group-edit')">
									<span class="sBtn-text"><c:out value="${a.ageGroup}" /></span>
									<i class="fa-solid fa-chevron-down"></i>
								</div>
								<ul class="options">
									<li class="option"><span class="option-text">Open</span></li>
									<li class="option"><span class="option-text">U19</span></li>
									<li class="option"><span class="option-text">U17</span></li>
									<li class="option"><span class="option-text">U15</span></li>
									<li class="option"><span class="option-text">U13</span></li>
									<li class="option"><span class="option-text">U11</span></li>
								</ul>
							</div> <!-- Drop-down Menu End -->
							
							<h2>Is the team a club:</h2>
							<div class="select-menu is-club-edit">
								<div class="select-btn"
									onclick="selectionMenu(event, 'is-club-edit')">
									<span class="sBtn-text"><c:out value="${isclub}" /></span> <i
										class="fa-solid fa-chevron-down"></i>
								</div>
								<ul class="options">
									<li class="option"><span class="option-text">Yes</span></li>
									<li class="option"><span class="option-text">No</span></li>
								</ul>
							</div> <!-- Drop-down Menu End -->
							
							<input type="hidden" id="teamID" name="teamID"
								value="<c:out value = "${a.teamID}"/>" /> <input type="hidden"
								id="age-group-edit" name="age-group-edit"
								value="<c:out value = "${a.ageGroup}"/>" /> <input
								type="hidden" id="is-club-edit" name="is-club-edit"
								value="<c:out value = "${isclub}"/>" /> <input type="submit"
								id="submitQuery" />
						</form>
					</div>
					
					<div class="float-child remove-players">
						<h2>Remove Players</h2>
						<div class="dropdown">
							<div id="myDropdownRP" class="dropdown-content show">
								<input type="text" placeholder="Search for team.."
									id="myInputRP" onkeyup="filterFormFunction('RP')">
								<c:forEach var="item" items="${c}">
									<form action="PostDeleteTeamPlayers" id="${item.playerID}" method="post" target="teams">
										<input type="hidden" name="playerID" id="playerID" value="${item.playerID}"> 
										<input type="hidden" name="teamID" id="teamID" value="<c:out value = "${teamid}"/>"> 
										<input type="hidden" name="playerName" id="playerName" value="${item.playerName}">
									</form>
									<a
										onClick="deleteForm('${item.playerID}', '<c:out value = "${teamid}"/>'); return confirm('Do want to add this player to the team (You will have to refresh to see changes)')">
										<span class="option-text">${item.playerName}</span>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>

					<div class="float-child add-players">
						<h2>Add Players</h2>
						<div class="dropdown">
							<div id="myDropdownAP" class="dropdown-content show">
								<input type="text" placeholder="Search for team.."
									id="myInputAP" onkeyup="filterFormFunction('AP')">
								<c:forEach var="item" items="${d}">

									<form action="PostAddTeamPlayers" id="${item.playerID}"
										method="post" target="teams">
										<input type="hidden" name="playerID" id="playerID"
											value="${item.playerID}"> <input type="hidden"
											name="teamID" id="teamID"
											value="<c:out value = "${teamid}"/>"> <input
											type="hidden" name="playerName" id="playerName"
											value="${item.playerName}"> <a
											onClick="addForm('${item.playerID}', '<c:out value = "${teamid}"/>'); return confirm('Do want to add this player to the team (You will have to refresh to see changes)')">
											<span class="option-text">${item.playerName}</span>
										</a>
									</form>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section> <!-- Main-Content End -->
	</div>
</body>
</html>
