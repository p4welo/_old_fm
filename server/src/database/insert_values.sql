USE fm;

INSERT INTO position VALUES
(1, 'BR', 'Bramkarz'),
(2, 'LB', 'Libero'),
(3, 'OL', 'Lewy obrońca'),
(4, 'OŚ', 'Środkowy obrońca'),
(5, 'OP', 'Prawy obrońca'),
(6, 'DPL', 'Lewy defensywny pomocnik'),
(7, 'DPŚ', 'Środkowy defensywny pomocnik'),
(8, 'DPP', 'Prawy defensywny pomocnik'),
(9, 'PL', 'Lewy pomocnik'),
(10, 'PŚ', 'Środkowy pomocnik'),
(11, 'PP', 'Prawy pomocnik'),
(12, 'OPL', 'Lewy skrzydłowy'),
(13, 'OPŚ', 'Środkowy ofensywny pomocnik'),
(14, 'OPP', 'Prawy skrzydłowy'),
(15, 'N', 'Napastnik');

INSERT INTO user (id, login, password, email) VALUES
    (1, 'root', '7a8f9ec1aa95662f89c3fc85c18127244aee5d0356dde194e5c58ba9f676d94c', 'root@mail.com'),
    (2, 'user', '7a8f9ec1aa95662f89c3fc85c18127244aee5d0356dde194e5c58ba9f676d94c', 'user@mail.com');

INSERT INTO user_role (user_id, role) VALUES
    (1, 'ROLE_ADMIN'),
    (1, 'ROLE_USER'),
    (2, 'ROLE_USER');