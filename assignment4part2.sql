/* 
there are two parts to Assignment 4: Part 2 

1. we need at least 3 advanced join queries --------------- i think we already have this but I might be mistaken
2. we need at least 4 views
*/


/* WE WILL START WITH VIEWS */

/* View #1: creates a table for all the rooms that can fit a family */

create view FAMILY_ROOMS as 
    (SELECT * FROM ROOM WHERE CAPACITY > 2);

/* View #2: creates a table for all customers who requested valet */

create view VALET_REQUESTS as 
    (SELECT * FROM CUSTOMER WHERE VALET = 1);

/* View #3: creates a table for all the parking spots that are available */

create view AVAILABLE_SPOT as 
    (SELECT * FROM PARKINGSPOT WHERE AVALIABILITY=('Available'));

/* View #4: creates a table for the room number of all accessible and available rooms*/

create view AVAILABLE_ACCESSIBLE as 
    (SELECT ROOM_ID FROM ROOM WHERE ROOM_TYPE=('Accessible') AND AVAILABILITY=('Vacant'));

/* View #5: creates a table for all the names of the employees who have parked a car */

create view VALET_NAMES as 
    (SELECT EMPLOYEE.NAME FROM VALET INNER JOIN EMPLOYEE ON VALET.E_ID=EMPLOYEE.E_ID);


