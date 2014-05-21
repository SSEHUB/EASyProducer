var boxWidth = 40;
var boxHeight = 40;

var dx = 5; // speed x
var dy = 5; // speed y
var simWidth = 12 * boxWidth;
var simHeight = 8 * boxHeight;
var sim = null;


function Box(id) {
    this.id = id;
    this.x = 0;
    this.y = 0;
    this.width = boxWidth;
    this.height = boxHeight;
    this.locationId = null;

    //set movement direction
    this.move = false;    
    this.direction = null;
}

function StorageBin(id) {
    this.id = id;
    this.x = 10*boxWidth;
    this.y = 2*boxHeight;
    this.width = boxWidth;
    this.height = boxHeight;
}

function Conveyor() {
    this.x = 2*boxWidth;
    this.y = 2*boxHeight;
    this.width = 6*boxWidth;
    this.height = 5*boxHeight;
    this.scanner = new Scanner();
    this.boxesOn = new Array();   
}

function Scanner() {
    this.x = null;
    this.y = null;
    this.width = boxWidth;
    this.height = boxHeight;
}

function Rack() {
    this.x = 10 * boxWidth;
    this.y = 2 * boxHeight;
    this.storageBins = new Array();
    this.horisontal = true;
    this.rackFeeder = new RackFeeder();
}

function RackFeeder() {
    this.x = 8*boxWidth;
    this.y = 2*boxHeight;
    this.width = boxWidth;
    this.height = boxHeight;
    this.box = null;
}

function Location(id) {
    this.id = id;
    this.x = null;
    this.y = null;
    this.width = boxWidth;
    this.height = boxHeight;
}

function Simulation() {
    this.canvasWidth = simWidth;
    this.canvasHeight = simHeight;

    // 1. conveyor
    this.conveyor = new Conveyor();
    this.conveyor.scanner = new Scanner();
    this.conveyor.scanner.x = this.conveyor.x + this.conveyor.width - boxWidth;
    this.conveyor.scanner.y = this.conveyor.y;

    // 2. Rack
    this.rack = new Rack();
    this.rack.horisontal = true;
    
    // 3. RackFeeder
    this.rack.rackFeeder = new RackFeeder();

    // 4. Boxes
    this.boxes = new Array();

    // 4. Boxes
    this.locations = new Array();


    this.simulationLoop = null;
    this.canvas = null;
    this.ctx = null;

    // creating TS hartcoded
    var locId = "TS";
    var location = new Location(locId);
    location.x = 7 * boxWidth;
    location.y = 2 * boxHeight;
    location.width = boxWidth;
    location.height = boxHeight;

    this.locations[this.locations.length] = location;
    console.info("location created " + locId);

    // creating RS hartcoded
    var locId = "RS";
    var location = new Location(locId);
    location.x = 2 * boxWidth;
    location.y = 6 * boxHeight;
    location.width = boxWidth;
    location.height = boxHeight;

    this.locations[this.locations.length] = location;
    console.info("location created " + locId);

}
