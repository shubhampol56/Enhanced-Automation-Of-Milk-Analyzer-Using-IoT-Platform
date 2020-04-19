const express = require('express');
const router = express.Router();
const jwt = require('jsonwebtoken');
const farmer = require('../models/supplier');
const config = require('../config/database');
const passport = require('passport');
var serialport = require("serialport");
var Serialport = serialport.Serialport;
var portName = process.argv[2];


var myport = new Serialport(portName,{
    baudrate:9600,
    parser: serialport.parsers.readline("\r\n")
})


myport.on('open',onOpen);
myport.on('data',onData);


function onOpen() {
    console.log("Oepn connection");
}


function onData(data){
    console.log("on data:"+data);
}



//add farmer
router.post('/addfarmer',(req,res,next)=>{

    let newfarmer = new farmer({
        name: req.body.name,
        accont_holder_name: req.body.account_holder_name,
        milk_type: req.body.milk_type,
        bank_name: req.body.bank_name,
        ac_num: req.body.ac_num,
        ifsc_code:req.body.ifsc_code,
        ac_type: req.body.ac_type,
        address: req.body.address,
        tehsil: req.body.tehsil,
        district: req.body.district,
        pin_code: req.body.pin_code,
        phone: req.body.phone,
        email: req.body.email,
        pan_no: req.body.pan_no,
        aadhar_no: req.body.aadhar_no,
        GST_no: req.body.GST_no
    });


newfarmer.save((err,farmerr)=>{
    if(err)
    {
        res.json({msg:'Failed to add farmer'});
    }
    else
        {
            res.json({msg:'Farmer added successfully'});
        }
});

});



module.exports = router;