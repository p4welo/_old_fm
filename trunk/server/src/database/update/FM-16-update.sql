BEGIN;
CREATE TABLE user_log_history (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	object_state VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    sid VARCHAR(32) NOT NULL,
    user_sid VARCHAR(32),
    login varchar(15) NOT NULL,
    date timestamp NOT NULL,
    ip VARCHAR(15),
    success BOOLEAN NOT NULL,
    UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE player CHANGE speed speed FLOAT;
ALTER TABLE player CHANGE stamina stamina FLOAT;
ALTER TABLE player CHANGE crossing crossing FLOAT;
ALTER TABLE player CHANGE passing passing FLOAT;
ALTER TABLE player CHANGE heading heading FLOAT;
ALTER TABLE player CHANGE marking marking FLOAT;
ALTER TABLE player CHANGE shots shots FLOAT;
ALTER TABLE player CHANGE tackling tackling FLOAT;
ALTER TABLE player CHANGE dribbling dribbling FLOAT;
ALTER TABLE player CHANGE goalkeeping goalkeeping FLOAT;

CREATE TABLE player_rating (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	object_state VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    sid VARCHAR(32) NOT NULL,
    player_sid VARCHAR(32) NOT NULL,
    match_sid VARCHAR(32) NOT NULL,
    season_sid VARCHAR(32) NOT NULL,
    creation_date timestamp NOT NULL,
    rating float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE match_game ADD COLUMN status VARCHAR(32) NOT NULL DEFAULT 'FINISHED';

CREATE TABLE team_stats (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	object_state VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    sid VARCHAR(32) NOT NULL,
    manager_sid VARCHAR(32),
    season_sid VARCHAR(32) NOT NULL,
    match_sid VARCHAR(32),
    team_sid VARCHAR(32) NOT NULL,
    creation_date timestamp NOT NULL,
    type VARCHAR(32) NOT NULL,
    UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

COMMIT;