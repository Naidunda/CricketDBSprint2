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

  if  ( document.getElementById("directionToggle").classList.contains('fa-arrow-down-a-z') ){
    document.getElementById("directionToggle").classList.add('fa-arrow-down-z-a');
    document.getElementById("directionToggle").classList.remove('fa-arrow-down-a-z');
    
    document.getElementById("direction").setAttribute('value', 'fa-arrow-down-z-a');
    
  } else {
    document.getElementById("directionToggle").classList.add('fa-arrow-down-a-z');
    document.getElementById("directionToggle").classList.remove('fa-arrow-down-z-a');
    
    document.getElementById("direction").setAttribute('value', 'fa-arrow-down-a-z');

  }
}

function selectionMenu(evt) {
    const optionMenu = document.querySelector(".select-menu"),
      selectBtn = optionMenu.querySelector(".select-btn"),
      options = optionMenu.querySelectorAll(".option"),
      sBtn_text = optionMenu.querySelector(".sBtn-text");
  
    optionMenu.classList.toggle("active");

  
    options.forEach((option) => {
      option.addEventListener("click", () => {
        let selectedOption = option.querySelector(".option-text").innerText;
        sBtn_text.innerText = selectedOption;
        optionMenu.classList.remove("active");
        document.getElementById("sortby").setAttribute('value', sBtn_text.innerText);
      });
    });
  }
  
