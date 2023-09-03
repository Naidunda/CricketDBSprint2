<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${requestScope.player}" var="a"></c:set>
<c:set value="${requestScope.players}" var="b"></c:set>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>CricketDB | Player Management</title>

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/nav-bar.css" />
<link rel="stylesheet" href="css/player-management.css" />

<script src="https://kit.fontawesome.com/1374555d03.js"
	crossorigin="anonymous"></script>
<script src="scripts/player-management.js"></script>

</head>
<body>
	<div class="container">
		<nav>
			<!-- Navigation Bar -->
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
				<li class = "selected"><a href="Player-Management?playerID=" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Player Management</span>
				</a></li>
				<li><a href="Team-Management?teamID=" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Team Management</span>
				</a></li>
			</ul>
		</nav>
		<!-- Navigation Bar End -->

		<section class="main">
			<!-- Main-Content -->

			<div class="players">
				<div class="left">
					<iframe name="players" style="display: none;"></iframe>

					<h1>Create A Player</h1>

					<form action="PostCreatePlayer" method="post" target="players">

						<input type="text" id="player-name" name="player-name"
							placeholder="Enter Name..." required /> <input type="date"
							name="dob" required />

						<h2>Select Batting Hand:</h2>
						<div class="select-menu batting-hand">
							<div class="select-btn"
								onclick="selectionMenu(event, 'batting-hand')">
								<span class="sBtn-text">Right-Hand</span> <i
									class="fa-solid fa-chevron-down"></i>
							</div>
							<ul class="options">
								<li class="option"><span class="option-text">Right-Hand</span></li>
								<li class="option"><span class="option-text">Left-Hand</span></li>
							</ul>
						</div>

						<h2>Select Bowling Arm:</h2>
						<div class="select-menu bowling-arm">
							<div class="select-btn"
								onclick="selectionMenu(event, 'bowling-arm')">
								<span class="sBtn-text">Right Arm</span> <i
									class="fa-solid fa-chevron-down"></i>
							</div>
							<ul class="options">
								<li class="option"><span class="option-text">Right
										Arm</span></li>
								<li class="option"><span class="option-text">Left
										Arm</span></li>
							</ul>
						</div>

						<h2>Select Bowling Skill:</h2>
						<div class="select-menu bowling-skill">
							<div class="select-btn"
								onclick="selectionMenu(event, 'bowling-skill')">
								<span class="sBtn-text">Fast</span> <i
									class="fa-solid fa-chevron-down"></i>
							</div>

							<ul class="options">
								<li class="option"><span class="option-text">Fast</span></li>
								<li class="option"><span class="option-text">Fast Medium</span></li>
								<li class="option"><span class="option-text">Medium</span></li>
								<li class="option"><span class="option-text">Offbreak</span></li>
								<li class="option"><span class="option-text">Legbreak</span></li>
								<li class="option"><span class="option-text">NA</span></li>
							</ul>
						</div>

						<h2>Is the player a Keeper:</h2>
						<div class="select-menu is-keeper">
							<div class="select-btn"
								onclick="selectionMenu(event, 'is-keeper')">
								<span class="sBtn-text">No</span> <i
									class="fa-solid fa-chevron-down"></i>
							</div>
							<ul class="options">
								<li class="option"><span class="option-text">Yes</span></li>
								<li class="option"><span class="option-text">No</span></li>
							</ul>
						</div>

						<input type="hidden" id="batting-hand" name="batting-hand" value="Right-Hand" /> 
						<input type="hidden" id="bowling-arm" name="bowling-arm" value="Right Arm" /> 
						<input type="hidden" id="bowling-skill" name="bowling-skill" value="Fast" /> 
						<input type="hidden" id="is-keeper" name="is-keeper" value="No" /> 
						<input type="submit" id="submitQuery" onclick="return confirm('Do you want to add this player?')"/>
					</form>
				</div>

				<div class="right">
					<h1>Edit Player</h1>
					<div class="float-child">
						<div class="dropdown">
							<div id="myDropdown" class="dropdown-content">
								<input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()">
								<c:forEach var="item" items="${b}">
										<a href = "Player-Management?playerID=<c:out value = "${item.playerID}"/>">
										<span class="option-text">${item.playerName}</span>
										</a>
								</c:forEach>
							</div>
						</div>
					</div>
					<div class="float-child">
						<iframe name="players" style="display: none;"></iframe>

						<form action="PostEditPlayer" method="post" target="players">

							<input type="text" id="player-name" name="player-name"
								placeholder="Enter Name..." value = "<c:out value = "${a.playerName}"/>" required /> 
							<input type="date"
								name="dob" value = "<c:out value = "${a.dob}"/>" required />

							<h2>Select Batting Hand:</h2>
							<div class="select-menu batting-hand-edit">
								<div class="select-btn"
									onclick="selectionMenu(event, 'batting-hand-edit')">
									<span class="sBtn-text"><c:out value = "${a.battingHand}"/></span> <i
										class="fa-solid fa-chevron-down"></i>
								</div>
								<ul class="options">
									<li class="option"><span class="option-text">Right-Hand</span></li>
									<li class="option"><span class="option-text">Left-Hand</span></li>
								</ul>
							</div>

							<h2>Select Bowling Arm:</h2>
							<div class="select-menu bowling-arm-edit">
								<div class="select-btn"
									onclick="selectionMenu(event, 'bowling-arm-edit')">
									<span class="sBtn-text"><c:out value = "${bowlingarm}"/></span> <i
										class="fa-solid fa-chevron-down"></i>
								</div>
								<ul class="options">
									<li class="option"><span class="option-text">Right
											Arm</span></li>
									<li class="option"><span class="option-text">Left
											Arm</span></li>
									<li class="option"><span class="option-text">NA</span></li>
								</ul>
							</div>

							<h2>Select Bowling Skill:</h2>
							<div class="select-menu bowling-skill-edit">
								<div class="select-btn"
									onclick="selectionMenu(event, 'bowling-skill-edit')">
									<span class="sBtn-text"><c:out value = "${bowlingskill}"/></span> <i
										class="fa-solid fa-chevron-down"></i>
								</div>

								<ul class="options">
									<li class="option"><span class="option-text">Fast</span></li>
									<li class="option"><span class="option-text">Fast Medium</span></li>
									<li class="option"><span class="option-text">Medium</span></li>
									<li class="option"><span class="option-text">Offbreak</span></li>
									<li class="option"><span class="option-text">Legbreak</span></li>
									<li class="option"><span class="option-text">NA</span></li>
								</ul>
							</div>

							<h2>Is the player a Keeper:</h2>
							<div class="select-menu is-keeper-edit">
								<div class="select-btn"
									onclick="selectionMenu(event, 'is-keeper-edit')">
									<span class="sBtn-text"><c:out value = "${iskeeper}"/></span> <i
										class="fa-solid fa-chevron-down"></i>
								</div>
								<ul class="options">
									<li class="option"><span class="option-text">Yes</span></li>
									<li class="option"><span class="option-text">No</span></li>
								</ul>
							</div>
	
							<input type="hidden" id = "playerID" name="playerID" value="<c:out value = "${a.playerID}"/>"/> 
							<input type="hidden" id = "batting-hand-edit" name="batting-hand-edit" value="<c:out value = "${a.battingHand}"/>"/> 
							<input type="hidden" id = "bowling-arm-edit" name="bowling-arm-edit" value="<c:out value = "${bowlingarm}"/>"/> 
							<input type="hidden" id="bowling-skill-edit" name="bowling-skill-edit" value="Fast" /> 
							<input type="hidden" id = "is-keeper-edit" name="is-keeper-edit" value="${iskeeper}" />
							<input type="submit" id="submitQuery" onclick="return confirm('Do you want to edit this player?')"/>
						</form>
					</div>
				</div>

			</div>
		</section>
	</div>
</body>
</html>