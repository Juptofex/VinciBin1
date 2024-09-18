const express = require('express');
const router = express.Router();

const User = require('../models/User.js');
const validator = require ('validator');

router.get('/login', (req, res) => {
    if(req.session.user) {
        res.redirect("/")
    }
    else {
        res.render('users/login.hbs', { error: req.session.error });
        req.session.error = null;
    }
});

router.post('/login', (req, res) => {
    const user = User.login(req.body.email, req.body.password);
    if (user) {
        req.session.user = user;
        res.redirect('/');
    } else {
        req.session.error = 'Email ou mot de passe invalide';
        res.redirect('/users/login');
    }
});

router.get('/create', (req, res) => {
    res.render('users/create.hbs', {errors: req.session.errors});
    req.session.errors=null;
});

router.post('/create', (req, res) => {
    req.session.errors=[];
    if  (req.body.firstname==="") {
        req.session.errors.push("Le prénom est absent.");
    }
    if  (req.body.surname==="") {
        req.session.errors.push("Le nom est absent.");
    }
    if (!validator.isEmail(req.body.email)) {
        req.session.errors.push("L'email doit être un email correct.");
    }
    if (!req.body.email.endsWith('vinci.be')) {
        req.session.errors.push("L'email doit dois correspondre à une adresse email du type 'vinci.be'.");
    }
    if (User.findByEmail(req.body.email)) {
        req.session.errors.push("L'adresse email utilisée correspond déjà à un autre compte.")
    }
    if (!validator.isStrongPassword(req.body.password, {minLength: 8, minLowercase: 1, minUppercase: 1, minNumbers: 1, minSymbols: 0})) {
        req.session.errors.push("Le mot de passe doit comporter au moins 8 caractères, une minuscule, une majuscule et un chiffre.");
    }
    if (!validator.equals(req.body.password, req.body.password_conf)) {
        req.session.errors.push("Les deux mots de passes doivent être identiques.");
    }
    if (req.session.errors.length !== 0) {
        res.redirect('/users/create');
    }
    else {
        User.create(req.body.firstname, req.body.surname, req.body.email, req.body.password);
        res.redirect('/users/login');
    }
});

router.get('/logout', (req, res) => {
    req.session.destroy();
    res.redirect('/');
});

module.exports = router;