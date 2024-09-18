const db = require('./db_conf.js');

module.exports.getMessagesForUser = (userId) => {
    const stmt = db.prepare(`SELECT m.*, u.firstname, u.surname FROM messages m, users u WHERE m.receiver_id = u.user_id AND m.sender_id = ? ORDER BY strftime('%Y-%m-%d %H:%M:%S', m.date_hour_message) DESC`);
    return stmt.all(userId);
};

module.exports.getUnrepliedMessagesForCoach = (coachId) => {
    const stmt = db.prepare(`SELECT m.*, u.firstname, u.surname FROM messages m, users u WHERE m.sender_id = u.user_id AND m.receiver_id = ? AND m.response_text IS NULL ORDER BY strftime('%Y-%m-%d %H:%M:%S', m.date_hour_message) DESC`);
    return stmt.all(coachId);
};

module.exports.sendMessageToCoach = (userId, coachId, messageText) => {
    const date = new Date().toISOString().slice(0, 19).replace('T', ' '); 
    const stmt = db.prepare('INSERT INTO messages (sender_id, receiver_id, message_text, date_hour_message) VALUES (?, ?, ?, ?)');
    stmt.run(userId, coachId, messageText, date);
};

module.exports.sendReply = (messageId, replyText) => {
    const stmt = db.prepare('UPDATE messages SET response_text = ? WHERE message_id = ?');
    stmt.run(replyText, messageId);
};

