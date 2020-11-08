function populateSearchbox(name){
	document.getElementById("searchtext2").value=name;
	var input, filter, table, tr, td, i, txtValue;
	  document.getElementById("searchtext").value="";
	  input = document.getElementById("searchtext2");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("docstable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[5];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
}

function searchFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("searchtext");
  filter = input.value.toUpperCase();
  table = document.getElementById("docstable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
