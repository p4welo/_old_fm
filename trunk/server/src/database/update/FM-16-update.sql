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
COMMIT;