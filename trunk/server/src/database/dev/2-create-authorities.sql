BEGIN;

DELETE FROM authority;
INSERT INTO authority (user_id, sid, authority) VALUES
    (1, '3f7e06822c0541e495078aed80afprot', 'ROLE_ADMIN'),
    (2, '3f7e06822c0541e495078aed80aflsll', 'ROLE_USER');

COMMIT;