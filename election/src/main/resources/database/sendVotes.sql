-- see which poll is getting the most votes

create or replace procedure sendVotes(elecDate in varchar, fnam in varchar, lnam in varchar, poll_nam in varchar)
is
    elect_id integer;
    poll_id integer;
    c_id integer;
    -- cursor to fetch distinct office_ids from candidates
    
begin

    -- get the correct election_id, poll_id, and c_id
    select election_id into elect_id from ELECTION where election_date=TO_DATE(elecDate,'mmddyyyy');
    select poll_id into poll_id from POLLING_LOCATION p where p.poll_name=poll_nam;
    select candidate_id into c_id from CANDIDATES c where c.election_id = elect_id and c.ssn=
                                            (SELECT ssn from VOTER v WHERE v.fname=fnam and v.lname=lnam); 
--    dbms_output.put_line(c_id);
    
    -- fire the vote
    INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(c_id, poll_id, elect_id);

end;