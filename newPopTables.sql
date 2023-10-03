/* POPULATING TABLE QUERIES USING INSERT */

/* Customer table - populate queries, pulled out of PopulateTable.java method */

insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)
values(1029384, 'Joe Smith', 4161231234, 4444444444444444, 1);

insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)
values(1230948, 'Nancy Fancy', 6471231234, 1234123412341234, 1);

insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)
values(1030707, 'Theresa Slay', 6476476477, 7777777700003333, 1);

insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)
values(1031011, 'Caleb Belac', 4166471011, 1111222233334444, 0);

insert into CUSTOMER (ID, NAME, PHONE_NUMBER, CREDIT_CARD, VALET)
values(1031213, 'Jordan Jordan', 6471234567, 9999888877776666, 0);


/* Room table - populate queries, pulled out of PopulateTable.java method */

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(500, 'King', 6, 'Occupied', 500);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(264, 'Suite', 4, 'Occupied', 400);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(773, 'HoneyMoon', 2, 'Occupied', 1000);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(100, 'Accessible', 4, 'Vacant', 200);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(444, 'Standard', 4, 'Vacant', 300);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(510, 'King', 6, 'Vacant', 500);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(200, 'Suite', 8, 'Occupied', 800);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(615, 'Queen', 4, 'Vacant', 600);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(150, 'Accessible', 4, 'Vacant', 200);

insert into ROOM (ROOM_ID, ROOM_TYPE, CAPACITY, AVAILABILITY, PRICE)
values(360, 'Standard', 4, 'Occupied', 300);


/* Employee table - populate queries, pulled out of PopulateTable.java method */

insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)
values(1111, 'Sasha Smith', 'Part_time', TO_DATE('2003-07-07','YYYY-MM-DD'));

insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)
values(1678, 'Tim Ford', 'Full_time', TO_DATE('2012-06-27','YYYY-MM-DD'));

insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)
values(1000, 'Lizzy Grant', 'Part_time', TO_DATE('2007-02-02','YYYY-MM-DD'));

insert into EMPLOYEE (E_ID, NAME, PARTTIME_FULLTIME, D_O_H)
values(1357, 'Peter Maximoff', 'Full_time', TO_DATE('2021-03-08','YYYY-MM-DD'));


/* Parking Spot table - populate queries, pulled out of PopulateTable.java method */

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(01, 'Unavailable');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(02, 'Unavailable');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(03, 'Unavailable');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(04, 'Available');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(05, 'Available');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(06, 'Unavailable');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(07, 'Available');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(08, 'Available');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(09, 'Available');

insert into PARKINGSPOT (SPOT_NUMBER, AVALIABILITY)
values(10, 'Available');


/* Amenities table - populate queries, pulled out of PopulateTable.java method */

insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)
values(0, 'No', 'No', 'No', 'No');

insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)
values(1, 'Yes', 'No', 'No', 'No');

insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)
values(2, 'No', 'Yes', 'No', 'No');

insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)
values(3, 'No', 'No', 'Yes', 'No');

insert into AMENITIES (ID, GYM, POOL, ROOM_SERVICE, BREAKFAST)
values(4, 'No', 'No', 'No', 'Yes');


/* Online Booking table - populate queries, pulled out of PopulateTable.java method */

insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID) 
values(12345, 1030707, 2, 2, TO_DATE('2023-07-06','YYYY-MM-DD'), TO_DATE('2023-07-08','YYYY-MM-DD'), 773);

insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID) 
values(11111, 1029384, 1, 4, TO_DATE('2023-12-02','YYYY-MM-DD'), TO_DATE('2023-12-12','YYYY-MM-DD'), 264);

insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID) 
values(45678, 1230948, 3, 2, TO_DATE('2023-09-29','YYYY-MM-DD'), TO_DATE('2023-09-30','YYYY-MM-DD'), 500);

insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID) 
values(32121, 1031011, 4, 4, TO_DATE('2023-10-06','YYYY-MM-DD'), TO_DATE('2023-10-11','YYYY-MM-DD'), 360);

insert into ONLINEBOOKING (B_ID, ID, A_ID, NUMBER_OF_GUESTS, CHECK_IN, CHECK_OUT, ROOM_ID) 
values(23456, 1031213, 0, 1, TO_DATE('2023-04-17','YYYY-MM-DD'), TO_DATE('2023-04-19','YYYY-MM-DD'), 200);


/* Valet table - populate queries, pulled out of PopulateTable.java method */

insert into VALET (L_PLATE, ID, E_ID, SPOT_NUMB)
values('CYBM-209', 1230948, 1357, 1);

insert into VALET (L_PLATE, ID, E_ID, SPOT_NUMB)
values('TRPD-101', 1029384, 1111, 2);

insert into VALET (L_PLATE, ID, E_ID, SPOT_NUMB)
values('SLAY-377', 1030707, 1000, 3);


/* Booked table - populate queries, pulled out of PopulateTable.java method */

insert into BOOKED (ID, B_ID)
values(1230948, 45678);

insert into BOOKED (ID, B_ID)
values(1029384, 11111);

insert into BOOKED (ID, B_ID)
values(1030707, 12345);

insert into BOOKED (ID, B_ID)
values(1031011, 32121);

insert into BOOKED (ID, B_ID)
values(1031213, 23456);


/* Reserved table - populate queries, pulled out of PopulateTable.java method */

insert into RESERVED (ROOM_NUMB, B_ID)
values(500, 45678);

insert into RESERVED (ROOM_NUMB, B_ID)
values(264, 11111);

insert into RESERVED (ROOM_NUMB, B_ID)
values(773, 12345);

insert into RESERVED (ROOM_NUMB, B_ID)
values(360, 32121);

insert into RESERVED (ROOM_NUMB, B_ID)
values(200, 23456);


/* Extras table - populate queries, pulled out of PopulateTable.java method */

insert into EXTRAS (A_ID, B_ID)
values(3, 45678);

insert into EXTRAS (A_ID, B_ID)
values(1, 11111);

insert into EXTRAS (A_ID, B_ID)
values(2, 12345);

insert into EXTRAS (A_ID, B_ID)
values(4, 32121);

insert into EXTRAS (A_ID, B_ID)
values(0, 23456);


/* Parked table - populate queries, pulled out of PopulateTable.java method */

insert into PARKED (E_ID, ID)
values(1357, 1230948);

insert into PARKED (E_ID, ID)
values(1111, 1029384);

insert into PARKED (E_ID, ID)
values(1000, 1030707);


/* Inuse table - populate queries, pulled out of PopulateTable.java method */

insert into INUSE (L_PLATE, SPOT_NUMBER)
values('CYBM-209', 1);

insert into INUSE (L_PLATE, SPOT_NUMBER)
values('TRPD-101', 2);

insert into INUSE (L_PLATE, SPOT_NUMBER)
values('SLAY-377', 3);
