BEGIN;

-- EKSTRAKLASA
INSERT INTO team (sid, name, account, league_id) VALUES ('kkvjjc822c0541e495078aed80a96s33', 'Tur Turze Rogi', 5000, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('qkvjjc822c0541e495078aed80a96s33', 'Tytan Wisznice', 1100, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('1kvjjc822c0541e495078aed80a96s33', 'Ruch Ryki', 3200, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('2kvjjc822c0541e495078aed80a96s33', 'Absolwent Domaszewnica', 4000, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('3kvjjc822c0541e495078aed80a96s33', 'Leszkopol Bezek', 76600, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('4kvjjc822c0541e495078aed80a96s33', 'Sparta Babunie', 4000, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('5kvjjc822c0541e495078aed80a96s33', 'Drako Kowala', 5400, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('6kvjjc822c0541e495078aed80a96s33', 'Sygnał Chodak', 670, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('7kvjjc822c0541e495078aed80a96s33', 'Relax Radecznica', 12000, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('8kvjjc822c0541e495078aed80a96s33', 'Fortuna Wyry', 700, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('9kvjjc822c0541e495078aed80a96s33', 'Grom Cykarzew', 900, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('fkvjjc822c0541e495078aed80a96s33', 'Kmicic Kruszyna', 1100, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('hkvjjc822c0541e495078aed80a96s33', 'Vineta Wolin', 1200, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('jkvjjc822c0541e495078aed80a96s33', 'Ogniwo Babinek', 3500, (SELECT id FROM league WHERE name = 'Ekstraklasa'));
INSERT INTO team (sid, name, account, league_id) VALUES ('ykvjjc822c0541e495078aed80a96s33', 'GKS Wisielec', 400, (SELECT id FROM league WHERE name = 'Ekstraklasa'));

-- 1 LIGA
INSERT INTO team (sid, name, account, league_id) VALUES ('kkvjjc822c0541e491078aed80a96s33', 'Tur Turze Rogi', 5000, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('qkvjjc822c0541e490278aed80a96s33', 'Tytan Wisznice', 1100, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('1kvjjc822c0541e490738aed80a96s33', 'Ruch Ryki', 3200, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('2kvjjc822c0541e490784aed80a96s33', 'Absolwent Domaszewnica', 4000, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('3kvjjc822c0541e49078a5ed80a96s33', 'Leszkopol Bezek', 76600, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('4kvjjc822c0541e49078ae6d80a96s33', 'Sparta Babunie', 4000, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('5kvjjc822c0541e49078ae7d80a96s33', 'Drako Kowala', 5400, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('6kvjjc822c0541e49078ae8d80a96s33', 'Sygnał Chodak', 670, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('7kvjjc822c0541e49078ae9d80a96s33', 'Relax Radecznica', 12000, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('8kvjjc822c0541e49078ae0d80a96s33', 'Fortuna Wyry', 700, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('9kvjjc822c0541e49078aefd80a96s33', 'Grom Cykarzew', 900, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('fkvjjc822c0541e49078aezd80a96s33', 'Kmicic Kruszyna', 1100, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('hkvjjc822c0541e49078aesd80a96s33', 'Vineta Wolin', 1200, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('jkvjjc822c0541e49078aead80a96s33', 'Ogniwo Babinek', 3500, (SELECT id FROM league WHERE name = 'I liga'));
INSERT INTO team (sid, name, account, league_id) VALUES ('ykvjjc822c0541e49078aewd80a96s33', 'GKS Wisielec', 400, (SELECT id FROM league WHERE name = 'I liga'));

COMMIT;