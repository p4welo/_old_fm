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

COMMIT;