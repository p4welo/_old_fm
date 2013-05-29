BEGIN;

INSERT INTO user (id, sid, login, password, email, object_state) VALUES (1, '3f7e06822c0541e495078aed80af5521', 'root', '7a8f9ec1aa95662f89c3fc85c18127244aee5d0356dde194e5c58ba9f676d94c', 'root@mail.com', 'ACTIVE');
INSERT INTO user (id, sid, login, password, email, object_state) VALUES (2, '3f7e06822c0541e495078aed80afkdlf', 'user', 'f3c562c0df91cb247aebe9c62eeb27a93a7ab3585861260b5240afe853ecd788', 'user@mail.com', 'ACTIVE');

COMMIT;