BEGIN;

DROP TABLE match_game_team_relation;
DELETE FROM match_game;

ALTER TABLE match_game ADD COLUMN host_sid VARCHAR(32) NOT NULL;
ALTER TABLE match_game ADD COLUMN host_name VARCHAR(32) NOT NULL;
ALTER TABLE match_game ADD COLUMN guest_sid VARCHAR(32) NOT NULL;
ALTER TABLE match_game ADD COLUMN guest_name VARCHAR(32) NOT NULL;

ALTER TABLE player ADD COLUMN team_sid VARCHAR(32);
ALTER TABLE player DROP COLUMN team_id;

ALTER TABLE team_record ADD COLUMN team_sid VARCHAR(32);
ALTER TABLE team_record DROP COLUMN team_id;

COMMIT;