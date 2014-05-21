

function createBox(id, locationId) {
    var box = new Box(id);

    // create box on the conveyor
    box.x = boxWidth * 2;
    box.y = boxHeight * 6;

    // if the box is in the storageBin, set its x&y to storageBins x&y
    for (i = 0; i < sim.rack.storageBins.length; i++) {
        if (sim.rack.storageBins[i].id == locationId) {
            var storageBin = sim.rack.storageBins[i];
            box.locationId = locationId;
            box.x = storageBin.x;
            box.y = storageBin.y;
        }
    }

    sim.boxes[sim.boxes.length] = box;
    console.info("box created");
}

function createBoxFromSite() {
    var id = document.getElementById('boxId').value;
    var box = new Box(id);
    box.x = boxWidth * 2;
    box.y = boxHeight * 6;
    sim.boxes[sim.boxes.length] = box;
    console.info("box created");

    //box.x = box.width * boxes.length * 2;
    //boxes[boxes.length] = box;
}

function createStorageBin(id) {
    var storageBin = new StorageBin(id);
    storageBin.x = storageBin.x;
    storageBin.y = storageBin.y + (storageBin.height * sim.rack.storageBins.length);
    sim.rack.storageBins[sim.rack.storageBins.length] = storageBin;
    console.info("a storage bin created" + id);
}



//function storeBox(boxId, endDestId) {
//    startMovingBox(boxId, endDestId);
//    console.info("box stored " + boxId + " " + endDestId);
//}
