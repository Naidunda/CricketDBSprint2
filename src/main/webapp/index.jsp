<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>CricketDB | Dashboard</title>

<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/nav-bar.css" type="text/css" />
<link rel="stylesheet" href="css/dashboard.css" type="text/css" />

<script src="https://kit.fontawesome.com/1374555d03.js" crossorigin="anonymous"></script>
<script src="scripts/dashboard.js"></script>
</head>

<body>
	<div class="container">
		<nav>
			<ul>
				<li><a href="index.jsp" class="logo"> <span
						class="nav-item">CricketDB</span>
				</a></li>
				<li class="selected"><a href="index.jsp" class="nav-list">
						<i class="fas fa-solid fa-table-columns"></i> <span
						class="nav-item">Dashboard</span>
				</a></li>
				<li><a href="players" class="nav-list"> <i
						class="fas fa-solid fa-person-running"></i> <span class="nav-item">Players</span>
				</a></li>
				<li><a href="teams.jsp" class="nav-list"> <i
						class="fas fa-solid fa-people-group"></i> <span class="nav-item">Teams</span>
				</a></li>
				<li><a href="matches.jsp" class="nav-list"> <i
						class="fas fa-solid fa-calendar-days"></i> <span class="nav-item">Matches</span>
				</a></li>
				<li><a href="management.jsp" class="nav-list"> <i
						class="fas fa-solid fa-chart-line"></i> <span class="nav-item">Management</span>
				</a></li>
			</ul>
		</nav>
		<section class="main">
			<div class="left">
				<h1 class="dashboard-heading">Batsman In-Form</h1>
				<table class="tbl-dashboard">
					<tr>
						<th>Player Name</th>
						<th>Runs Scored</th>
						<th>Balls Faced</th>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>100</td>
						<td>(100)</td>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>0</td>
						<td>(0)</td>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>0</td>
						<td>(0)</td>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>0</td>
						<td>(0)</td>
					</tr>
				</table>
				<h1 class="dashboard-heading">Bowlers In-Form</h1>
				<table class="tbl-dashboard">
					<tr>
						<th>Player Name</th>
						<th>Wickets Taken</th>
						<th>Runs Conceded</th>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>0</td>
						<td>0</td>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>0</td>
						<td>0</td>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>0</td>
						<td>0</td>
					</tr>
					<tr>
						<td><a href="player-profile.html">Temp Name</a></td>
						<td>0</td>
						<td>0</td>
					</tr>
				</table>
				<p class="text-btn">View the full list of in-form players.</p>
				<button class="btn-view-more" type="button" onclick="openInForm()"
					id="In-Form-Button">View More</button>
			</div>
			<div class="right">
				<div class="row">
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Live Matches</h1>
							<h2>01/01/23</h2>
							<div class="float-container">
								<div class="float-child">
									<p>
										<span class="team-name">Team Name 1</span><br />
										<span class="age-group">Age Group</span><br />
										<span class="score">100 / 10 (20.0 ov)</span>
									</p>
								</div>
								<div class="float-child">
									<p>
										<span class="team-name">Team Name 2</span><br />
										<span class="age-group">Age Group</span><br />
										<span class="score">100 / 10 (20.0 ov)</span>
									</p>
								</div>
							</div>
						</div>
						<div class="float-child-right">
							<p class="text-btn">View the full list of live matches.</p>
							<button class="btn-view-more" type="button"
								onclick="openMatches()">View More</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Recent Results</h1>
							<h2>01/01/23</h2>
							<div class="float-container">
								<div class="float-child">
									<p>
										<span class="team-name">Team Name 1</span><br />
										<span class="age-group">Age Group</span><br />
										<span class="score">100 / 10 (20.0 ov)</span>
									</p>
								</div>
								<div class="float-child">
									<p>
										<span class="team-name">Team Name 2</span><br />
										<span class="age-group">Age Group</span><br />
										<span class="score">100 / 10 (20.0 ov)</span>
									</p>
								</div>
							</div>
							<p class="result">Team Name 1 won by 2 wickets.</p>
						</div>
						<div class="float-child-right">
							<p class="text-btn">View the full list of recent results.</p>
							<button class="btn-view-more" type="button"
								onclick="openMatches()">View More</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="float-container">
						<div class="float-child-left">
							<h1 class="dashboard-heading">Upcoming Fixturess</h1>
							<h2>01/01/23</h2>
							<div class="float-container">
								<div class="float-child">
									<p>
										<span class="team-name">Team Name 2</span><br />
										<span class="age-group">Age Group</span><br />
										<span style="color: white">.</span>
									</p>
								</div>
								<div class="float-child">
									<p>
										<span class="team-name">Team Name 1</span><br />
										<span class="age-group">Age Group</span><br />
										<span style="color: white">.</span>
									</p>
								</div>
							</div>
						</div>
						<div class="float-child-right">
							<p class="text-btn">View the full list of upcoming fixtures</p>
							<button class="btn-view-more" type="button"
								onclick="openMatches()">View More</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

</html>