const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');

const userSchema = mongoose.Schema({
    firstname:{
        type: String,
        required: true
    },
    lastname:{
        type: String,
        required: true
    },
    user_name:{
        type: String,
        required: true
    },
    password:{
        type: String,
        required: true
    },
    activated:{
        type: String,
        required: true
    },
    user_level_ID:{
        type: String,
        required: true
    },
    createdby:{
        type: String,
        required: true
    },
    createdon:{
        type: String,
        required: true
    },
    phone:{
        type: String,
        required: true
    },
    email:{
        type: String,
        required: true
    },
    usertype:{
        type: String,
        required: true
    },
    usercenter:{
        type: String,
        required: true
    }
});

const user = module.exports = mongoose.model('user',userSchema);

module.exports.getUserById = function(id, callback){
    User.findById(id, callback);
}

module.exports.getUserByUsername = function(user_name,centertype, callback){

    const query = {user_name: user_name};
    const query1 = {$and: [
        {user_name: user_name},
        {centertype: centertype}
    ]};
    user.findOne({$and:[{user_level_ID:centertype},{user_name: user_name}]}, callback);

}

module.exports.getUserBycentertype = function(centertype, callback){
    const query = {centertype : centertype}
    user.findOne(query, callback);
}

module.exports.addUser = function(newUser, callback){

    bcrypt.genSalt(10, (err, salt) => {
        bcrypt.hash(newUser.password, salt, (err, hash) => {
        if(err) throw err;
    newUser.password = hash;
    newUser.save(callback);
});
});
}

module.exports.comparePassword = function(candidatePassword, hash, callback){
    bcrypt.compare(candidatePassword, hash, (err, isMatch) => {
        if(err) throw err;
else{
        callback(null, isMatch);
    }

});
}