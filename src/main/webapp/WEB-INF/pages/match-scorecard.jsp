<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <title>CricketDB | Player Profile</title>

  <link rel="stylesheet" href="css/style.css" />
  <link rel="stylesheet" href="css/nav-bar.css" />
  <link rel="stylesheet" href="css/match-scorecard.css" />

  <script src="https://kit.fontawesome.com/1374555d03.js" crossorigin="anonymous"></script>
  <script src="scripts/match-scorecard.js"></script>
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
          <a href="Players?sortBy=Player+Name&direction=asc&search=" class="nav-list">
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
        <li class="selected">
          <a href="Matches" class="nav-list">
            <i class="fas fa-solid fa-calendar-days"></i>
            <span class="nav-item">Matches</span>
          </a>
        </li>
        <li>
          <a href="management" class="nav-list">
            <i class="fas fa-solid fa-chart-line"></i>
            <span class="nav-item">Management</span>
          </a>
        </li>
      </ul>
    </nav>
    <section class="main">

      <div class="tabs">
        <button class="tab-links active" onclick="openTab(event, 'Summary')">Summary</button>
        <button class="tab-links" onclick="openTab(event, 'First-Innings')">1st Innings</button>
        <button class="tab-links" onclick="openTab(event, 'Second-Innings')">2nd Innings</button>
      </div>

      <div id="Summary" class="tab-content" style="display: block">
        <h1>Live Scorecard</h1>
        <h2>1st Innings</h2>

        <div class = "scorecard-content float-container">
          <div class = "float-child left-align">
            <p><a href="team-profile.html">Generic Team Name 1</a></p>
          </div>
          <div class = "float-child right-align">
            <p>8 / 324 (49.4 ov)</p>
          </div>
        </div>

        <div class = "scorecard-content float-container">
          <div class = "float-child left-align">
            <p><a href="team-profile.html">Generic Team Name 2</a></p>
          </div>
          <div class = "float-child right-align">
            <p>3 / 288 (35.3 ov)</p>
          </div>
        </div>

        <div>
          <div class = "float-child left-align">
            <h2>Batting</h2>
          </div>
          <div class = "float-child right-align">
            <table>
              <tr>
                <th>R</th>
                <th>B</th>
                <th>4s</th>
                <th>6s</th>
                <th>S/R</th>
              </tr>
            </table>
          </div>
        </div>

        <div class = "scorecard-content float-container">
          <div class = "float-child left-align">
            <p><a href="player-profile.html">Batsman Name 1</a></p>
          </div>
          <div class = "float-child right-align">
            <table>
              <tr>
                <td>64</td>
                <td>72</td>
                <td>4</td>
                <td>1</td>
                <td>87.67</td>
              </tr>
            </table>
          </div>
        </div>
        <div class = "scorecard-content float-container">
          <div class = "float-child left-align">
            <p><a href="player-profile.html">Batsman Name 2</a></p>
          </div>
          <div class = "float-child right-align">
            <table>
              <tr>
                <td>6</td>
                <td>6</td>
                <td>0</td>
                <td>0</td>
                <td>100</td>
              </tr>
            </table>
          </div>
        </div>

        <div class = "float-container">
          <div class = "float-child left-align">
            <h2>Bowling</h2>
          </div>
          <div class = "float-child right-align">
            <table>
              <tr>
                <th>O</th>
                <th>M</th>
                <th>R</th>
                <th>W</th>
                <th>Eco</th>
              </tr>
            </table>
          </div>
        </div>

        <div class = "scorecard-content float-container">
          <div class = "float-child left-align">
            <p><a href="player-profile.html">Bowler Name</a></p>
          </div>
          <div class = "float-child right-align">
            <table>
              <tr>
                <td>4.4</td>
                <td>0</td>
                <td>23</td>
                <td>1</td>
                <td>5.23</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
      <div id="First-Innings" class="tab-content">
        <h1>Team Name</h1>
        <h2>50 ovs maximum</h2>
        <table class = "scorecard">
          <tr>
            <th>Batsman Name</th>
            <th></th>
            <th>R</th>
            <th>B</th>
            <th>4's</th>
            <th>6's</th>
            <th>SR</th>
          </tr>
          <tr>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
        </table>
        <h1>Team Name</h1>
        <table class = "scorecard">
          <tr>
            <th>Bowler Name</th>
            <th>Ov</th>
            <th>M</th>
            <th>R</th>
            <th>W</th>
            <th>Eco</th>
            <th>Wi</th>
            <th>NB</th>
          </tr>
        </table>
      </div>
      <div id="Second-Innings" class="tab-content">
        <h1>Team Name</h1>
        <h2>50 ovs maximum</h2>
        <table class = "scorecard">
          <tr>
            <th>Batsman Name</th>
            <th></th>
            <th>R</th>
            <th>B</th>
            <th>4's</th>
            <th>6's</th>
            <th>SR</th>
          </tr>
          <tr>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
        </table>
        <h1>Team Name</h1>
        <table class = "scorecard">
          <tr>
            <th>Bowler Name</th>
            <th>Ov</th>
            <th>M</th>
            <th>R</th>
            <th>W</th>
            <th>Eco</th>
            <th>Wi</th>
            <th>NB</th>
          </tr>
          <tr>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
        </table>
    </section>
  </div>
</body>

</html>