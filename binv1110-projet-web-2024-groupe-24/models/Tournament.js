const db = require('../models/db_conf.js');

module.exports.list = () => {
    return db.prepare('SELECT * FROM tournaments WHERE date_tournament > CURRENT_DATE ORDER BY date_tournament').all();
};

module.exports.findCoachName = (id) => {
    return db.prepare('SELECT firstname, surname FROM users WHERE user_id = ?').get(id);
};

module.exports.findById = (id) => {
    return db.prepare('SELECT * FROM tournaments WHERE tournament_id = ?').get(id);
};

module.exports.create = (name, creator, date, tournamentPic, maxPart) => {
    db.prepare('INSERT INTO tournaments(name, creator, date_tournament, banner_image_path, nb_max_participants) VALUES (?, ?, ?, ?, ?)').run(name, creator, date, tournamentPic, maxPart);
};

module.exports.registrationCount = (id) => {
    const result = db.prepare('SELECT COUNT(*) AS count FROM registrations WHERE tournament_id = ?').get(id);
    return result.count;
};

module.exports.checkRegistered = (tournament_id, user_id) => {
    return db.prepare('SELECT COUNT(*) AS count FROM registrations WHERE tournament_id = ? AND user_id = ?').get(tournament_id, user_id);
};

module.exports.register = (user_id, tournament_id) => {
    db.prepare('INSERT INTO registrations(user_id, tournament_id) VALUES (?, ?)').run(user_id, tournament_id);
};

module.exports.unregister = (user_id, tournament_id) => {
    db.prepare('DELETE FROM registrations WHERE user_id = ? AND tournament_id = ?').run(user_id, tournament_id);
};

module.exports.exists = (name) => {
    const result = db.prepare('SELECT COUNT(*) AS count FROM tournaments WHERE name = ?');
    return result.count;
};