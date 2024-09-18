const express = require('express');
const router = express.Router();
const Tournament = require('../models/Tournament.js');

const multer = require ('multer');
const storage = multer.diskStorage({
destination: function (req, file, cb) {
cb(null, 'public/images');
},
filename: function (req, file, cb) {
const date = new Date();
const uniquePrefix = date.getFullYear() + '-' + (date.getMonth() + 1) +
'-' + date.getDate() + '-' + date.getHours() + '-' + date.getMinutes() +
'-' + date.getSeconds();
cb(null, uniquePrefix + '-' + file.originalname);
}
})
const upload = multer({ storage: storage });

const fs = require('fs');

let form_error="";

router.get('/', (req, res) => {
    const sorted_tournaments = Tournament.list();
    res.render('tournaments/index.hbs', {tournaments_list : sorted_tournaments});
});

router.get('/create', (req, res) => {
    const currentDate = new Date();
    const today = currentDate.getFullYear()+'-'+String(currentDate.getMonth()+1).padStart(2,'0')+'-'+String(currentDate.getDate()+1).padStart(2,'0');    
    if (req.session.user && req.session.user.status=='coach') {
        res.render('tournaments/creation.hbs', {today, form_error});
        form_error="";
    }
    else {
        res.redirect('/tournaments');
    }
});

router.post('/create', upload.single('tournamentPic'), (req, res) => {
    if(req.session.user) {
        if ((req.body.name!=="") && (req.body.date!=null) && (new Date(req.body.date) > new Date()) && (req.body.maxPart!="") && (req.body.maxPart > 0) && (req.file!=undefined)) {
            if (Tournament.exists(req.body.name)){
                Tournament.create(req.body.name, req.session.user.user_id, req.body.date, '/images/'+req.file.filename, req.body.maxPart);
                res.redirect('/tournaments'); 
            }
            else {
                const path = `./public/images/${req.file.filename}`;
                console.log(path);
                fs.unlink(path, (err) => {
                    if (err) {
                    console.error('Error deleting file:', err);
                    return;
                    }
                    
                });
                form_error="Il est impossible de créer un tournois portant le même nom qu'un tournois existant";
                res.redirect('/tournaments/create');
            }
        }
        else {
            const path = `./public/images/${req.file.filename}`;
            console.log(path);
            fs.unlink(path, (err) => {
                if (err) {
                  console.error('Error deleting file:', err);
                  return;
                }
                console.log('File deleted successfully');
              });
            form_error="Veuillez compléter tout les champs du formulaire.";
            res.redirect('/tournaments/create');
    }}
    else {
        res.redirect('/tournaments/create');
    }
});

router.get('/details', (req, res) => {
    const details_id = Tournament.findById(req.query.id);
    if(details_id!=undefined) {
        const current_participant_amount = Tournament.registrationCount(req.query.id);
        const tournament_participant_ok = current_participant_amount < details_id.nb_max_participants;
        let registered;
        let not_too_old;
        if (new Date(details_id.date_tournament) > new Date()) {
            not_too_old = true;
        }
        else {
            not_too_old = false;
        }
        if (req.session.user) {
            registered = Tournament.checkRegistered(req.query.id, req.session.user.user_id);
        }
        res.render('tournaments/details.hbs', {details: details_id, registered, tournament_participant_ok, not_too_old, current_participant_amount});
    }
    else {
        message = 'Aucun tournois correspondant';
        const error = { status: 404 };
        res.render('error.hbs', {message, error})
    }
});

router.post('/register', (req, res) => {
    if (req.session.user){
        const details_id = Tournament.findById(req.query.id);
        if(details_id!=undefined) {
            if(new Date(details_id.date_tournament)> new Date()) {
                if(!Tournament.checkRegistered(req.query.id, req.session.user.user_id).count) {
                    if(Tournament.registrationCount(req.query.id) < details_id.nb_max_participants) {
                        Tournament.register(req.session.user.user_id, req.query.id);
    }}}}}
    res.redirect('/tournaments/details?id='+req.query.id);
});

router.post('/unregister', (req, res) => {
    if (req.session.user){
        const details_id = Tournament.findById(req.query.id);
        if(details_id!=undefined) {
            if(new Date(details_id.date_tournament)> new Date()) {
                if(Tournament.checkRegistered(req.query.id, req.session.user.user_id).count) {
                        Tournament.unregister(req.session.user.user_id, req.query.id);
    }}}}
    res.redirect('/tournaments/details?id='+req.query.id);
});

module.exports = router;