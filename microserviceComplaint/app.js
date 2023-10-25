var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
const http = require("http");

require("dotenv").config(); //configuration dotenv
const mongoose = require('mongoose')
const db = require('./db.json') //configuration json
const eurekaHelper = require('./eureka-helper');


var complaintRouteurs = require('./routes/complaint');
//var indexRouter = require('./routes/index');

const { error } = require('console');

mongoose.set('strictQuery', false);
mongoose.connect(process.env.URL_MONGO || db.mongo.uri, {
  useNewUrlParser: true, useUnifiedTopology: true
}).then(
  ()=>{    console.log('Connected to MongoDB');}
).catch(
  (error)=>{console.log(error.message);}
);


var app = express();
const PORT = process.env.PORT || 5000;

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());

app.use('/complaints', complaintRouteurs)

var router = express.Router();

app.listen(PORT, () => {
  console.log("complaint-service on 5000");
})



module.exports = router;

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  next(createError(404));
});

// error handler
app.use(function (err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.json(err.message);
});

// registering serve on Eureka
eurekaHelper.registerWithEureka('complaint-service', PORT);
