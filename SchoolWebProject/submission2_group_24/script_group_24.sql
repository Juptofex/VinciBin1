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