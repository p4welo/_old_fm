USE fm;

INSERT INTO position (id, sid, short_name, full_name) VALUES
(1, '123406822c0541e495078aed80af4b3b', 'BR', 'Bramkarz'),
(2, 'qwer06822c0541e495078aed80af4b3b', 'LB', 'Libero'),
(3, 'asdf06822c0541e495078aed80af4b3b', 'OL', 'Lewy obronca'),
(4, 'zxcv06822c0541e495078aed80af4b3b', 'OS', 'Srodkowy obronca'),
(5, 'ldks06822c0541e495078aed80af4b3b', 'OP', 'Prawy obronca'),
(6, 'pclv06822c0541e495078aed80af4b3b', 'DPL', 'Lewy defensywny pomocnik'),
(7, '85j606822c0541e495078aed80af4b3b', 'DPS', 'Srodkowy defensywny pomocnik'),
(8, '0d0006822c0541e495078aed80af4b3b', 'DPP', 'Prawy defensywny pomocnik'),
(9, '849306822c0541e495078aed80af4b3b', 'PL', 'Lewy pomocnik'),
(10, 'mbiv06822c0541e495078aed80af4b3b', 'PS', 'Srodkowy pomocnik'),
(11, 'iidk06822c0541e495078aed80af4b3b', 'PP', 'Prawy pomocnik'),
(12, 'pell06822c0541e495078aed80af4b3b', 'OPL', 'Lewy skrzydlowy'),
(13, '7c8806822c0541e495078aed80af4b3b', 'OPS', 'Srodkowy ofensywny pomocnik'),
(14, 'nbmv06822c0541e495078aed80af4b3b', 'OPP', 'Prawy skrzydlowy'),
(15, 'mxmm06822c0541e495078aed80af4b3b', 'N', 'Napastnik');

INSERT INTO user (id, sid, login, password, email) VALUES
    (1, '3f7e06822c0541e495078aed80af5521', 'root', '7a8f9ec1aa95662f89c3fc85c18127244aee5d0356dde194e5c58ba9f676d94c', 'root@mail.com'),
    (2, '3f7e06822c0541e495078aed80afkdlf', 'user', '7a8f9ec1aa95662f89c3fc85c18127244aee5d0356dde194e5c58ba9f676d94c', 'user@mail.com');

INSERT INTO user_role (user_id, sid, role) VALUES
    (1, '3f7e06822c0541e495078aed80afprot', 'ROLE_ADMIN'),
    (1, '3f7e06822c0541e495078aed80afekww', 'ROLE_USER'),
    (2, '3f7e06822c0541e495078aed80aflsll', 'ROLE_USER');