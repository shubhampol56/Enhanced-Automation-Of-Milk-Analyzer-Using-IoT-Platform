const express = require('express');
const router = express.Router();
const jwt = require('jsonwebtoken');
const supplier = require('../models/supplier');


//get supplier
router.get('/getsupplier',(req,res,next)=>{
    supplier.find(function (err,suppliers) {
    res.json(suppliers);

})
});



//get count

router.get('/getsuppliercount',(req,res,next)=>{

    supplier.count(function(err,c){
    res.json(c);
});
});


//add supplier

router.post('/addsupplier',(req,res,next)=>{
    let newsupplier = new supplier({
        fname: req.body.fname,
        lname: req.body.lname,
        suppliercode: req.body.suppliercode,
        address: req.body.address,
        tehsil: req.body.tehsil,
        district: req.body.district,
        pincode: req.body.pincode,
        mobile: req.body.mobile,
        email: req.body.email,
        milktype: req.body.email,
        activated: req.body.activated,
        createdby: req.body.createdby,
        associatedto: req.body.associatedto,
        createdon: req.body.createdon,
        aadharno: req.body.aadharno,
        panno: req.body.panno,
        gstno: req.body.gstno,
        accholdername: req.body.accholdername,
        milktype: req.body.milktype,
        bankname: req.body.bankname,
        bankbranchname: req.body.bankbranchname,
        accno: req.body.accno,
        ifsc: req.body.ifsc,
        acctype: req.body.acctype,
        fdano: req.body.fdano,
        validfrom: req.body.validfrom,
        validtill: req.body.validtill
    });

newsupplier.save((err, supplier)=>{
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
        date: req.body.date
    }

    supplier.findOne({suppliercode:req.body.supplier}).then(function (record) {
        record.milkcollection.push(collection);
        record.save();
    })


});



module.exports = router;