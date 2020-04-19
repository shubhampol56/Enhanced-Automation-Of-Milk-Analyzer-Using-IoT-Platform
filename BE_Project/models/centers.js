const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');

const centerSchema = mongoose.Schema({
    centerid:{
        type: String,
        required: true
    },
    centername:{
        type: String,
        required: true
    },
    associatedto:{
        type: String
    },
    billdays:{
        type: String,
        required: true
    },
    centertype:{
        type: String,
        required: true
    },
    centeraddress:{
        type: String,
        required: true
    },
    createdon:{
        type: String,
        required: true
    },
    createdby:{
        type: String,
        required: true
    },
    milkcollection:[{
        supplier:String,
        shift:String,
        milktype:String,
        fat:String,
        snf:String,
        quantity:String,
        amount:String,
        date:String,
        expfat:String,
        expsnf:String,
        expquantity:String
    }],
    uploadedsessions:[{
        shift:String,
        date:String,
        cavgfat:String,
        cavgsnf:String,
        ctotal:String,
        bavgfat:String,
        bavgsnf:String,
        btotal:String
    }]
},{collection: 'centers'});


const center = module.exports = mongoose.model('center',centerSchema);
