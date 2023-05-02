-- This file contains the inserts/updates for the small city election ddl

INSERT INTO ELECTION VALUES(1,TO_DATE('04082021','mmddyyyy'));
INSERT INTO ELECTION VALUES(2,TO_DATE('04142022','mmddyyyy'));
INSERT INTO ELECTION VALUES(3,TO_DATE('04132023','mmddyyyy'));

INSERT INTO POLLING_LOCATION VALUES(11,'Newberry Commons','123 Newberry Street','Lock Village','TA',89455,40);
INSERT INTO POLLING_LOCATION VALUES(12,'Frankenburg High','5067 Main Street','Ark Cove','TA',89658,200);
INSERT INTO POLLING_LOCATION VALUES(13,'Town Hall','1 Broad Street','Azalea Village','TA',78945,250);
INSERT INTO POLLING_LOCATION VALUES(14,'Lukewarm Lake House','17 Launch Drive','Mosquitto Mark','TA',11203,120);

INSERT INTO VOTER VALUES('112233455','Jane','M','Doe',TO_DATE('09072000','mmddyyyy'),'123 Minglewood Road','Tarkville','TA',89455,11);
INSERT INTO VOTER VALUES('987654321','Harry','J','Potter',TO_DATE('07311980','mmddyyyy'),'4 Privet Drive','Surrey','TA',89658,12);
INSERT INTO VOTER VALUES('000000001','Katniss','K','Everdeen',TO_DATE('04111999','mmddyyyy'),'14 Dirt Avenue','District 12','TA',78945,13);
INSERT INTO VOTER VALUES('404040404','Peeta','P','Mellark',TO_DATE('07231999','mmddyyyy'),'16 Dirt Avenue','District 12', 'TA',89658,13);
INSERT INTO VOTER VALUES('666677777','Ronald','B','Weasley',TO_DATE('01031980','mmddyyyy'),'1 Winding Way','Nowhere','TA',89455,12);
INSERT INTO VOTER VALUES('000111000','Hermoine','G','Granger',TO_DATE('04201980','mmddyyyy'),'46 Canterbury Ave','London','TA',78945,12);
INSERT INTO VOTER VALUES('024686420','Billy','B','Bob',TO_DATE('08272001','mmddyyyy'),'1234 Road Street','Red Bank','TA',11203,14);
INSERT INTO VOTER VALUES('123454321','Cotton','E','Joe',TO_DATE('01011997','mmddyyyy'),'Mango Place','Mango Falls','TA',11203,11);

INSERT INTO VOTER VALUES('315485998','Trevar','H','McEvon',TO_DATE('03/17/1936','mm/dd/yyyy'),'Maple Drive','San Jose','TA',11203,14);
INSERT INTO VOTER VALUES('137459975','Enrico','L','Covely',TO_DATE('5/20/1934','mm/dd/yyyy'),'Maple Drive','Dallas','TA',89658,12);
INSERT INTO VOTER VALUES('791399884','Letty','I','Beardon',TO_DATE('5/14/1970','mm/dd/yyyy'),'Elm Street','New York','TA',78945,13);
INSERT INTO VOTER VALUES('302034739','Alvan','P','Tower',TO_DATE('9/13/1973','mm/dd/yyyy'),'Main Street','Columbus','TA',89455,11);
INSERT INTO VOTER VALUES('244703479','Lemuel','W','Candy',TO_DATE('7/29/1943','mm/dd/yyyy'),'Main Street','Denver','TA',78945,12);
INSERT INTO VOTER VALUES('411491214','Flory','W','Sparshutt',TO_DATE('11/22/1938','mm/dd/yyyy'),'Cedar Lane','Seattle','TA',89658,13);
INSERT INTO VOTER VALUES('689231940','Reagan','E','Uttley',TO_DATE('7/17/1990','mm/dd/yyyy'),'Oak Avenue','Indianapolis','TA',78945,12);
INSERT INTO VOTER VALUES('853650285','Charlene','I','Starkey',TO_DATE('12/14/1969','mm/dd/yyyy'),'Main Street','Fort Worth','TA',89455,11);
INSERT INTO VOTER VALUES('472741200','Chester','H','Peckett',TO_DATE('6/30/1986','mm/dd/yyyy'),'Cedar Lane','San Diego','TA',89658,13);
INSERT INTO VOTER VALUES('217660432','Charis','T','Simenel',TO_DATE('4/20/1988','mm/dd/yyyy'),'Main Street','San Diego','TA',89658,13);
INSERT INTO VOTER VALUES('580735017','Hayley','U','Hadeke',TO_DATE('9/22/1957','mm/dd/yyyy'),'Oak Avenue','Denver','TA',78945,13);
INSERT INTO VOTER VALUES('355345698','Celestyn','L','Twist',TO_DATE('3/23/1961','mm/dd/yyyy'),'Main Street','San Francisco','TA',89455,11);
INSERT INTO VOTER VALUES('888188570','Cinderella','L','Mallan',TO_DATE('6/4/1953','mm/dd/yyyy'),'Oak Avenue','Charlotte','TA',89455,14);
INSERT INTO VOTER VALUES('588398473','Shaylah','S','Claque',TO_DATE('7/14/1953','mm/dd/yyyy'),'Maple Drive','Indianapolis','TA',11203,11);
INSERT INTO VOTER VALUES('303623075','Ilaire','U','Shreenan',TO_DATE('11/3/1988','mm/dd/yyyy'),'Cedar Lane','Indianapolis','TA',78945,13);
INSERT INTO VOTER VALUES('542353643','Junie','O','Gaule',TO_DATE('7/26/1936','mm/dd/yyyy'),'Main Street','Jacksonville','TA',11203,12);
INSERT INTO VOTER VALUES('662514504','Finley','J','Giacometti',TO_DATE('11/2/1952','mm/dd/yyyy'),'Main Street','New York','TA',11203,11);
INSERT INTO VOTER VALUES('917815847','Steffane','G','Maciak',TO_DATE('5/14/1955','mm/dd/yyyy'),'Main Street','Los Angeles','TA',11203,14);

INSERT INTO OFFICE VALUES(90,'City Manager');
INSERT INTO OFFICE VALUES(91,'City Attorney');
INSERT INTO OFFICE VALUES(92,'Finance Director');
INSERT INTO OFFICE VALUES(93,'Police Chief');
INSERT INTO OFFICE VALUES(94,'Fire Chief');
INSERT INTO OFFICE VALUES(95,'Public Works Director');
INSERT INTO OFFICE VALUES(96,'Parks and Rec Director');
INSERT INTO OFFICE VALUES(97,'Mayor');
INSERT INTO OFFICE VALUES(98,'County Commissioner');

INSERT INTO PREVIOUSLY_ELECTED VALUES(2,2,'112233455',90,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,1,'137459975',91,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,2,'000000001',92,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,2,'404040404',93,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,2,'666677777',94,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,1,'791399884',95,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,1,'302034739',96,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,1,'244703479',97,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(2,1,'411491214',98,'Y');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'112233455',90,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'987654321',91,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'000000001',92,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'404040404',93,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'666677777',94,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'000111000',95,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'024686420',96,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'123454321',97,'N');
INSERT INTO PREVIOUSLY_ELECTED VALUES(1,1,'315485998',98,'N');

INSERT INTO POLL_WORKERS VALUES('580735017',11,1);
INSERT INTO POLL_WORKERS VALUES('355345698',12,1);
INSERT INTO POLL_WORKERS VALUES('888188570',13,1);
INSERT INTO POLL_WORKERS VALUES('588398473',14,1);
INSERT INTO POLL_WORKERS VALUES('303623075',11,1);
INSERT INTO POLL_WORKERS VALUES('542353643',12,1);
INSERT INTO POLL_WORKERS VALUES('662514504',13,1);
INSERT INTO POLL_WORKERS VALUES('917815847',14,1);
INSERT INTO POLL_WORKERS VALUES('580735017',14,2);
INSERT INTO POLL_WORKERS VALUES('355345698',14,2);
INSERT INTO POLL_WORKERS VALUES('888188570',13,2);
INSERT INTO POLL_WORKERS VALUES('588398473',13,2);
INSERT INTO POLL_WORKERS VALUES('303623075',12,2);
INSERT INTO POLL_WORKERS VALUES('542353643',12,2);
INSERT INTO POLL_WORKERS VALUES('662514504',11,2);
INSERT INTO POLL_WORKERS VALUES('917815847',11,2);

INSERT INTO CANDIDATES VALUES(1,3,'580735017',90);
INSERT INTO CANDIDATES VALUES(2,3,'303623075',90);
INSERT INTO CANDIDATES VALUES(3,3,'137459975',91);
INSERT INTO CANDIDATES VALUES(4,3,'112233455',91);
INSERT INTO CANDIDATES VALUES(5,3,'917815847',92);
INSERT INTO CANDIDATES VALUES(6,3,'123454321',92);
INSERT INTO CANDIDATES VALUES(7,3,'404040404',93);
INSERT INTO CANDIDATES VALUES(8,3,'853650285',93);
INSERT INTO CANDIDATES VALUES(9,3,'666677777',94);
INSERT INTO CANDIDATES VALUES(10,3,'000000001',94);
INSERT INTO CANDIDATES VALUES(11,3,'791399884',95);
INSERT INTO CANDIDATES VALUES(12,3,'000111000',95);
INSERT INTO CANDIDATES VALUES(13,3,'315485998',96);
INSERT INTO CANDIDATES VALUES(14,3,'588398473',96);
INSERT INTO CANDIDATES VALUES(15,3,'987654321',97);
INSERT INTO CANDIDATES VALUES(16,3,'302034739',97);
INSERT INTO CANDIDATES VALUES(17,3,'024686420',98);
INSERT INTO CANDIDATES VALUES(18,3,'244703479',98);

INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(2,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(1,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(4,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(3,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(5,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(6,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(7,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(8,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(10,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(9,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(12,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(11,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(13,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(14,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(16,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(15,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,13,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,14,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,11,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(17,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,12,3);
INSERT INTO VOTES(candidate_id, poll_id, election_id) VALUES(18,14,3);






