BEGIN;

CREATE TABLE position_area (
    id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sid VARCHAR(32) NOT NULL,
    area INT(5),
    position_id int(11) NOT NULL,
    FOREIGN KEY (position_id) REFERENCES position (id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

COMMIT;