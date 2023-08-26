<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>CricketDB | Matches</title>
    
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/nav-bar.css" />
    <link rel="stylesheet" href="css/matches.css" />
    
    <script src = "https://kit.fontawesome.com/1374555d03.js" crossorigin="anonymous" ></script>
    <script src="scripts/matches.js"></script>
  </head>
  <body>
    <div class="container">
      <nav>
        <ul>
          <li>
            <a href="Dashboard" class="logo">
              <span class="nav-item">CricketDB</span>
            </a>
          </li>
          <li>
            <a href="Dashboard" class="nav-list">
              <i class="fas fa-solid fa-table-columns"></i>
              <span class="nav-item">Dashboard</span>
            </a>
          </li>
          <li>
            <a href="Players" class="nav-list">
              <i class="fas fa-solid fa-person-running"></i>
              <span class="nav-item">Players</span>
            </a>
          </li>
          <li>
            <a href="Teams" class="nav-list">
              <i class="fas fa-solid fa-people-group"></i>
              <span class="nav-item">Teams</span>
            </a>
          </li>
          <li class = "selected">
            <a href="Matches" class="nav-list">
              <i class="fas fa-solid fa-calendar-days"></i>
              <span class="nav-item">Matches</span>
            </a>
          </li>
          <li>
            <a href="Management" class="nav-list">
              <i class="fas fa-solid fa-chart-line"></i>
              <span class="nav-item">Management</span>
            </a>
          </li>
        </ul>
      </nav>

      <section class="main">
        <!--Tab Links-->
        <div class="tabs">
          <button class="tab-links active" onclick="openTab(event, 'Live')">Live</button>
          <button class="tab-links" onclick="openTab(event, 'Fixtures')">Fixtures</button>
          <button class="tab-links" onclick="openTab(event, 'Results')">Results</button>
        </div>
        <div class="filters">
          <button type="button"><i class="fa-solid fa-sort"></i>Sort By</button>
          <button type="button" class="order" onClick = "sortBy()"><i id = "SortBy" class="fa-solid fa-arrow-down-a-z"></i></button>
          <button type="button"><i class="fa-solid fa-filter"></i>Filter</button>
          <input type="text" placeholder="Search..">
        </div>
        <!--Tab Content-->
        <div id="Live" class="tab-content" style="display: block">
          <div class="tbl-matches">
            <div class="float-container">
              <div class="float-child-left">
                <h2>01/01/23</h2>
                <div class="float-container">
                  <div class="float-child">
                    <p>
                      <span class="team-name">Team Name 1</span><br /><span class="age-group">Age Group</span><br /><span
                        class="score">100 / 10 (20.0 ov)</span>
                    </p>
                  </div>
                  <div class="float-child">
                    <p>
                      <span class="team-name">Team Name 2</span><br /><span class="age-group">Age Group</span><br /><span
                        class="score">100 / 10 (20.0 ov)</span>
                    </p>
                  </div>
                </div>
              </div>
              <div class="float-child-right">
                <button class="btn-view-match" type="button" onClick = "window.location.href='Match-Scorecard?'">View Match</button>
              </div>
            </div>
          </div>
        </div>
        <div id="Fixtures" class="tab-content">
          <div class="tbl-matches">
            <div class="float-container">
              <div class="float-child-left">
                <h2>01/01/23</h2>
                <div class="float-container">
                  <div class="float-child">
                    <p>
                      <span class="team-name">Team Name 1</span><br /><span class="age-group">Age Group</span><br/>
                    </p>
                  </div>
                  <div class="float-child">
                    <p>
                      <span class="team-name">Team Name 2</span><br /><span class="age-group">Age Group</span><br/>
                    </p>
                  </div>
                </div>
              </div>
              <div class="float-child-right">
                <button class="btn-view-match" type="button" onClick = "window.location.href='Match-Scorecard?'">View Match</button>
              </div>
            </div>
          </div>
        </div>
        <div id="Results" class="tab-content">
          <div class="tbl-matches">
            <div class="float-container">
              <div class="float-child-left">
                <h2>01/01/23</h2>
                <div class="float-container">
                  <div class="float-child">
                    <p>
                      <span class="team-name">Team Name 1</span><br /><span class="age-group">Age Group</span><br /><span
                        class="score">100 / 10 (20.0 ov)</span>
                    </p>
                  </div>
                  <div class="float-child">
                    <p>
                      <span class="team-name">Team Name 2</span><br /><span class="age-group">Age Group</span><br /><span
                        class="score">100 / 10 (20.0 ov)</span>
                    </p>
                  </div>
                </div>
                <p class="result">Team Name 1 won by 2 wickets.</p>
              </div>
              <div class="float-child-right">
                <button class="btn-view-match" type="button" onClick = "window.location.href='Match-Scorecard?'">View Match</button>
              </div>
            </div>
          </div>
        </div>

      </section>
    </div>
  </body>
</html>
