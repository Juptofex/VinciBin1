const db = require('../models/db_conf.js');

module.exports.list = () => {
    const stmt = db.prepare('SELECT * FROM tennis_courts ORDER BY name');
    return stmt.all();
};

module.exports.findById = (id) => {
    return db.prepare("SELECT * FROM tennis_courts WHERE tennis_court_id = ?").get(id);
};

module.exports.list2 = (userId) => {
    const stmt = db.prepare('SELECT  bo.date_booking, te.name, bo.tennis_court_id FROM bookings bo, tennis_courts te WHERE bo.tennis_court_id = te.tennis_court_id AND user_id = ? ORDER BY bo.date_booking');
    return stmt.all(userId);
};

module.exports.save = (dateCourtBooking,tennis_court_id,user_id) => {
    db.prepare('INSERT INTO bookings(date_booking,tennis_court_id,user_id) VALUES (?,?,?)').run(dateCourtBooking,tennis_court_id,user_id);
};

module.exports.delete = (courtBooking,courtId) => {
    db.prepare('DELETE FROM bookings WHERE date_booking = ? AND tennis_court_id = ?').run(courtBooking,courtId);
};

module.exports.save2 = (data) => {
    if(data.courtPic === null){
        db.prepare('UPDATE tennis_courts SET name = ?, flooring_type  = ?, location = ? WHERE tennis_court_id = ?').run(data.courtName,data.courtType,data.courtLocation,data.id);
    }
    else{
        db.prepare('UPDATE tennis_courts SET name = ?, flooring_type  = ?, location = ?, picture_path = ? WHERE tennis_court_id = ?').run(data.courtName,data.courtType,data.courtLocation,data.courtPic,data.id);
    }
    
};

module.exports.list3 = (dateCourtBooking,tennis_court_id) => {
    return db.prepare('SELECT bo.tennis_court_id FROM bookings bo WHERE bo.date_booking = ? AND bo.tennis_court_id = ?  ORDER BY bo.date_booking').get(dateCourtBooking,tennis_court_id);
};

module.exports.getCourtName = (courtName) => {
    return db.prepare("SELECT * FROM tennis_courts WHERE name = ?").get(courtName); 
};

module.exports.getCourtLocation = (courtLocation) => {
    return db.prepare("SELECT * FROM tennis_courts WHERE location = ?").get(courtLocation); 
};

