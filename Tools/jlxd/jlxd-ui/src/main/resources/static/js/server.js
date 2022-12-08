$(document).ready(function () {
    // Add Server Form
	$("#addServerButton").click(function (event) {
		event.preventDefault();
		var name = $("#addServerForm #name").val();
	    var hostAndPort = $("#addServerForm #hostAndPort").val();
	    var description = $("#addServerForm #description").val();
	    var remoteCert = $("#addServerForm #remoteCert").val();
	    var remoteKey = $("#addServerForm #remoteKey").val();
	    addServer(name, hostAndPort, description, remoteCert, remoteKey);
	});

    // initialise the page
	searchServers("");
//	getServerInfo();
});

function searchServers(searchTerm) {
    var placeholderEle = $("#serverinfo");
    var postUrl = "/server/search";
    var templateName = "serverinfo";
    var searchInput = {};
    searchInput["searchTerm"] = searchTerm;
    var jsonData = JSON.stringify(searchInput);

	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
}


function addServer(name, hostAndPort, description, remoteCert, remoteKey) {
	var placeholderEle = $("#serverinfo");
	var postUrl = "/server/create";
    var templateName = "serverinfo";
    var addServerInput = {};
    addServerInput["name"] = name;
    addServerInput["hostAndPort"] = hostAndPort;
    addServerInput["description"] = description;
    addServerInput["remoteCert"] = remoteCert;
    addServerInput["remoteKey"] = remoteKey;
    var jsonData = JSON.stringify(addServerInput);

	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
}

function removeServer(name) {
    var placeholderEle = $("#serverinfo");
    var postUrl = "/server/delete/"+name;
    var templateName = "serverinfo";
    var jsonData = "";

	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
	return false;
}
