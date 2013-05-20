BEGIN;

-- EKSTRAKLASA
INSERT INTO team (sid, name, account, league_id, type) VALUES ('kkvjjc822c05z1e495078aed80a96s33', 'Tur Turze Rogi', 5000, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('qkvjjc822c05x1e495078aed80a96s33', 'Tytan Wisznice', 1100, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('1kvjjc822c05c1e495078aed80a96s33', 'Ruch Ryki', 3200, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('2kvjjc822c05v1e495078aed80a96s33', 'Absolwent Domaszewnica', 4000, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('3kvjjc822c05b1e495078aed80a96s33', 'Leszkopol Bezek', 76600, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('4kvjjc822c05n1e495078aed80a96s33', 'Sparta Babunie', 4000, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('5kvjjc822c05m1e495078aed80a96s33', 'Drako Kowala', 5400, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('6kvjjc822c05h1e495078aed80a96s33', 'Sygnal Chodak', 670, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('7kvjjc822c05g1e495078aed80a96s33', 'Relax Radecznica', 12000, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('8kvjjc822c05f1e495078aed80a96s33', 'Fortuna Wyry', 700, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('9kvjjc822c05d1e495078aed80a96s33', 'Grom Cykarzew', 900, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('fkvjjc822c05s1e495078aed80a96s33', 'Kmicic Kruszyna', 1100, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('hkvjjc822c05a1e495078aed80a96s33', 'Vineta Wolin', 1200, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('jkvjjc822c05q1e495078aed80a96s33', 'Ogniwo Babinek', 3500, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('jkvjjc822c05q1e49507xbed80a96s33', 'Odra Wodzislaw', 3500, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('jkvjjc822c05q1e4950awerd80a96s33', 'GKS Wisielec', 3500, (SELECT id FROM league WHERE name = 'Ekstraklasa'), 'CPU');

-- 1 LIGA
INSERT INTO team (sid, name, account, league_id, type) VALUES ('qkvjjc822c0t41e490278aed80a96s33', 'Tytan Wisznice', 1100, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('1kvjjc822c0g41e490738aed80a96s33', 'Ruch Ryki', 3200, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('2kvjjc822c0f41e490784aed80a96s33', 'Absolwent Domaszewnica', 4000, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('3kvjjc822c0d41e49078a5ed80a96s33', 'Leszkopol Bezek', 76600, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('4kvjjc822c0s41e49078ae6d80a96s33', 'Sparta Babunie', 4000, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('5kvjjc822c0a41e49078ae7d80a96s33', 'Drako Kowala', 5400, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('6kvjjc822c0z41e49078ae8d80a96s33', 'Sygnal Chodak', 670, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('7kvjjc822c0x41e49078ae9d80a96s33', 'Relax Radecznica', 12000, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('8kvjjc822c0c41e49078ae0d80a96s33', 'Fortuna Wyry', 700, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('9kvjjc822c0v41e49078aefd80a96s33', 'Grom Cykarzew', 900, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('fkvjjc822c0b41e49078aezd80a96s33', 'Kmicic Kruszyna', 1100, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('hkvjjc822c0n41e49078aesd80a96s33', 'Vineta Wolin', 1200, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('jkvjjc822c0m41e49078aead80a96s33', 'Ogniwo Babinek', 3500, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('ykvjjc822c0h41e49078aewd80a96s33', 'GKS Wisielec', 400, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('ykvjjc822c0h41e49s78aewd80a96s33', 'GKS Katowice', 400, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');
INSERT INTO team (sid, name, account, league_id, type) VALUES ('ykvjjc822c0h41e49078aewd80a9zs33', 'Odra Wodzislaw', 400, (SELECT id FROM league WHERE name = 'I liga'), 'CPU');

COMMIT;