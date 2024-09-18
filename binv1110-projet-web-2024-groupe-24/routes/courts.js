const express = require('express');
const router = express.Router();

const Court = require("../models/Court.js");

const multer = require('multer');
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

router.get('/', function (req, res, next) {
    let updateTrue = false;
    if (req.session.user && req.session.user.status === 'coach') {
        console.log(req.session.user.status);
        console.log(req.session.user);
        updateTrue = true;
    };

    console.log(updateTrue);

    const courtsTable = Court.list();
    res.render('courts/index.hbs', { courtsTable, updateTrue });
});

router.get('/details', function (req, res, next) {
    console.log("Get details court");
    const courtNameParam = parseInt(req.query.id);
    const courtFound = Court.findById(courtNameParam);
    errors = [];
    const today = new Date();

    if (!courtFound) {
        errors.push({ msg: 'Ce terrain n existe pas' })
        res.render('courts/index.hbs', { errorss: errors })
    };



    const tomorrow = new Date(today);
    tomorrow.setDate(today.getDate() + 1);


    const bookingDates = [];
    for (let i = 0; i < 7; i++) {
        const date = new Date(tomorrow);
        date.setDate(tomorrow.getDate() + i);
        bookingDates.push(date.toLocaleDateString('fr-CA'));
    }

    res.render('courts/details.hbs', { court: courtFound, bookingDates: bookingDates, error: req.session.errorsBooking });
    req.session.errorsBooking = null;
});

router.post('/book', function (req, res, next) {
    console.log("POST ADD BOOKINGS");


    if (Court.list3(req.body.dateCourtBooking,req.body.tennis_court_id)) {
        console.log("court is busy");
        req.session.errorsBooking = true;
        res.redirect('/courts/details?id=' + req.body.tennis_court_id);
    }
    else {
        Court.save(req.body.dateCourtBooking, req.body.tennis_court_id, req.session.user.user_id);
        console.log(req.body.dateCourtBooking);
        res.redirect('/courts/bookings');
    };
});

router.get('/bookings', function (req, res, next) {
    if (req.session.user) {
        const courtsBookings = Court.list2(req.session.user.user_id);
        res.render('courts/bookings.hbs', { courtsBookings });
    }
    else {
        res.redirect('/courts');
    };

});

router.post('/unbook', (req, res, next) => {
    console.log("delete court id  " + req.body.courtId);
    Court.delete(req.body.courtBooking, req.body.courtId);
    res.redirect('/courts/bookings');
});

router.get('/update', function (req, res, next) {
    console.log("GET UPDATE COURT");
    errors = [];
    if (!req.session.user || req.session.user.status !== 'coach') {
        res.redirect('/courts/details?id=' + req.query.id);
    }


    const courtIdParam = parseInt(req.query.id);
    console.log(req.query.id);
    const courtFound = Court.findById(courtIdParam);

    if (!courtFound) {
        errors.push({ msg: 'Ce terrain n existe pas' })
        res.render('courts/index.hbs', { errorss: errors })
    };

    res.render('courts/update.hbs', { court: courtFound });


});


router.post('/update', upload.single('imageCourt'), function (req, res, next) {
    console.log("POST UPDATE COURT");
    errors = [];
    let filename = null;
    if (req.file === undefined) filename = null;
    else filename = '/images/' + req.file.filename;
    if (!Court.getCourtName(req.body.uniqueNameCourt) || !Court.getCourtLocation(req.body.uniqueLocationCourt)) {
        Court.save2({
            id: parseInt(req.body.tennis_court_id),
            courtName: req.body.uniqueNameCourt,
            courtType: req.body.courtFloorType,
            courtLocation: req.body.uniqueLocationCourt,
            courtPic: filename
        });
        res.redirect('/courts/details?id=' + req.body.tennis_court_id);
    }
    else {
        errors.push({ msg: 'Veuillez ne pas utiliser un nom ou un emplacement existants' })
        res.render('courts/update.hbs', { errorss: errors })
    }



});




module.exports = router;