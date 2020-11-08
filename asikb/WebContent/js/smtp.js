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

var populateSMTP = function(url) {
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
			document.getElementById("server").value = data.smtp.server;
			document.getElementById("port").value = data.smtp.port;
			var auth = document.getElementById("auth");
			var authoption = document.createElement("option");
			authoption.text = data.smtp.auth;
			auth.add(authoption);
			if (authoption.text === 'True'){
				var authoption = document.createElement("option");
				authoption.text = 'False';
				auth.add(authoption);
			} else {
				var authoption = document.createElement("option");
				authoption.text = 'True';
				auth.add(authoption);
			}
			var starttls = document.getElementById("starttls");
			var starttlsoption = document.createElement("option");
			starttlsoption.text = data.smtp.starttls;
			starttls.add(starttlsoption);
			if (starttlsoption.text === 'True'){
				var starttlsoption = document.createElement("option");
				starttlsoption.text = 'False';
				starttls.add(starttlsoption);
			} else {
				var starttlsoption = document.createElement("option");
				starttlsoption.text = 'True';
				starttls.add(starttlsoption);
			}
			document.getElementById("fromaddress").value = data.smtp.fromaddress;
			document.getElementById("username").value = data.smtp.username;
			document.getElementById("password").value = data.smtp.password;
		}
}

window.onload = function() {
	var url = "http://localhost:8001/asikb/rest/smtp";
	populateSMTP(url);
}