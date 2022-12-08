$(document).ready(function () {
	// Search form
    $("#search-form").submit(function (event) {
        event.preventDefault();
        var searchTerm = $("#searchTerm").val();
        searchImages(searchTerm);
    });

    $(document).on("click", "#btnAddAlias", function () {
    	var imageFingerprint = $(this).data('fingerprint');
    	$(".modal-body #fingerprint").val( imageFingerprint );
    });
    
	$("#addAliasButton").click(function (event) {
		event.preventDefault();
	    var aliasName = $("#addAliasForm #name").val();
	    var imageAlias = $("#addAliasForm #fingerprint").val();
	    addAlias(aliasName, imageAlias);
	});

    // initialise the page
	getAllServers();
	searchImages("");
});

function searchImages(searchTerm) {
    var placeholderEle = $("#images");
    var postUrl = "/image/search";
    var templateName = "image";
    var searchInput = {};
    searchInput["searchTerm"] = searchTerm;
    var jsonData = JSON.stringify(searchInput);

	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
}

function reloadImages() {
    var placeholderEle = $("#images");
    var postUrl = "/image/reload";
    var templateName = "image";
    var jsonData = "";

	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
}

function addAlias(aliasName, imageAlias) {
    var placeholderEle = $("#images");
	var postUrl = "/image/alias/create/"+aliasName+"/"+imageAlias;
    var templateName = "image";
//    var addAliasInput = {};
//    addAliasInput["aliasName"] = aliasName;
//    addAliasInput["imageAlias"] = imageAlias;
//    var jsonData = JSON.stringify(addAliasInput);
    var jsonData = "";
    
	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);
}

function deleteAlias(aliasName) {
    var placeholderEle = $("#images");
	var postUrl = "/image/alias/delete/"+aliasName;
    var templateName = "image";
    var jsonData = "";
    
	fire_ajax_submit(postUrl, jsonData, templateName, placeholderEle);	
}

function toggleEditState(event, element, containerName) {
	event.preventDefault();
	var postUrl = "/image/save/"+containerName;
	var eleId = "#"+element.id;
	var rowId = "#row_"+containerName;
	console.log(eleId+" "+rowId);
	if (eleId == "#editContainer") {
		$(rowId).css("background-color", "lightgrey");
		$(rowId).find("#desc").html("<input type='text' name='decription' id='editDesc' value='"+$(rowId).find("#desc").text()+"'></input>");
	} else {
		$(rowId).css("background-color", "");
		$(rowId).find("#desc").text($(rowId).find("#editDesc").val());
	}
	$(rowId).find("#editContainer").toggle();
	$(rowId).find("#saveContainer").toggle();
}
