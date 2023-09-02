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
					href="Teams?sortBy=Date&direction=fa-arrow-down-a-z&search="
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
		</nav><!-- Navigation Bar End -->
		
		<section class="main">  <!-- Main-Content -->
			<h1>Match Summary</h1>  <!-- Match Summary -->
			<div class="scorecard-content float-container">
				<div class="float-child left-align">
					<p>
						<a href="Team-Profile?teamID=<c:out value="${a.teamName1}"/>"><c:out
								value="${a.teamName1}" /> (<c:out
								value="${a.teamAgeGroup1}" />)</a>
					</p>
				</div>
				<div class="float-child right-align">
					<p>
						<c:out value="${a.inningsWickets1}" />
						/
						<c:out value="${a.inningsTotal1}" />
						(
						<c:out value="${a.inningsOvers1}" />
						ov)
					</p>
				</div>
			</div> 

			<div class="scorecard-content float-container">
				<div class="float-child left-align">
					<p>
						<a href="Team-Profile?teamID=<c:out value="${a.teamID2}"/>"><c:out
								value="${a.teamName2}" />(<c:out
								value="${a.teamAgeGroup2}" />)</a>
					</p>
				</div>
				<div class="float-child right-align">
					<p>
						<c:out value="${a.inningsWickets2}" />
						/
						<c:out value="${a.inningsTotal2}" />
						(
						<c:out value="${a.inningsOvers2}" />
						ov)
					</p>
				</div>
			</div> <!-- Match Summary End -->

			<div class="tabs"> <!-- Tab Links -->
				<button class="tab-links active" onclick="openTab(event, 'First-Innings')">1st Innings</button>
				<button class="tab-links" onclick="openTab(event, 'Second-Innings')">2nd Innings</button>
			</div> <!-- Tab Links End -->

			<div id="First-Innings" class="tab-content" style="display: block"> <!-- Tab-Content (1) -->
				<h1>
					<c:out value="${a.teamName1}" />
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
						<c:forEach var="item" items="${b}"> <!-- Creates table row for each batsman who batted ("battinginnings1") -->
							<tr>
								<td><a
									href="Player-Profile?playerID=${item.batsmanID}&season=All-Time">${item.batsmanName}</a></td>
								<td>${item.dismissalMessage}</td>
								<td>${item.runsScored}</td>
								<td>${item.ballsFaced}</td>
								<td>${item.fours}</td>
								<td>${item.sixes}</td>
								<td>${item.strikeRate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>
					Did not bat:
					<c:forEach var="item" items="${c}"> <!-- Lists the batsman which did not bat ("bowlinginnings1") -->
						<a
							href="Player-Profile?playerID=${item.batsmanID}&season=All-Time">${item.batsmanName}</a>, 
						</c:forEach>
				</p>

				<h1>
					<c:out value="${a.teamName2}" />
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
					<c:forEach var="item" items="${d}"> <!-- Creates table row for each bowler ("battinginnings1") -->
						<tr>
							<td><a
								href="Player-Profile?playerID=${item.bowlerID}&season=All-Time">${item.bowlerName}</a></td>
							<td>${item.overs}</td>
							<td>${item.maidens}</td>
							<td>${item.runsConceded}</td>
							<td>${item.wicketsTaken}</td>
							<td>${item.economy}</td>
							<td>${item.average}</td>
							<td>${item.wide}</td>
							<td>${item.noBalls}</td>

						</tr>
					</c:forEach>
				</table>
			</div> <!-- Tab-Content (1) End -->
			
			<div id="Second-Innings" class="tab-content"> <!-- Tab-Content (2) -->
				<h1>
					<c:out value="${a.teamName2}" />
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
						<c:forEach var="item" items="${e}"> <!-- Creates table row for each batsman who batted ("battinginnings2") -->
							<tr>
								<td><a
									href="Player-Profile?playerID=${item.batsmanID}&season=All-Time">${item.batsmanName}</a></td>
								<td>${item.dismissalMessage}</td>
								<td>${item.runsScored}</td>
								<td>${item.ballsFaced}</td>
								<td>${item.fours}</td>
								<td>${item.sixes}</td>
								<td>${item.strikeRate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p>
					Did not bat:
					<c:forEach var="item" items="${f}"> <!-- Lists the batsman which did not bat ("bowlinginnings2") -->
						<a
							href="Player-Profile?playerID=${item.batsmanID}&season=All-Time">${item.batsmanName}</a>, 
						</c:forEach>
				</p>
				<h1>
					<c:out value="${a.teamName1}" />
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
					<c:forEach var="item" items="${g}"> <!-- Creates table row for each bowler ("battinginnings2") -->
						<tr>
							<td><a
								href="Player-Profile?playerID=${item.bowlerID}&season=All-Time">${item.bowlerName}</a></td>
							<td>${item.overs}</td>
							<td>${item.maidens}</td>
							<td>${item.runsConceded}</td>
							<td>${item.wicketsTaken}</td>
							<td>${item.economy}</td>
							<td>${item.average}</td>
							<td>${item.wide}</td>
							<td>${item.noBalls}</td>
						</tr>
					</c:forEach>
				</table>
			</div> <!-- Tab-Content (2) End -->
		</section> <!-- Main-Content End -->
	</div>
</body>

</html>