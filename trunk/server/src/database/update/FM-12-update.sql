BEGIN;

CREATE TABLE player_stats (
    id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	object_state VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    sid VARCHAR(32) NOT NULL,
    player_sid VARCHAR(32) NOT NULL,
    season_sid VARCHAR(32) NOT NULL,
    match_sid VARCHAR(32) NOT NULL,
    match_minute INT,
    date timestamp NOT NULL,
    type VARCHAR(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

COMMIT;