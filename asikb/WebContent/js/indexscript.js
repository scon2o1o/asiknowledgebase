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

var searchDocs = function(url) {
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

var loadCategories = function(url2) {
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
			var arraySize = Object.keys(data.documents).length;
			var table = document.getElementById("docstable");
			for (j = 0; j < arraySize; j++) {
				var tr = document.createElement("tr");
				tr.innerHTML = '<td>'
						+ data.documents[j].name
						+ '</td>'
						+ '<td>'
						+ data.documents[j].details
						+ '</td>'
						+ '<td>'
						+ data.documents[j].author
						+ '</td>'
						+ '<td>'
						+ data.documents[j].dateadded
						+ '</td>'
						+ '<td>'
						+ data.documents[j].lastmodified
						+ '</td>'
						+ '<td>'
						+ data.documents[j].category
						+ '</td>'
						+ '<td>'
						+ data.documents[j].subcategory
						+ '</td>'
						+ '<td>'
						+ data.documents[j].likes
						+ '</td>'
						+ '<td><form method="post" action="ViewDocumentServlet" id="ViewDocumentServlet">'
						+ '<input hidden type="text" value="'
						+ data.documents[j].id
						+ '" id="documentId'
						+ [ j ]
						+ '" name="id"></input>'
						+ '<input hidden type="text" value="'
						+ data.documents[j].name
						+ '" id="documentName'
						+ [ j ]
						+ '" name="name"></input>'
						+ '<input hidden type="text" value="'
						+ data.documents[j].details
						+ '" id="documentDetails'
						+ [ j ]
						+ '" name="details"></input>'
						+ '<input hidden type="text" value="'
						+ data.documents[j].url
						+ '" id="documentUrl'
						+ [ j ]
						+ '" name="url"></input>'
						+ '<input hidden type="text" value="'
						+ data.documents[j].category
						+ '" id="documentCategory'
						+ [ j ]
						+ '" name="category"></input>'
						+ '<input hidden type="text" value="'
						+ data.documents[j].subcategory
						+ '" id="documentSubcategory'
						+ [ j ]
						+ '" name="subcategory"></input>'
						+ '<button type="submit" class="btn btn-primary">View</button>'
						+ '</form></td>';
				table.appendChild(tr);
			}
		}
}

var parseResponse2 = function(request) {
	if (request.readyState == 4)
		if (request.status == 200 || request.status == 304) {
			var data = JSON.parse(request.responseText);
			var arraySize = Object.keys(data.categories).length;
			var sidebar = document.getElementById("sidebar");
			for (j = 0; j < arraySize; j++) {
				var a = document.createElement("a");
				var linkText = document.createTextNode(data.categories[j].name);
			      a.appendChild(linkText);
			      a.title = data.categories[j].name;
			      a.setAttribute("id", data.categories[j].name);
			      a.setAttribute("class", "list-group-item list-group-item-action bg-light");
			      a.setAttribute("onclick", "populateSearchbox("+ data.categories[j].name +".title)")
				sidebar.appendChild(a);
			}
		}
}

window.onload = function() {
	var url = "http://localhost:8001/asikb/rest/documents";
	searchDocs(url);
	var url2 = "http://localhost:8001/asikb/rest/categories";
	loadCategories(url2);
}