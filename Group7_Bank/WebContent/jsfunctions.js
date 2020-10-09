/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById('custdropdown').classList.toggle('show');
}
function myFunction1() {
  document.getElementById('mybank').classList.toggle('show1');
}

// Close the dropdown if the user clicks outside of it
window.onclick = function (e) {
  if (!e.target.matches('.custbtn')) {
    var custdropdown = document.getElementById('custdropdown');
    if (custdropdown.classList.contains('show')) {
      custdropdown.classList.remove('show');
    }
  }
  if (!e.target.matches('.bankbtn')) {
    var myDropdown = document.getElementById('mybank');
    if (myDropdown.classList.contains('show1')) {
      myDropdown.classList.remove('show1');
    }
  }
};

// state and city
var CityandState = {};
CityandState['']=[];
CityandState['New York'] = ['Rochester', 'Albany ','Yonkers'];
CityandState['New Jersey'] = ['Edison', 'ParsiPanny','Jersey City'];
CityandState['Texas'] = ['Dallas', 'Austin','Houston'];

function selectStateandCity() {
  var StateList = document.getElementById("State");
  var CityList = document.getElementById("City");
  var selstate = StateList.options[StateList.selectedIndex].value;
  while (CityList.options.length) {
    CityList.remove(0);
  }
  var a = CityandState[selstate];
  if (a) {
    var i;
    for (i = 0; i < a.length; i++) {
      var ab = new Option(a[i], a[i]);
      CityList.options.add(ab);
    }
  }
} 

function mytest(){
	if(confirm("You Sure to Delete?")){
		//do nothing;
	}
	else{
		location.replace("Home.html")
	}
}
