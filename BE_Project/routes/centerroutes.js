const express = require('express');
const router = express.Router();
const jwt = require('jsonwebtoken');
const center = require('../models/centers');

var par;


//-----------------------------Serial Port------------------------------

/*
router.get('/getquantity',(req,res,next)=> {

    var serialport = require("serialport");
var flag = false;
var line=null;
var myPort = new serialport('COM3', {
    baudRate: 9600,
    //parser:serialport.parsers.readline("\r\n")
})

const Readline = serialport.parsers.Readline;
const parser = new Readline();
myPort.pipe(parser);


myPort.on('data', onData);
myPort.on('error', onError);



function onData(data) {

    console.log('data received: ' + data);

        res.json(data);
        console.log(data);

        serialPort.close(function () {
            console.log('closing');
        });

}

function onError() {
    console.log("Error");
}


});

*/
//------------------------------------Serial Port-------------------





//get center
router.get('/getcentername',(req,res,next)=>{
    center.find(function (err,centers) {
        res.json(centers);

})
});

//daily report



//get count

router.get('/getplantcount',(req,res,next)=>{

    center.count({centertype: 'plant'},function(err,c){
        console.log(c);
        res.json(c);
    });
});

router.get('/getsubplantcount',(req,res,next)=>{

    center.count({centertype: 'subplant'},function(err,c){
    console.log(c);
res.json(c);
});
});

router.get('/getbmccount',(req,res,next)=>{

    center.count({centertype: 'bmc'},function(err,c){
    console.log(c);
res.json(c);
});
});

router.get('/getvlcccount',(req,res,next)=>{

    center.count({centertype: 'vlcc'},function(err,c){
    console.log(c);
res.json(c);
});
});
//add center
router.post('/addcenter',(req,res,next)=>{
    let newcenter = new center({
        centerid:req.body.centerid,
        centername: req.body.centername,
        billdays: req.body.billdays,
        centertype: req.body.centertype,
        centeraddress: req.body.centeraddress,
        createdon: req.body.createdon,
        createdby: req.body.createdby,
        associatedto: req.body.associatedto
    });

    newcenter.save((err, center)=>{
        if(err) {
            console.log('failed')
            res.json({msg: 'failed to add'});
        }
        else
            {
                res.json({msg: 'added successfully'});
            }
    });
});




router.post('/collect', function(req, res){

    var collection={
        supplier: req.body.supplier,
        shift: req.body.shift,
        milktype: req.body.milktype,
        fat: req.body.fat,
        snf: req.body.snf,
        quantity: req.body.quantity,
        amount: req.body.amount,
        date: req.body.date,
        expfat: req.body.expfat,
        expsnf: req.body.expsnf,
        expquantity: req.body.expquantity
    }


    center.findOne({centerid:req.body.centerid}).then(function (record) {
        record.milkcollection.push(collection);
        record.save();
    }).catch(function () {
        console.log("error");
    })


});


router.post('/uploadsession', function(req, res){

    var session={
        shift: req.body.shift,
        date: req.body.date,
        cavgfat: req.body.cavgfat,
        cavgsnf: req.body.cavgsnf,
        ctotal:req.body.ctotal,
        bavgfat:req.body.bavgfat,
        bavgsnf:req.body.bavgsnf,
        btotal:req.body.btotal
    }

    console.log(req.body.centerid);

    center.findOne({centerid:req.body.centerid}).then(function (rec) {
        rec.uploadedsessions.push(session);
        rec.save();
        console.log("in");
    }).catch(function () {
        console.log("error");
    });
});

module.exports = router;