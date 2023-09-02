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
  	// Changes Sort By Order Button to show z->a icon.
    document.getElementById("directionToggle").classList.add('fa-arrow-down-z-a');
    document.getElementById("directionToggle").classList.remove('fa-arrow-down-a-z');
    
    // Changes <input> with the id "direction" to have a value of the icon.
    document.getElementById("direction").setAttribute('value', 'fa-arrow-down-z-a');
  } else {
  	// Changes Sort By Order Button to show a->z icon.
    document.getElementById("directionToggle").classList.add('fa-arrow-down-a-z');
    document.getElementById("directionToggle").classList.remove('fa-arrow-down-z-a');
    
    // Changes <input> with the id "direction" to have a value of the icon.
    document.getElementById("direction").setAttribute('value', 'fa-arrow-down-a-z');
  }
}

function selectionSortByMenu(evt) {
 	const optionMenu = document.querySelector(".select-menu"),
		selectBtn = optionMenu.querySelector(".select-btn"),
    	options = optionMenu.querySelectorAll(".option"),
   		sBtn_text = optionMenu.querySelector(".sBtn-text");
	
	//Adds the class "active" to unhide the drop-down elements
  	optionMenu.classList.toggle("active");
	
	//Listens for a click for every option in the drop menu.
	options.forEach((option) => {
    	option.addEventListener("click", () => {
      		let selectedOption = option.querySelector(".option-text").innerText;
      		
      		//Changes the drop-menu text to show the clicked on option
      		sBtn_text.innerText = selectedOption;
      		
      		//Removes the class "active" to hide the drop-down elements
     		 optionMenu.classList.remove("active");
     		 
     		 // Changes <input> with the id "sortby" to have a value of the clicked on option
     		 document.getElementById("sortby").setAttribute('value', sBtn_text.innerText);
    	});
  	});
}

function selectionMenu(evt) {
 	const optionMenu = document.querySelector(".select-menu"),
    	selectBtn = optionMenu.querySelector(".select-btn"),
   		options = optionMenu.querySelectorAll(".option"),
    	sBtn_text = optionMenu.querySelector(".sBtn-text");
	
	//Adds the class "active" to unhide the drop-down elements
  	optionMenu.classList.toggle("active");
	
	//Listens for a click for every option in the drop menu.
  	options.forEach((option) => {
    	option.addEventListener("click", () => {
      		let selectedOption = option.querySelector(".option-text").innerText;
      		
      		//Changes the drop-menu text to show the clicked on option
      		sBtn_text.innerText = selectedOption;
      		
      		//Removes the class "active" to hide the drop-down elements
      		optionMenu.classList.remove("active");
    	});
  	});
}

function selectionTabMenu(evt) {
    const optionMenu = document.querySelector(".select-menu"),
      	selectBtn = optionMenu.querySelector(".select-btn"),
      	options = optionMenu.querySelectorAll(".option"),
      	sBtn_text = optionMenu.querySelector(".sBtn-text");
  	
  	//Adds the class "active" to unhide the drop-down elements
    optionMenu.classList.toggle("active");

  	//Listens for a click for every option in the drop menu.
    options.forEach((option) => {
      	option.addEventListener("click", () => {
		
		// Get all elements with class="tab-content-players" and hide them
	    tabcontent = document.getElementsByClassName("statistics-content");
	    for (i = 0; i < tabcontent.length; i++) {
	        tabcontent[i].style.display = "none";
	    }
	
	    let selectedOption = option.querySelector(".option-text").innerText;
	    
	    //Changes the drop-menu text to show the clicked on option
	    sBtn_text.innerText = selectedOption;
	    
	    // Show the current tab, and add an "active" class to the button that opened the tab
	    document.getElementById(selectedOption).style.display = "block";
	    
	    //Removes the class "active" to hide the drop-down elements
	    optionMenu.classList.remove("active");
      	});
    });
}