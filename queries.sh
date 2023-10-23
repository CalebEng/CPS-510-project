#!/bin/sh
#export LD_LIBRARY_PATH=/usr/lib/oracle/12.1/client64/lib
sqlplus64 "username/password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.cs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))" <<EOF

SELECT * FROM CUSTOMER WHERE VALET=(1);

SELECT COUNT(E_ID), PARTTIME_FULLTIME
FROM EMPLOYEE
GROUP BY PARTTIME_FULLTIME;

SELECT D_O_H FROM EMPLOYEE;

SELECT * FROM ROOM WHERE ROOM_TYPE=('King');

SELECT * FROM ROOM WHERE AVAILABILITY=('Vacant') AND ROOM_TYPE=('King');

SELECT * FROM PARKINGSPOT WHERE AVALIABILITY=('Available');

SELECT * FROM ONLINEBOOKING ORDER BY CHECK_IN ASC;

SELECT * FROM AMENITIES WHERE ROOM_SERVICE=('Yes'); 

SELECT DISTINCT E_ID FROM VALET;

SELECT RESERVED.B_ID,BOOKED.ID, RESERVED.ROOM_NUMB, ONLINEBOOKING.CHECK_IN, ONLINEBOOKING.CHECK_OUT
FROM RESERVED
INNER JOIN ONLINEBOOKING ON RESERVED.B_ID = ONLINEBOOKING.B_ID
INNER JOIN BOOKED ON RESERVED.B_ID = BOOKED.B_ID;

SELECT CUSTOMER.NAME, VALET.L_PLATE, VALET.SPOT_NUMB, PARKED.E_ID
FROM CUSTOMER
INNER JOIN VALET ON CUSTOMER.ID = VALET.ID
INNER JOIN PARKED ON CUSTOMER.ID = PARKED.ID;

SELECT EXTRAS.A_ID, ONLINEBOOKING.NUMBER_OF_GUESTS, ONLINEBOOKING.ROOM_ID
FROM EXTRAS
INNER JOIN ONLINEBOOKING on EXTRAS.A_ID = ONLINEBOOKING.A_ID;

SELECT INUSE.L_PLATE, VALET.E_ID, VALET.ID
FROM INUSE
INNER JOIN VALET ON INUSE.L_PLATE = VALET.L_PLATE;

SELECT EMPLOYEE.NAME, CUSTOMER.NAME, VALET.L_PLATE, VALET.SPOT_NUMB
FROM PARKED
INNER JOIN EMPLOYEE ON PARKED.E_ID = EMPLOYEE.E_ID
INNER JOIN CUSTOMER ON PARKED.ID = CUSTOMER.ID
INNER JOIN VALET ON PARKED.E_ID = VALET.E_ID;

exit;
EOF