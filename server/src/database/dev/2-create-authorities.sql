BEGIN;

INSERT INTO user_role (user_id, sid, role) VALUES
    (1, '3f7e06822c0541e495078aed80afprot', 'ROLE_ADMIN'),
    (1, '3f7e06822c0541e495078aed80afekww', 'ROLE_USER'),
    (2, '3f7e06822c0541e495078aed80aflsll', 'ROLE_USER');

COMMIT;