const express = require('express');
const router = express.Router();
const Index = require('../models/Index.js');

router.get('/', (req, res) => {
    res.render('index.hbs', {nb_upcoming_tournaments: Index.tournamentcount(), nb_upcoming_courtBookings: Index.courtBooking(), nb_messages_lastWeek: Index.lastWeekMessageCount()});
});

module.exports = router;