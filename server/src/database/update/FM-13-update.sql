
ALTER TABLE player_stats ADD COLUMN player_name varchar(15) NOT NULL DEFAULT "imie";
ALTER TABLE player_stats ADD COLUMN player_surname varchar(40) NOT NULL DEFAULT "nazwisko";
ALTER TABLE player_stats ADD COLUMN team_sid VARCHAR(32) NOT NULL;