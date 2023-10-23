#!/bin/sh
#export LD_LIBRARY_PATH=/usr/lib/oracle/12.1/client64/lib
sqlplus64 "username/password@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(Host=oracle.cs.ryerson.ca)(Port=1521))(CONNECT_DATA=(SID=orcl)))" <<EOF

DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;
DROP TABLE CUSTOMER CASCADE CONSTRAINTS;
DROP TABLE ROOM CASCADE CONSTRAINTS;
DROP TABLE PARKINGSPOT CASCADE CONSTRAINTS;
DROP TABLE AMENITIES CASCADE CONSTRAINTS;
DROP TABLE BOOKED CASCADE CONSTRAINTS;
DROP TABLE EXTRAS CASCADE CONSTRAINTS;
DROP TABLE INUSE CASCADE CONSTRAINTS;
DROP TABLE ONLINEBOOKING CASCADE CONSTRAINTS;
DROP TABLE PARKED CASCADE CONSTRAINTS;
DROP TABLE RESERVED CASCADE CONSTRAINTS;
DROP TABLE VALET CASCADE CONSTRAINTS;

exit;
EOF