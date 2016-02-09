# Hibernate Mapping for a Happy REST

## Purpose
Demonstrates idealized hibernate mappings for optimal performance and serialization.

## Expectations
You have a mysql database on localhost:3306 with a schema created called 
model_test with user root, no password. Adjust the gradle file properties to match
 your settings if these are not yours.

## Why
This project demonstrates from very simple examples of Hibernate mappings which are designed
with the following goals in mind:

* Minimize the object graph
* Prevent stack overflow errors on serialization
* Prevent massive descent into the object graph on serialization
* Model the data closely to how it gets accessed
* Keep it simple

 
Some guiding principles

* No bidirectional relationships
* Minimize entity relationships, maximize use of keys
* Allow services to set relationships WHEN they matter
* Allow HQL/Repository loads and services to load relationships WHEN they matter
