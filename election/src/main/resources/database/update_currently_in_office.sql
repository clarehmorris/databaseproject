CREATE OR REPLACE PROCEDURE update_currently_in_office AS
BEGIN
  UPDATE PREVIOUSLY_ELECTED
  SET currently_in_office = 'N'
  WHERE election_id=2;
END update_currently_in_office;