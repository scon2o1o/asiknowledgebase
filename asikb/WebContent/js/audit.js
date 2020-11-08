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

var populateAuditLog = function(url) {
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
			var arraySize = Object.keys(data.audit).length;
			var table = document.getElementById("auditlogtable");
			for (j = 0; j < arraySize; j++) {
				var tr = document.createElement("tr");
				tr.innerHTML = '<td>'
						+ data.audit[j].datetime
						+ '</td>'
						+ '<td>'
						+ data.audit[j].action
						+ '</td>'
						+ '<td>'
						+ data.audit[j].user
						+ '</td>';
				table.appendChild(tr);
			}
		}
}


window.onload = function() {
	var url = "http://localhost:8001/asikb/rest/audit";
	populateAuditLog(url);
}