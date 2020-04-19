// importing modules

var express = require('express');
var mongoose = require('mongoose');
var bodyparser = require('body-parser');
var cors = require('cors');
var path = require('path');
var passport = require('passport');
var app = express();
const supplierroutes = require('./routes/supplierroutes');
const userroutes = require('./routes/userroutes');
const centerroutes = require('./routes/centerroutes');
const ratechartroutes = require('./routes/ratechart');
//connect to mongodb
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost:27017/project');

//on connection
mongoose.connection.on('connected',()=>{
    console.log('Connected');
});

mongoose.connection.on('error',(err)=>{
    if(err){
        console.log('Error:'+err);
    }
});


//port no
const port = 3000;


//passport middleware
app.use(passport.initialize());
app.use(passport.session());

require('./config/passport')(passport);


//adding midleware
app.use(cors());

//ading bodyparser
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended: true}));

//static files
//app.use(express.static(path.join(__dirname,'public')));

//app.use('/vlccroutes',vlcc_route);
app.use('/suppliers',supplierroutes)
app.use('/userlogins',userroutes);
app.use('/centers',centerroutes);
app.use('/ratechart',ratechartroutes);
//testing server
app.get('/',(req,res)=>{
    res.send('foobar');
});

app.listen(port,()=>{
    console.log("server started "+port);
});
