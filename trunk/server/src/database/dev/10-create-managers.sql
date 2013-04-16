BEGIN;

INSERT INTO manager (sid, name, surname, team_id, user_id) VALUES ('3f7e06822c0541e495078aed80afkdlf', 'Włodzimierz', 'Górski', null, (SELECT id FROM user WHERE login='user'));

COMMIT;