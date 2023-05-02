create or replace PROCEDURE update_currently_in_office(electionId in  integer) AS
BEGIN
  UPDATE PREVIOUSLY_ELECTED
  SET currently_in_office = 'N'
  WHERE election_id=electionId;
END update_currently_in_office;