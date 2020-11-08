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

var searchCategories = function(url) {
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

var searchSubcategories = function(url2) {
	var request = getHTTPObject();
	if (request) {
		request.onreadystatechange = function() {
			parseResponse2(request);
		}
		request.open("GET", url2, true);
		request.setRequestHeader("Accept", "application/json");
		request.send(null);
	}
}

var parseResponse = function(request) {
	if (request.readyState == 4)
		if (request.status == 200 || request.status == 304) {
			var data = JSON.parse(request.responseText);
			var arraySize = Object.keys(data.categories).length;
			var select = document.getElementById("category"); 
			for(var j = 0; j < arraySize; j++) {
			    var opt = data.categories[j].name;
			    var el = document.createElement("option");
			    el.textContent = opt;
			    el.value = opt;
			    select.appendChild(el);
			}
		}
}

var parseResponse2 = function(request) {
	if (request.readyState == 4)
		if (request.status == 200 || request.status == 304) {
			var data = JSON.parse(request.responseText);
			var arraySize = Object.keys(data.subcategories).length;
			var select = document.getElementById("subcategory"); 
			for(var j = 0; j < arraySize; j++) {
			    var opt = data.subcategories[j].name;
			    var el = document.createElement("option");
			    el.textContent = opt;
			    el.value = opt;
			    select.appendChild(el);
			}
		}
}

window.onload = function() {
	var url = "http://localhost:8001/asikb/rest/categories";
	searchCategories(url);
	var url2 = "http://localhost:8001/asikb/rest/subcategories";
	searchSubcategories(url2);
}