BEGIN;

DROP TABLE match_game_team_relation;
DELETE FROM match_game;

ALTER TABLE match_game ADD COLUMN host_sid VARCHAR(32) NOT NULL;
ALTER TABLE match_game ADD COLUMN host_name VARCHAR(32) NOT NULL;
ALTER TABLE match_game ADD COLUMN guest_sid VARCHAR(32) NOT NULL;
ALTER TABLE match_game ADD COLUMN guest_name VARCHAR(32) NOT NULL;

COMMIT;