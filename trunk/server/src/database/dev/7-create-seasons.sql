BEGIN;

INSERT INTO season (sid, number, league_id) VALUES ('885jjc822c0541e495078aed80a96s33', 1, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO season (sid, number, league_id) VALUES ('885jjc82cmv541e495078aed80a96s33', 1, (SELECT id FROM league WHERE name = 'I liga'));

COMMIT;