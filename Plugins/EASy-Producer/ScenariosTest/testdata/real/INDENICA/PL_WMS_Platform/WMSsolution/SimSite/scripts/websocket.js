var noSupportMessage = "Your browser cannot support WebSocket!";
var ws;

// connecting to the SimServer and receiving its messages from the webSocket!
function connectSocketServer() {
    var messageBoard = $('#messageBoard');
    var $buttonConnect = $('#btnConnect');
    var $buttonDisconnect = $('#btnDisconnect');
    var $buttonSend = $('#btnSend');

    var support = "MozWebSocket" in window ? 'MozWebSocket' : ("WebSocket" in window ? 'WebSocket' : null);

    if (support == null) {
        alert(noSupportMessage);
        messageBoard.append("* " + noSupportMessage + "<br/>");
        scrollToBottom(messageBoard);
        return;
    }

    var connectionString = 'ws://localhost:4502/test';
    messageBoard.append("* Connecting to server " + connectionString + " ..<br/>");
    scrollToBottom(messageBoard);
    // create a new websocket and connect
    ws = new window[support](connectionString); // ws = new WebSocket(connectionString)

    // when the connection is established, this method is called
    ws.onopen = function () {
        messageBoard.append('* Connection open<br/>');
        scrollToBottom(messageBoard);
        
        $buttonConnect.attr("disabled", true);
        $buttonDisconnect.attr("disabled", false);
        $buttonSend.attr("disabled", false);

        startSimulation();
    };

    // when data is comming from the server, this metod is called
    ws.onmessage = function (evt) {
        messageBoard.append("SimServer: " + evt.data + "<br />");
        scrollToBottom(messageBoard);

        // RELOAD_SIMULATION
        if (evt.data.startsWith("RELOAD_SIMULATION")) {
            stopSimulation();
            startSimulation();
        }

        // CREATE_BOX
        if (evt.data.startsWith("CREATE_BOX")) {
            var messageArray = evt.data.split(" ");
            if (messageArray != null)
                createBox(messageArray[1], messageArray[2]);
        }

        // CREATE_STORAGEBIN
        if (evt.data.startsWith("CREATE_STORAGEBIN")) {
            var messageArray = evt.data.split(" ");
            if (messageArray != null)
                createStorageBin(messageArray[1]);
        }

        // STORE_BOX from ClientForms
        if (evt.data.startsWith("STORE_BOX")) {
            var messageArray = evt.data.split(" ");
            var boxId = messageArray[1];
            var destId = messageArray[2];

            if (messageArray != null) {
                console.log("STORE_BOX in webSocket! " + boxId + " " + destId);
                storeBox(boxId, destId);
            }
        }

        // MOVE_BOX from CCS
        if (evt.data.startsWith("MOVE_BOX")) {
            var messageArray = evt.data.split(" ");
            //public string Transport(string boxId, string transportMediumId, string startLocId, string endLocId)
            var boxId = messageArray[1];
            var transportMediumId = messageArray[2];
            var startLocId = messageArray[3];
            var endLocId = messageArray[4];

            if (messageArray != null) {
                console.log("MOVE_BOX in webSocket! " + boxId + " " + endLocId);
                startMovingBox(boxId, endLocId);
            }
        }

    };

    // when the connection is closed, this method is called
    ws.onclose = function () {
        messageBoard.append('* Connection closed<br/>');
        scrollToBottom(messageBoard);

        $buttonConnect.attr("disabled", false);
        $buttonDisconnect.attr("disabled", true);
        $buttonSend.attr("disabled", true);

        stopSimulation();
    }
}

// moving box
function xxx(boxId, transportMediumId, startLocId, endLocId) {
    
}

// disconnecting from the SimServer
function disconnectSocketServer() {
    ws.close();
}

function scrollToBottom(target) {
    target.animate({ scrollTop: target[0].scrollHeight });
}


if (typeof String.prototype.startsWith != 'function') {
    String.prototype.startsWith = function (str) {
        return this.slice(0, str.length) == str;
    };
}

// ************************************************************************************************************************* //
// sending message to the server
function sendMessage(message) {
    if (ws) {
        var messageBoard = $('#messageBoard');

        messageBoard.append("SimSite: " + message + "<br />");
        scrollToBottom(messageBoard);

        ws.send(message);
        console.log("message sended: " + message);
    } else {
        alert(noSupportMessage);
    }
}

function sendMessageFromSite() {
    if (ws) {
        var messageBox = document.getElementById('messageBoxCell');
        var messageBoard = $('#messageBoard');

        messageBoard.append("SimSite: " + messageBox.value + "<br />");
        scrollToBottom(messageBoard);

        ws.send(messageBox.value);
        messageBox.value = "";
    } else {
        alert(noSupportMessage);
    }
}
