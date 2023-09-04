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

function selectionMenu(evt,input) {
 	const optionMenu = document.querySelector("." +input),
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
     		 
     		 document.getElementById(input).setAttribute('value', sBtn_text.innerText);
    	});
  	});
}

function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

function filterFunction() {
  var input, filter, ul, li, a, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  div = document.getElementById("myDropdown");
  a = div.getElementsByTagName("a");
  
  for (i = 0; i < a.length; i++) {
    txtValue = a[i].textContent || a[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      a[i].style.display = "";
    } else {
      a[i].style.display = "none";
    }
  }
}