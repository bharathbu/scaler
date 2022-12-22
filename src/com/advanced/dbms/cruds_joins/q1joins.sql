-- Q1. Combine Two Tables
SQL
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Write an SQL query to report the city of each person in the Person table. If the address of a personId is not present in the Address table, report null instead.

Return the result table in any order.

Table: Person(
personId int,
lastName varchar,
firstName varchar)

Table: Address(
addressId int,
personId int,
city varchar)


use mysql;
select a.city
  from person p left outer join address a on p.personId = a.personId

