drop database if exists bibliot;
drop role if exists bibliot;
-- create the requested bibliot user

create user bibliot createdb password 'admin';

-- create a bibliot database
create database bibliot owner bibliot;