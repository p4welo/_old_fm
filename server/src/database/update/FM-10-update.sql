CREATE TABLE league (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	object_state VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
	sid VARCHAR(32) NOT NULL,
	name VARCHAR(15) NOT NULL,
	level INT(11) NOT NULL,
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE team (
	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	object_state VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
	sid VARCHAR(32) NOT NULL,
	name VARCHAR(30) NOT NULL,
	account INT(11) NOT NULL,
	league_id INT(11) DEFAULT NULL,
	type VARCHAR(30) NOT NULL,
	FOREIGN KEY (league_id) REFERENCES league(id) ON DELETE SET NULL,
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE position (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	object_state VARCHAR(30) NOT NULL DEFAULT 'ACTIVE',
    sid VARCHAR(32) NOT NULL,
    short_name varchar(5) NOT NULL,
    full_name varchar(30) NOT NULL,
	UNIQUE (sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE system_parameter ADD UNIQUE (sid);
ALTER TABLE position_area ADD UNIQUE (sid);
ALTER TABLE surname ADD UNIQUE (sid);
ALTER TABLE name ADD UNIQUE (sid);
ALTER TABLE match_story ADD UNIQUE (sid);
ALTER TABLE match_game_team_relation ADD UNIQUE (sid);
ALTER TABLE match_game ADD UNIQUE (sid);
ALTER TABLE team_record ADD UNIQUE (sid);
ALTER TABLE season ADD UNIQUE (sid);
ALTER TABLE authority ADD UNIQUE (sid);
ALTER TABLE manager ADD UNIQUE (sid);
ALTER TABLE user ADD UNIQUE (sid);
ALTER TABLE player ADD UNIQUE (sid);
ALTER TABLE position ADD UNIQUE (sid);
ALTER TABLE team ADD UNIQUE (sid);
ALTER TABLE league ADD UNIQUE (sid);