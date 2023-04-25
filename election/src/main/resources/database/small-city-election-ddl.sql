DROP TABLE ELECTION CASCADE CONSTRAINTS;
DROP TABLE POLLING_LOCATION CASCADE CONSTRAINTS;
DROP TABLE VOTER CASCADE CONSTRAINTS;
DROP TABLE OFFICE CASCADE CONSTRAINTS;
DROP TABLE PREVIOUSLY_ELECTED  CASCADE CONSTRAINTS;
DROP TABLE POLL_WORKERS CASCADE CONSTRAINTS;
DROP TABLE CANDIDATES CASCADE CONSTRAINTS;
DROP TABLE VOTES CASCADE CONSTRAINTS;


CREATE TABLE ELECTION (
    election_id INTEGER,
    election_date DATE NOT NULL,
    
    CONSTRAINT election_pk
        PRIMARY KEY(election_id)
);

CREATE TABLE POLLING_LOCATION (
    poll_id INTEGER,
    poll_name VARCHAR(20),
    street VARCHAR(25) NOT NULL,
    city VARCHAR(25) NOT NULL,
    state VARCHAR(25) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    num_booths INTEGER,
    
    CONSTRAINT polling_loc_pk
        PRIMARY KEY(poll_id)
);

CREATE TABLE VOTER (
    ssn VARCHAR(9),
    fname VARCHAR(15) NOT NULL,
    minit VARCHAR(2) NOT NULL,
    lname VARCHAR(25) NOT NULL,
    dob DATE NOT NULL,
    street VARCHAR(25) NOT NULL,
    city VARCHAR(25) NOT NULL,
    state VARCHAR(25) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    poll_id INTEGER,
    
    CONSTRAINT voter_pk
        PRIMARY KEY(ssn),
    CONSTRAINT voter_poll_fk
        FOREIGN KEY(poll_id) REFERENCES POLLING_LOCATION(poll_id)
);

CREATE TABLE OFFICE (
    office_id INTEGER,
    office_name VARCHAR(50) NOT NULL,
    
    CONSTRAINT office_pk
        PRIMARY KEY(office_id)
);

CREATE TABLE PREVIOUSLY_ELECTED (
    election_id INTEGER,
    term_number INTEGER,
    ssn VARCHAR(9),
    office_id INTEGER,
    currently_in_office char(1) DEFAULT 'N' NOT NULL,
    
    CONSTRAINT prev_elected_pk
        PRIMARY KEY (election_id, ssn, office_id),
    CONSTRAINT prev_election_id_fk
        FOREIGN KEY (election_id) REFERENCES ELECTION(election_id),
    CONSTRAINT prev_ssn_fk
        FOREIGN KEY(ssn) REFERENCES VOTER(ssn),
    CONSTRAINT prev_office_id_fk
        FOREIGN KEY (office_id) REFERENCES OFFICE(office_id)
);

CREATE TABLE POLL_WORKERS (
    ssn VARCHAR(9),
    poll_id INTEGER NOT NULL,
    election_id INTEGER,
    
    CONSTRAINT poll_workers_pk
        PRIMARY KEY (ssn, election_id),
    CONSTRAINT worker_ssn_fk
        FOREIGN KEY (ssn) REFERENCES VOTER(ssn),
    CONSTRAINT worker_election_id_fk
        FOREIGN KEY (election_id) REFERENCES ELECTION(election_id)
);

CREATE TABLE CANDIDATES (
    candidate_id INTEGER,
    election_id INTEGER,
    ssn VARCHAR(9) NOT NULL,
    office_id INTEGER NOT NULL,
    
    CONSTRAINT candidate_pk
        PRIMARY KEY(candidate_id, election_id),
    CONSTRAINT candidate_election_id
        FOREIGN KEY(election_id) REFERENCES ELECTION(election_id),
    CONSTRAINT candidate_office_id
        FOREIGN KEY (office_id) REFERENCES OFFICE(office_id)
);

CREATE TABLE VOTES (
    candidate_id INTEGER,
    poll_id INTEGER,
    election_id INTEGER,
    
    CONSTRAINT votes_candidate_fk
        FOREIGN KEY(candidate_id, election_id) REFERENCES CANDIDATES(candidate_id, election_id),
    CONSTRAINT votes_poll_fk
        FOREIGN KEY(poll_id) REFERENCES POLLING_LOCATION(poll_id),
    CONSTRAINT votes_election_fk    
        FOREIGN KEY (election_id) REFERENCES ELECTION(election_id)
);
