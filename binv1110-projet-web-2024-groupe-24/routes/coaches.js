const express = require('express');
const router = express.Router();
const Coach = require('../models/Coach.js');


const multer = require ('multer');
const storage = multer.diskStorage({
destination: function (req, file, cb) {
cb(null, 'public/images');
},
filename: function (req, file, cb) {
const date = new Date();
const uniquePrefix = date.getFullYear() + '-' + (date.getMonth() + 1) +
'-' + date.getDate() + '-' + date.getHours() + '-' + date.getMinutes() +
44
'-' + date.getSeconds();
cb(null, uniquePrefix + '-' + file.originalname);
}
})


router.get('/',(req,res)=>{
    res.render('coaches/index.hbs', {coachList : Coach.list});
});

router.get('/biopage', (req, res) => {
    const coachId = req.query.coach;
    const coachDetails = Coach.findId2(coachId);
    otherErrors = [];

    if (!coachDetails) {
        otherErrors.push({msg : 'Vous ne pouvez pas choisir un utilisateur inexistant ou un utilisateur non coach.'})
        res.render('coaches/index.hbs', {errors: otherErrors})
    };

    let concordance = false; 
    if (req.session.user && req.session.user.user_id == coachId) {
        concordance = true;
    }

    console.log(coachDetails); 
    res.render('coaches/details.hbs', { coach: coachDetails, idCoach: coachId, concordance: concordance});
});

router.get('/update/:coachId', (req, res) => {
    if (!req.session.user || req.session.user.status !== 'coach') {
        res.redirect('/coaches');
    }

    const coachId = req.params.coachId;
    const coach = Coach.findId(coachId);

    const coachId2 = parseInt(coachId);
    const coach2 = Coach.findId(coachId2)
    console.log(coachId2);
    console.log(req.session.user.user_id);

    if (req.session.user.user_id !== coachId2) {
        return res.redirect('/coaches');
    }

    
    res.render('coaches/update', { coach: coach, idCoach : coachId, idCoach2: coachId2, coach2: coach2 });
});

router.post('/update/:coachId', (req, res) => {
    const coachId = req.params.coachId;
    let { biography, picture_path } = req.body;

    if (!picture_path) {
        const coach = Coach.findId(coachId);
        picture_path = coach.picture_path;
    } else { 
        if (picture_path[0] !== '/') {
            picture_path = '/images/' + picture_path;
        }
    }

    Coach.update(coachId, biography, picture_path);
    res.redirect(`/coaches/biopage?coach=${coachId}`); 
});


module.exports = router;