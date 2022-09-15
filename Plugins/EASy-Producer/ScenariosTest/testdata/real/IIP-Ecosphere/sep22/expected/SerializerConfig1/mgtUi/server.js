const express = require("express");
const path = require("path");
const cors = require("cors");
const app = express(),
      bodyParser = require("body-parser");
      port = 4200;

app.use(bodyParser.json());
app.use(express.static(process.cwd()+"/dist/iipes-web/"));
app.use(cors());

app.get(/^(\/download)/, (req, res) => {
  var pathSuffix = req.originalUrl.replace(/^(\/download)/, "");
  var file;
  if (path.isAbsolute(`artifacts`)) {
       file = path.join(`artifacts`, pathSuffix);
  } else {
       file = path.join(__dirname, `artifacts`, pathSuffix);
  }
  res.download(file);
});

app.get(/^\//, (req, res) => {
  res.sendFile(process.cwd()+"/dist/iipes-web/index.html")
});

app.listen(port, () => {
  console.log("Server listening on port 4200");
});
