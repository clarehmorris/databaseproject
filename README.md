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