BEGIN;

INSERT INTO position_area (sid, area, position_id) VALUES ('123406jdkkk541e495078aed80af4b3b', 0, (SELECT id from position where short_name='BR'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80af4b3b', 1, (SELECT id from position where short_name='LB'));
INSERT INTO position_area (sid, area, position_id) VALUES ('7454lopl2c0541e495078aed80af4b3b', 2, (SELECT id from position where short_name='LB'));
INSERT INTO position_area (sid, area, position_id) VALUES ('kcm4lopl2c0541e495078aed80af4b3b', 3, (SELECT id from position where short_name='LB'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80afYHNM', 4, (SELECT id from position where short_name='OS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('7454lopl2c0541e495078aedldfv4b3b', 5, (SELECT id from position where short_name='OS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('kcm4lopl2c0541e495078aed7ujm4b3b', 6, (SELECT id from position where short_name='OS'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80af4b3n', 7, (SELECT id from position where short_name='OL'));
INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078alok0af4b3n', 8, (SELECT id from position where short_name='OP'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80afYHNM', 9, (SELECT id from position where short_name='DPS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('7454lopl2c0541e495078aedldfv4b3b', 10, (SELECT id from position where short_name='DPS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('kcm4lopl2c0541e495078aed7ujm4b3b', 11, (SELECT id from position where short_name='DPS'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80af4b3n', 12, (SELECT id from position where short_name='DPL'));
INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078alok0af4b3n', 13, (SELECT id from position where short_name='DPP'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80afYHNM', 14, (SELECT id from position where short_name='PS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('7454lopl2c0541e495078aedldfv4b3b', 15, (SELECT id from position where short_name='PS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('kcm4lopl2c0541e495078aed7ujm4b3b', 16, (SELECT id from position where short_name='PS'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80af4b3n', 17, (SELECT id from position where short_name='PL'));
INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078alok0af4b3n', 18, (SELECT id from position where short_name='PP'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80afYHNM', 19, (SELECT id from position where short_name='OPS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('7454lopl2c0541e495078aedldfv4b3b', 20, (SELECT id from position where short_name='OPS'));
INSERT INTO position_area (sid, area, position_id) VALUES ('kcm4lopl2c0541e495078aed7ujm4b3b', 21, (SELECT id from position where short_name='OPS'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078aed80af4b3n', 22, (SELECT id from position where short_name='OPL'));
INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078alok0af4b3n', 23, (SELECT id from position where short_name='OPP'));

INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078alok0af4b3n', 24, (SELECT id from position where short_name='N'));
INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078alok0af4b3n', 25, (SELECT id from position where short_name='N'));
INSERT INTO position_area (sid, area, position_id) VALUES ('1234lopl2c0541e495078alok0af4b3n', 26, (SELECT id from position where short_name='N'));

COMMIT;