const express = require('express');
const router = express.Router();
const jwt = require('jsonwebtoken');
const user = require('../models/users');
const config = require('../config/database');
const passport = require('passport');
var localstorage = require('localStorage');
//add user
router.post('/user',(req,res,next)=>{

    let newuser = new user({
        firstname: req.body.fname,
        lastname: req.body.lname,
        user_name: req.body.user_name,
        password: req.body.password,
        activated: req.body.activated,
        user_level_ID: req.body.userlevel,
        createdby: req.body.createdby,
        createdon: req.body.createdon,
        phone: req.body.phone,
        email: req.body.email,
        usertype: req.body.usertype,
        usercenter: req.body.usercenter
    });

user.addUser(newuser, (err, user) => {

    if(err){
        console.log(err);
        res.json({success: false, msg:'Failed to register user'});
    } else {
        console.log('callback');
        res.json({success: true, msg:'User registered'});
}
});

});


//authenticate
router.post('/loginauth', (req, res, next) => {
    const user_name = req.body.user_name;
    const password = req.body.password;
    const centertype = req.body.centertype;

user.getUserByUsername(user_name,centertype, (err, users) => {
    if(err) throw  err;
if(!users){
    return res.json({success: false, msg: 'User not found'});
}

user.comparePassword(password, users.password, (err, isMatch) => {
    if(err) throw err;
if(isMatch){
    console.log('logdin');
    const token = jwt.sign(users.toJSON(), config.secret, {
        expiresIn: 604800 // 1 week
    });

    res.json({
        success: true,
        token: 'JWT '+token,
        user: {
            id: users._id,
            firstname: users.firstname,
            lastname: users.lastname,
            user_name: users.user_name,
            createdby: users.createdby,
            usertype: users.usertype,
            usercenter: users.usercenter
        }
    });

  /*  usr= {id: users._id,
    firstname: users.firstname,
        lastname: users.lastname,
        user_name: users.user_name,
        createdby: users.createdby,
        usertype: users.usertype,
        usercenter: users.usercenter}
        localstorage.setItem('myuser',JSON.stringify(usr));
*/

} else {
    return res.json({success: false, msg: 'Wrong password'});
}
});
});
});

// Profile
router.get('/profile', passport.authenticate('jwt', {session:false}), (req, res, next) => {
    res.json({user: req.user});
});



module.exports = router;