CREATE TABLE users
(
    id_user      INTEGER PRIMARY KEY AUTOINCREMENT,
    firstname    VARCHAR(100) NOT NULL,
    surname      VARCHAR(100) NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    password     VARCHAR(100) NOT NULL,
    status       CHAR(1)      NOT NULL CHECK (status IN ('u', 'c')),
    picture_name VARCHAR(100),
    bio          TEXT
);

CREATE TABLE courts
(
    id_court      INTEGER PRIMARY KEY AUTOINCREMENT,
    name          VARCHAR(100) NOT NULL UNIQUE,
    location      VARCHAR(100) NOT NULL UNIQUE,
    flooring_type VARCHAR(10)  NOT NULL CHECK ( flooring_type IN ('grass', 'clay', 'artificial')),
    picture       VARCHAR(100) NOT NULL
);

CREATE TABLE tournaments
(
    id_tournament          INTEGER PRIMARY KEY AUTOINCREMENT,
    unique_name            VARCHAR(100) NOT NULL UNIQUE,
    tournament_date        DATE         NOT NULL,
    coach                  INTEGER      NOT NULL REFERENCES users (id_user),
    banner                 VARCHAR(100) NOT NULL,
    current_nb_participant INTEGER      NOT NULL,
    max_nb_participant     INTEGER      NOT NULL
);

CREATE TABLE registration_tournaments
(
    id_registration INTEGER PRIMARY KEY AUTOINCREMENT,
    user            INTEGER NOT NULL REFERENCES users (id_user),
    tournament      INTEGER NOT NULL REFERENCES tournaments (id_tournament)
);

CREATE TABLE bookings
(
    id_booking       INTEGER PRIMARY KEY AUTOINCREMENT,
    id_court         INTEGER  NOT NULL REFERENCES courts (id_court),
    id_user          INTEGER  NOT NULL REFERENCES users (id_user),
    date_reservation DATETIME NOT NULL
);

CREATE TABLE messages
(
    id_message   INTEGER PRIMARY KEY AUTOINCREMENT,
    text         VARCHAR(250) NOT NULL,
    id_user      INTEGER      NOT NULL REFERENCES users (id_user),
    id_coach     INTEGER      NOT NULL REFERENCES users (id_user),
    message_date DATE         NOT NULL,
    response     VARCHAR(250)
);

INSERT INTO users (firstname, surname, email, password, status, picture_name, bio) VALUES ('John', 'Doe', 'john.doe@gmail.be', 'password', 'u', 'john_doe.jpg', 'I am a tennis player');

INSERT INTO courts (name, location, flooring_type, picture) VALUES ('Court 1', 'Brussels', 'grass', 'court1.jpg');

INSERT INTO tournaments (unique_name, tournament_date, coach, banner, current_nb_participant, max_nb_participant) VALUES ('Tournament 1', '2021-12-01', 1, 'tournament1.jpg', 0, 16);

INSERT INTO registration_tournaments (user, tournament) VALUES (1, 1);

INSERT INTO bookings (id_court, id_user, date_reservation) VALUES (1, 1, '2021-12-01 10:00:00');

INSERT INTO messages (text, id_user, id_coach, message_date, response) VALUES ('Hello', 1, 1, '2021-12-01', 'Hi');

SELECT * FROM registration_tournaments WHERE user NOT IN (SELECT id_user FROM users) OR tournament NOT IN (SELECT id_tournament FROM tournaments);

INSERT INTO registration_tournaments (user, tournament) VALUES (1, 5);
