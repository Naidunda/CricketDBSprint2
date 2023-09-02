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

function filterFormFunction(str) {
  var input, filter, ul, li, a, i;
  input = document.getElementById("myInput" + str);
  filter = input.value.toUpperCase();
  div = document.getElementById("myDropdown" +str);
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

function deleteForm(playerid, teamid) {
                document.getElementById(playerid).submit();
    
 }
 
 function addForm(playerid, teamid) {
                document.getElementById(playerid).submit();
 }