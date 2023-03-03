DROP table if exists workout;
drop table if exists exercise;

CREATE TABLE IF NOT EXISTS workout
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(255)                      NOT NULL,
    duration   INT                               NOT NULL,
    difficulty ENUM ('EASY', 'MODERATE', 'HARD') NOT NULL
);

CREATE TABLE IF NOT EXISTS exercise
(
    id              INTEGER PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(255)                                  NOT NULL,
    calories_burned INT                                           NOT NULL,
    muscle_group    ENUM ('ARMS', 'LEGS', 'CHEST', 'BACK', 'ABS') NOT NULL
);