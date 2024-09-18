const bcrypt = require('bcrypt');

const db = require('../models/db_conf.js');

const saltRounds = 10;

module.exports.create = (firstname, surname, email, password) => {
    const hash = bcrypt.hashSync(password, saltRounds);

    const stmt = db.prepare("INSERT INTO users(firstname, surname, email, password, status) VALUES (?, ?, ?, ?, 'normal')");
    stmt.run(firstname, surname, email, hash);
};

module.exports.login = (email, password) => {
    const stmt = db.prepare('SELECT * FROM users WHERE email = ?');
    const user = stmt.get(email);
    if (!user) return null;

    if (!bcrypt.compareSync(password, user.password)) return null;
    return user;
};

module.exports.verifyUserSession = (email) => {
    console.log(email);
    return db.prepare('SELECT * FROM users WHERE email = ?').get(email);
};

module.exports.findById = (id) => {
    return db.prepare('SELECT * FROM users WHERE user_id = ?').get(id);
};

module.exports.findByEmail = (email) => {
    const result  = db.prepare('SELECT COUNT(*) AS count FROM users WHERE email = ?').get(email);
    return result.count;
};
