var express = require('express');
var multer = require('multer');
var xlstojson = require("xls-to-json-lc");
var xlsxtojson = require("xlsx-to-json-lc");
var mongoose = require('mongoose')
var assert = require('assert')
var assert = require('assert')
var MongoClient = require('mongodb').MongoClient;


//multer
var _router = express.Router();

var Schema = mongoose.Schema;
var ratechart;
var name="";
var namec="";
var nameb="";
var ratechartshow;
var ratechartschema = new Schema({

});

var store = multer.diskStorage({

    filename:function (req,file,cb) {
        cb(null,Date.now()+'.'+file.originalname);
    }
});

var upload = multer({storage:store}).single('file');


_router.post('/reg',function (req,res,next) {
    ratechart = mongoose.model(req.body.animal+req.body.applicable,ratechartschema);
});

_router.post('/givename',function (req,res,next) {
    name = req.body.animal+req.body.applicableto.toLowerCase();
    console.log(name);
});

_router.get('/show',function (req,res,next) {

    ratechartshow = mongoose.model(name,ratechartschema);
    ratechartshow.find(function (err,ratechart) {
        res.json(ratechart);

    });
});

_router.post('/givenamec',function (req,res,next) {
    namec = "c"+req.body.applicableto.toLowerCase();
    console.log(namec);
});

_router.get('/showc',function (req,res,next) {

    ratechartshow = mongoose.model(namec,ratechartschema);
    ratechartshow.find(function (err,ratechart) {
        res.json(ratechart);
        console.log(ratechart);
    });
});

_router.post('/givenameb',function (req,res,next) {
    nameb = "b"+req.body.applicableto.toLowerCase();
    console.log(nameb);
});

_router.get('/showb',function (req,res,next) {

    ratechartshow = mongoose.model(nameb,ratechartschema);
    ratechartshow.find(function (err,ratechart) {
        res.json(ratechart);
        console.log(ratechart);
});
});

_router.post('/upload',function (req,res,next) {

    upload(req, res, function (err) {
        if (err) {
            return res.status(501).json({error: err});
            return;
        }
        if (!req.file) {
            res.json({error_code: 1, err_desc: "No file passed"});
            return;
        }

        if(req.file.originalname.split('.')[req.file.originalname.split('.').length-1] === 'xlsx'){
            exceltojson = xlsxtojson;
        } else {
            exceltojson = xlstojson;
        }
        try {
            exceltojson({
                input: req.file.path,
                output: null, //since we don't need output.json
                lowerCaseHeaders:true
            }, function(err,result){
                if(err) {
                    return res.json({error_code:1,err_desc:err, data: null});
                }
                res.json({error_code:0,err_desc:null, data: result});
                ratechart.collection.insertMany(result,function (err,r) {
                    assert.equal(null, err);

                })
 //               console.log( res.json({error_code:0,err_desc:null, data: result}));
            });
        } catch (e){
            res.json({error_code:1,err_desc:"Corupted excel file"});
        }


   //     return res.json({originalname:req.file.originalname, uploadname: req.file.filename});
    });
});







module.exports = _router;