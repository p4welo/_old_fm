BEGIN;

INSERT INTO manager (sid, name, surname, team_id, user_id) VALUES ('3f7e06822c0541e495078aed80afkdlf', 'Jacek', 'Macaj', (SELECT id FROM team WHERE sid='8kvjjc822c0541e495078aed80a96s33'), (SELECT id FROM user WHERE login='user'));

COMMIT;