const db = require('../models/db_conf.js');

module.exports.tournamentcount = () => {
    const result = db.prepare('SELECT COUNT(*) AS count FROM tournaments WHERE date_tournament > CURRENT_DATE').get();
    return result.count;
};

module.exports.courtBooking = () => {
    const result = db.prepare('SELECT COUNT(*) AS count FROM bookings WHERE date_booking > CURRENT_DATE').get();
    return result.count;
};

module.exports.lastWeekMessageCount = () => {
    const result = db.prepare("SELECT COUNT(*) AS count FROM messages WHERE date_hour_message >= datetime('now', '-7 days')").get();
    return result.count;
};