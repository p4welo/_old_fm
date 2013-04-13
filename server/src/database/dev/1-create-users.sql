BEGIN;

INSERT INTO user (id, sid, login, password, email) VALUES (1, '3f7e06822c0541e495078aed80af5521', 'root', '7a8f9ec1aa95662f89c3fc85c18127244aee5d0356dde194e5c58ba9f676d94c', 'root@mail.com');
INSERT INTO user (id, sid, login, password, email) VALUES (2, '3f7e06822c0541e495078aed80afkdlf', 'user', '7a8f9ec1aa95662f89c3fc85c18127244aee5d0356dde194e5c58ba9f676d94c', 'user@mail.com');

COMMIT;