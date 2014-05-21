
function startSimulation() {
    if (sim == null) {
        sim = new Simulation();
    }
    if (sim.simulationLoop == null) {

        var $buttonStartSimulation = $('#startSimulationButton');
        var $buttonStopSimulation = $('#stopSimulationButton');
        var $buttoncreateBox = $('#createBoxButton');
        var $buttonMoveBox = $('#moveBoxButton');
        $buttonStartSimulation.attr("disabled", true);
        $buttonStopSimulation.attr("disabled", false);
        $buttoncreateBox.attr("disabled", false);
        $buttonMoveBox.attr("disabled", false);

        sim.canvas = document.getElementById('canvas');
        sim.ctx = sim.canvas.getContext("2d");
        sim.simulationLoop = setInterval(doSimulationLoop, 100);
        console.log("simulationLoop: " + sim.simulationLoop + " started");
    }
}

function stopSimulation() {
    var $buttonStartSimulation = $('#startSimulationButton');
    var $buttonStopSimulation = $('#stopSimulationButton');
    var $buttoncreateBox = $('#createBoxButton');
    var $buttonMoveBox = $('#moveBoxButton');
    $buttonStartSimulation.attr("disabled", false);
    $buttonStopSimulation.attr("disabled", true);
    $buttoncreateBox.attr("disabled", true);
    $buttonMoveBox.attr("disabled", true);

    if (sim != null) {
        clearInterval(sim.simulationLoop);
        console.log("simulationLoop: " + sim.simulationLoop + " stopped");
        sim.simulationLoop = null;
        sim = null;
    }
}

function doSimulationLoop() {
    update();
    draw();
}


function update() {

    var box;
    var endLocation;
    var boxes = sim.boxes;
    var storageBins = sim.rack.storageBins;
    var locations = sim.locations;
    //var locations = storageBins;
    //locations[storageBins.length - 1] = ps;


    // iterage through all boxes
    for (i = 0; i < boxes.length; i++) {
        box = null;
        endLocation = null;

        if (boxes[i].move && boxes[i].direction && boxes[i].locationId) {
            box = boxes[i];                                                     // find a box with direction and locationId

            for (j = 0; j < storageBins.length; j++) {
                if (storageBins[j].id == box.locationId) {
                    endLocation = storageBins[j];                                // find a storage bin!
                }
            }
            for (j = 0; j < locations.length; j++) {
                if (locations[j].id == box.locationId) {
                    endLocation = locations[j];                                // find a location except storage bin!
                }
            }
        }

                   
        // there is a box to move to a storage bin OR OTHER LOCATION
        if (box != null && endLocation != null) {
            console.log("box to move: " + box.x + ":" + box.y);
            console.log("endLocation : " + endLocation.x + ":" + endLocation.y);

            // if the BOX IS ALREADY AT THE ENDLOCATION stop movement
            if (box.x == endLocation.x && box.y  == endLocation.y) {
                box.move = false;
                box.direction = null;
                console.log("box arrived!");
                sendMessage("MOVE_FINISHED" + " "  + box.id + " " + endLocation.id);
            }
            // if the box is not in the storage bin             
            // if the box is on the conveyor move along the conveyor
            else if (box.x < sim.conveyor.x + sim.conveyor.width && box.y < sim.conveyor.y + sim.conveyor.height) {

                var xLeftLower = sim.conveyor.x;
                var yLeftUpper = sim.conveyor.y;
                var xRightUpper = sim.conveyor.x + sim.conveyor.width;
                var yRightLower = sim.conveyor.y + sim.conveyor.height - boxHeight;

                moveBox(box, xLeftLower, yLeftUpper, xRightUpper, yRightLower);
            }
            // if the box is at the scanner or on its right then move right
            else if (box.x >= sim.conveyor.scanner.x && box.x < sim.rack.x - boxWidth && box.y == sim.conveyor.scanner.y) {
                box.direction = "right";
                //console.log();
                moveBox(box, box.x, box.y, sim.rack.x - boxWidth, box.y); //sim.conveyor.x + sim.conveyor.width + boxWidth
                //moveBox(sim.rackFeeder, sim.rackFeeder.x, sim.rackFeeder.y, sim.rack.x - boxWidth, sim.rackFeeder.y);
            }

            // if the box is right at the rack and not at the storageBin => move down
            else if (box.x == sim.rack.x - boxWidth && box.y != endLocation.y) {
                box.direction = "down";
                moveBox(box, sim.conveyor.x + sim.conveyor.width, sim.conveyor.y, sim.conveyor.x + sim.conveyor.width, sim.conveyor.y + sim.conveyor.height - boxHeight);
            }

            // if the box is infront of the storagebin
            else if (box.y == endLocation.y && box.x >= sim.conveyor.x + sim.conveyor.width) {
                box.direction = "right";
                moveBox(box, sim.conveyor.x + sim.conveyor.width, endLocation.y, sim.conveyor.x + sim.conveyor.width + 2 * boxWidth, endLocation.y);
            }
            // else 
            else{
                //box.direction = "left";
                moveBox(box, sim.conveyor.x + sim.conveyor.width, endLocation.y, sim.conveyor.x + sim.conveyor.width + 2 * boxWidth, endLocation.y);
            }             
        }
    }
}

// help function for update!
// move box up, right, down and left on the conveyor
function moveBox(box, xll, ylu, xru, yrl) {

    var xLeftLower = xll;
    var yLeftUpper = ylu;
    var xRightUpper = xru;
    var yRightLower = yrl;

    // move up
    if (box.direction == "up") {
        console.log("moving up");
        if (box.y - dy >= yLeftUpper) { // yLeftUpper
            box.y -= dy;
        }
        else {
            box.direction = "right";
            console.log("stop moving up");
        }
    }

    // move right
    else if (box.direction == "right") {
        console.log("moving right");
        if (box.x + dx <= xRightUpper) { // xRightUpper
            box.x += dx;
        }
        else {
            console.log("stop moving right");
            box.direction = "down";
        }
    }

    // move down
    else if (box.direction == "down") {
        console.log("moving down");
        if (box.y + dy <= yRightLower) { // yRightLower
            box.y += dy;
        }
        else {
            box.direction = "left";
            console.log("stop moving down");
        }
    }

    // move left
    else if (box.direction == "left") {
        console.log("moving left");
        if (box.x - dx >= xLeftLower) { // xLeftLower
            box.x -= dx;
        }
        else {
            console.info("stop moving left");
            box.direction = "up";
        }
    }
}


//the heart of the script and it beats once every 10 milliseconds 
//thanks to the setInterval() method
function draw() {
    clear();
    var ctx = sim.ctx;

    // 1! draw conveyor
    var conveyor = sim.conveyor;
    drawConveyor(conveyor, ctx);

    // draw a worker
    drawWorker(conveyor, ctx);

    // 2! draw storageBins
    var storageBins = sim.rack.storageBins;
    drawStorageBins(storageBins, ctx);

    // 3! draw locations
    var locations = sim.locations;
    drawLocations(locations, ctx);

    // 4! draw boxes
    var boxes = sim.boxes;
    drawBoxes(boxes, ctx);

    /*// 1! draw rackFeeder
    var rackFeeder = sim.rackFeeder;
    ctx.beginPath();
    ctx.rect(rackFeeder.x, rackFeeder.y, rackFeeder.width, rackFeeder.height);
    ctx.closePath();
    ctx.lineWidth = 1;
    ctx.strokeStyle = 'blue';
    ctx.stroke();*/

}

function drawConveyor(conveyor, ctx) {
    
    ctx.beginPath();
    // x, y, width, height!!
    ctx.rect(conveyor.x, conveyor.y, conveyor.width, conveyor.height);
    ctx.closePath();
    ctx.lineWidth = 1;
    ctx.strokeStyle = 'black';
    ctx.stroke();
    ctx.fillStyle = "#99BBE8";
    ctx.fill();

    ctx.beginPath();
    // x, y, width, height!!
    ctx.rect(conveyor.x + boxWidth, conveyor.y + boxHeight, conveyor.width - 2 * boxWidth, conveyor.height - 2 * boxHeight);
    ctx.closePath();
    ctx.lineWidth = 1;
    ctx.strokeStyle = 'black';
    ctx.stroke();
    ctx.fillStyle = "#D2E0F0";
    ctx.fill();
    ctx.font = "15px Arial";
    ctx.strokeText("Conveyor", conveyor.x, conveyor.y);
}

function drawBoxes(boxes, ctx) {
    var box;
    for (i = 0; i < boxes.length; i++) {
        if (boxes[i]) {
            box = boxes[i];
        }
        ctx.beginPath();
        ctx.moveTo(box.x, box.y);        	                // Top Left
        ctx.lineTo(box.x + box.width, box.y); 		        // Top Right
        ctx.lineTo(box.x + box.width, box.y + box.height);  // Bottom Right
        ctx.lineTo(box.x, box.y + box.height);              // Bottom Left
        ctx.closePath();

        ctx.lineWidth = 1;
        ctx.strokeStyle = "black";
        ctx.stroke();

        ctx.fillStyle = "grey";
        ctx.fill();
        ctx.fillStyle = "black";
        ctx.fillText(box.id, box.x, box.y + box.height/2);
    }
}

function drawStorageBins(storageBins, ctx) {
    var storageBin;
    ctx.beginPath();
    ctx.strokeText("Rack", sim.rack.x, sim.rack.y);
    ctx.closePath();

    for (i = 0; i < storageBins.length; i++) {
        if (storageBins[i]) {
            storageBin = storageBins[i];
        }
        ctx.beginPath();
        ctx.moveTo(storageBin.x, storageBin.y);        	                  // Top Left
        ctx.lineTo(storageBin.x + storageBin.width, storageBin.y); 		      // Top Right
        ctx.lineTo(storageBin.x + storageBin.width, storageBin.y + storageBin.height);  // Bottom Right
        ctx.lineTo(storageBin.x, storageBin.y + storageBin.height);              // Bottom Left
        ctx.closePath();

        ctx.lineWidth = 1;
        ctx.lineJoin = "round";
        ctx.strokeStyle = "black";
        ctx.stroke();

        ctx.fillStyle = "black";
        ctx.font = "13px Arial";
        ctx.strokeText(storageBin.id + " storageBin", storageBin.x + boxWidth, storageBin.y + storageBin.height / 2);
        //ctx.fillText(storageBin.id, storageBin.x + boxWidth, storageBin.y + storageBin.height / 2);
    }
}

function drawWorker(conveyor, ctx) {
    var w = boxWidth;
    var h = 2 * boxHeight;

    var headX = conveyor.x / 3 * 2;
    var headY = conveyor.y + conveyor.height - h / 3;
    var bellyY = headY + h / 4;
    var feetY = bellyY + h / 10;
    var headRadius = headX / 5;
    var headNackY = headY + headRadius;
    ctx.beginPath();
    ctx.strokeStyle = "#000000";
    ctx.lineWidth = "1";

    //arc(w / 2, h / 2, h / 10, 0, Math.PI * 2, true);

    ctx.arc(headX, headY, headRadius, 0, Math.PI * 2, true);
    ctx.moveTo(headX, headNackY);
    ctx.lineTo(headX, bellyY);


    /*
    Draw Legs
    */
    ctx.moveTo(headX, bellyY);
    ctx.lineTo(headX + headRadius, feetY);
    ctx.moveTo(headX, bellyY);
    ctx.lineTo(headX - headRadius, feetY);
    /*
    Draw Arms
    */
    ctx.moveTo(headX - headRadius, headNackY + (bellyY - headNackY) / 2);
    ctx.lineTo(headX + headRadius, headNackY + (bellyY - headNackY) / 2);
    ctx.stroke();
    ctx.closePath();
}

function drawLocations(locations, ctx) {
    var loc;
    for (i = 0; i < locations.length; i++) {
        if (locations[i]) {
            loc = locations[i];
        }
        ctx.beginPath();
        ctx.moveTo(loc.x, loc.y);        	                // Top Left
        ctx.lineTo(loc.x + loc.width, loc.y); 		        // Top Right
        ctx.lineTo(loc.x + loc.width, loc.y + loc.height);  // Bottom Right
        ctx.lineTo(loc.x, loc.y + loc.height);              // Bottom Left
        ctx.closePath();

        ctx.lineWidth = 1;
        ctx.strokeStyle = "black";
        ctx.stroke();

        //ctx.fillStyle = "red";
        //ctx.fill();
        ctx.fillStyle = "black";
        ctx.fillText(loc.id, loc.x, loc.y + loc.height / 2);
    }
}

function startMovingBox(boxId, endDestId) {
    var id = boxId;
    var locationId = endDestId;
    var box;
    for (i = 0; i < sim.boxes.length; i++) {
        if (sim.boxes[i].id == id) {
            var box = sim.boxes[i];
            box.move = true;
            box.direction = "up";
            box.locationId = locationId;
        }
    }
}

function clear() {
    //erase everything in a Conveyor that is the same size as the canvas
    sim.ctx.clearRect(0, 0, 600, 300);
}


// ************************************************************ //
// interactions with the index.html

function startMovingBoxFromSite() {
    var id = document.getElementById('boxIdToMove').value;
    var locationId = document.getElementById('StorageBinIdToMoveTo').value;

    var box;
    for (i = 0; i < sim.boxes.length; i++) {
        if (sim.boxes[i].id == id) {
            var box = sim.boxes[i];
            box.move = true;
            box.direction = "up";
            box.locationId = locationId;
        }
    }
}