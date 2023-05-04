# databaseproject
Uncle Sam's Dream Team's database project

To Use:
Connect to Villanova VPN (or be on Villanova's WiFi network)

In command line, navigate to the election folder
Use the command ./gradlew bootRun to run a local host server

To use the APIs in Postman, the base url is http://localhost:8080/ 

To use the APIS from your web browser, go to the website: http://localhost:8080/swagger-ui/index.html#/

# SCHEMA REQUIREMENTS

1. The database should store information about elections, including a unique ID for each election and the date on which it was held.

2. The database should store information about polling locations, including a unique ID for each location, the name of the location, its street address, city, state, and zip code, and the number of voting booths available at the location.

3. The database should store information about voters, including their Social Security number, first name, middle initial, last name, date of birth, street address, city, state, and zip code. Each voter should also be associated with a polling location.

4. The database should store information about offices that candidates can run for, including a unique ID for each office and the name of the office.

5. The database should store information about candidates, including a unique ID for each candidate, the election in which they are running, their Social Security number, and the office they are running for.

6. The database should store information about which candidates received votes in which polling locations during which elections.

7. The database should store information about which voters worked at which polling locations during which elections.

8. The database should generate a unique ID for each vote record that is inserted into the Votes table using a sequence and a trigger.

# PROCEDURE USER STORIES

1. As a system administrator, I want to update the "currently_in_office" field for all previously elected candidates who participated in the election with the ID of 2, so that their status is set to "N" and their term in office is marked as completed.

2. As an election administrator, I want to be able to see the number of votes for a specific candidate, so that I can determine their current standing in the election. A stored procedure cdVoteCount should be created that takes in a candidate ID as input, queries the database for the number of votes for that candidate, and outputs the result to the console using the dbms_output package.

3. As a user of the election system, I want to be able to vote for a specific candidate at a certain polling location on a given date, so that my vote is recorded accurately. The procedure must take the following inputs: the election date in the format "mmddyyyy", the first name and last name of the voter, the name of the polling location, and the candidate ID. The procedure will then fetch the election ID, polling location ID, and candidate ID from their respective tables in the database based on the input parameters, and insert a new record into the "votes" table with the candidate ID, polling location ID, and election ID.

# DATA DICTIONARY

Table: ELECTION

    - election_id (integer): unique identifier for each election
    - election_date (date): date of the election
        Primary Key: election_id

Table: POLLING_LOCATION

    - poll_id (integer): unique identifier for each polling location
    - poll_name (varchar(20)): name of the polling location
    - street (varchar(25)): street address of the polling location
    - city (varchar(25)): city of the polling location
    - state (varchar(25)): state of the polling location
    - zip (varchar(10)): zip code of the polling location
    - num_booths (integer): number of voting booths available at the polling location
        Primary Key: poll_id

Table: VOTER

    - ssn (varchar(9)): unique identifier for each voter (Social Security Number)
    - fname (varchar(15)): first name of the voter
    - minit (varchar(2)): middle initial of the voter
    - lname (varchar(25)): last name of the voter
    - dob (date): date of birth of the voter
    - street (varchar(25)): street address of the voter
    - city (varchar(25)): city of the voter
    - state (varchar(25)): state of the voter
    - zip (varchar(10)): zip code of the voter
    - poll_id (integer): foreign key reference to the polling location where the voter is registered
        Primary Key: ssn
        Foreign Key: poll_id references POLLING_LOCATION(poll_id)

Table: OFFICE

    - office_id (integer): unique identifier for each office
    - office_name (varchar(50)): name of the office
        Primary Key: office_id

Table: PREVIOUSLY_ELECTED

    - election_id (integer): foreign key reference to the election where the candidate was previously elected
    - term_number (integer): number of the term for which the candidate was previously elected
    - ssn (varchar(9)): foreign key reference to the voter who was previously elected
    - office_id (integer): foreign key reference to the office for which the candidate was previously elected
    - currently_in_office (char(1)): indicates whether the candidate is currently in office ('Y') or not ('N')
        Primary Key: (election_id, ssn, office_id)
        Foreign Keys:
            - election_id references ELECTION(election_id)
            - ssn references VOTER(ssn)
            - office_id references OFFICE(office_id)

Table: POLL_WORKERS

    - ssn (varchar(9)): foreign key reference to the voter who is working at the polling location
    - poll_id (integer): foreign key reference to the polling location where the worker is working
    - election_id (integer): foreign key reference to the election for which the worker is working
            Primary Key: (ssn, election_id)
            Foreign Keys:
                - ssn references VOTER(ssn)
                - poll_id references POLLING_LOCATION(poll_id)
                - election_id references ELECTION(election_id)

Table: CANDIDATES

    - candidate_id (integer): unique identifier for each candidate
    - election_id (integer): foreign key reference to the election in which the candidate is running
    - ssn (varchar(9)): foreign key reference to the voter who is the candidate
    - office_id (integer): foreign key reference to the office for which the candidate is running
        Primary Key: (candidate_id, election_id)
        Foreign Keys:
            - election_id references ELECTION(election_id)
            - ssn references VOTER(ssn)
            - office_id references OFFICE(office)