BEGIN;
ALTER TABLE team_record ADD round_number INT;
ALTER TABLE team_record ADD points_count INT;
ALTER TABLE team_record ADD goals_scored INT;
ALTER TABLE team_record ADD goals_allowed INT;
ALTER TABLE team_record ADD goals_difference INT;
ALTER TABLE team_record ADD wins_count INT;
ALTER TABLE team_record ADD draws_count INT;
ALTER TABLE team_record ADD loses_count INT;
COMMIT;