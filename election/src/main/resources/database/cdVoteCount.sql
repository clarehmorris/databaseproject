create or replace PROCEDURE cdVoteCount(candidateID in  integer) AS 
vote_count number;
BEGIN
 select count(*) into vote_count from votes v where v.candidate_id=candidateID;
 dbms_output.put_line('Number of votes: ' || vote_count);
END cdVoteCount;