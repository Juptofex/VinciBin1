const express = require('express');
const router = express.Router();
const Messages = require('../models/Message.js');

router.get('/', (req, res) => {
    if (!req.session.user) {
        res.redirect('/coaches');
    }

    if (req.session.user.status === 'normal') {
        const messages = Messages.getMessagesForUser(req.session.user.user_id);
        res.render('messages/index.hbs', { messages });
    } else if (req.session.user.status === 'coach') {
        const messages = Messages.getUnrepliedMessagesForCoach(req.session.user.user_id);
        res.render('messages/coach.hbs', { messages });
    }
});

router.post('/reply/:id', (req, res) => {
    if (req.session.user && req.session.user.status === 'coach') {
        Messages.sendReply(req.params.id, req.body.reply);
    }
    res.redirect('/messages');
});

router.post('/sendToCoach/:coachId', (req, res) => {
    const userId = req.session.user.user_id;
    const coachId = req.params.coachId;
    const messageText = req.body.message;
    
    Messages.sendMessageToCoach(userId, coachId, messageText);
    res.redirect('/messages'); 
});

module.exports = router;