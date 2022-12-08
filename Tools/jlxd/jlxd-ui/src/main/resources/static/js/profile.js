$(document).ready(function () {
	// Search form
    $("#search-form").submit(function (event) {
        event.preventDefault();
        var searchTerm = $("#searchTerm").val();
        searchProfiles(searchTerm);
    });

    // initialise the page
	getAllServers();
	searchProfiles("");
});

function searchProfiles(searchTerm) {
    var placeholderEle = $("#profiles");
    var postUrl = "/profile/search";
    var templateName = "profile";
    var searchInput = {};
    searchInput["searchTerm"] = searchTerm;
    var jsonData = JSON.stringify(searchInput);

	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
}

function reloadProfiles() {
    var placeholderEle = $("#profiles");
    var postUrl = "/profile/reload";
    var templateName = "profile";
    var jsonData = "";

	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
}
