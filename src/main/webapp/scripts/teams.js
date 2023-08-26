function openTab(evt, tabName) {
    // Declare all variables
    var i, tabcontent, tablinks;
  
    // Get all elements with class="tab-content-players" and hide them
    tabcontent = document.getElementsByClassName("tab-content");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tab-links-player" and remove the class "active"
    tablinks = document.getElementsByClassName("tab-links");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
} 

function sortBy(){

  if  ( document.getElementById("SortBy").classList.contains('fa-arrow-down-a-z') ){
    document.getElementById("SortBy").classList.add('fa-arrow-down-z-a');
    document.getElementById("SortBy").classList.remove('fa-arrow-down-a-z');
  } else {
    document.getElementById("SortBy").classList.add('fa-arrow-down-a-z');
    document.getElementById("SortBy").classList.remove('fa-arrow-down-z-a');
  }
}