const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');

const supplierSchema = mongoose.Schema({
    fname:{
        type: String,
        required: true
    },
    lname:{
        type: String,
        required: true
    },
    suppliercode:{
        type: String,
        required: true
    },
    address:{
        type:String,
        required: true
    },
    tehsil:{
        type:String
    },
    district:{
        type: String
    },
    pincode:{
        type:String
    },
    mobile:{
        type:String,
        required:true
    },
    email:{
        type:String
    },
    milktype:{
        type:String,
        required:true
    },
    activated:{
        type:String,
        required: true
    },
    createdby:{
        type:String,
        required:true
    },
    associatedto:{
        type:String,
        required:true
    },
    createdon:{
        type:String,
        required:true
    },
    aadharno:{
        type:String
    },
    panno:{
        type:String
    },
    gstno:{
        type:String
    },
    accholdername:{
        type: String,
        required: true
    },

    milktype:{
        type: String,
        required: true
    },
    bankname:{
        type: String
    },
    bankbranchname:{
        type:String
    },
    accno:{
        type: String
    },
    ifsc:{
        type: String
    },
    acctype:{
        type: String
    },
    fdano:{
        type:String
    },
    validfrom:{
        type:String
    },
    validtill:{
        type:String
    },
    milkcollection:[{
        shift:String,
        milktype:String,
        fat:String,
        snf:String,
        quantity:String,
        amount:String,
        date:String
    }]
},{collection: 'suppliers'});


const supplier = module.exports = mongoose.model('supplier',supplierSchema);

//module.exports.getFarmerById = function(id, callback){
//    Farmer.findById(id, callback);
//}

//module.exports.getSupplierByname = function(name, callback){
//    const query = {name: name}
//    .findOne(query, callback);
//}

