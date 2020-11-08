var getHTTPObject = function() {
	var xhr = false;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			xhr = new ActiveXObject("Msxml12.XMLHTTP");
		} catch (e) {
			try {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				xhr = false;
			}
		}
	}
	return xhr;
}

var searchUsers = function(url) {
	var request = getHTTPObject();
	if (request) {
		request.onreadystatechange = function() {
			parseResponse(request);
		}
		request.open("GET", url, true);
		request.setRequestHeader("Accept", "application/json");
		request.send(null);
	}
}

var parseResponse = function(request) {
	if (request.readyState == 4)
		if (request.status == 200 || request.status == 304) {
			var data = JSON.parse(request.responseText);
			var arraySize = Object.keys(data.users).length;
			var table = document.getElementById("usertable");
			for (j = 0; j < arraySize; j++) {
				var tr = document.createElement("tr");
				tr.innerHTML = '<td>'
						+ data.users[j].username + '</td>' + '<td>'
						+ data.users[j].firstnames + '</td>' + '<td>'
						+ data.users[j].surname + '</td>' + '<td>'
						+ data.users[j].canadd + '</td>' + '<td>'
						+ data.users[j].canedit + '</td>' + '<td>'
						+ data.users[j].isadmin + '</td>'
						+ '<td><form method="post" action="ViewUserServlet" id="ViewUserServlet">'
						+ '<input hidden type="text" value="'+data.users[j].username+'" id="userusername'+[j]+'" name="username"></input>'
						+ '<input hidden type="text" value="'+data.users[j].firstnames+'" id="userfirstnames'+[j]+'" name="firstnames"></input>'
						+ '<input hidden type="text" value="'+data.users[j].surname+'" id="usersurname'+[j]+'" name="surname"></input>'
						+ '<input hidden type="text" value="'+data.users[j].canadd+'" id="usercanadd'+[j]+'" name="canadd"></input>'
						+ '<input hidden type="text" value="'+data.users[j].canedit+'" id="usercanedit'+[j]+'" name="canedit"></input>'
						+ '<input hidden type="text" value="'+data.users[j].isadmin+'" id="userisadmin'+[j]+'" name="isadmin"></input>'
						+ '<button type="submit" class="btn btn-primary">Edit</button>'
						+ '</form></td>';
				table.appendChild(tr);
			}
		}
}

window.onload = function() {
	var url = "http://localhost:8001/asikb/rest/users";
	searchUsers(url);
}