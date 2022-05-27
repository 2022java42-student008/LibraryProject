DROP TABLE user_table CASCADE;
 
 
 CREATE TABLE categorycode (code integer PRIMARY KEY, category_name character varying);
 
 CREATE TABLE inventory (inbn bigint NOT NULL, title character varying, code integer, author character varying, publisher character varying, publish_date date);
 
 CREATE TABLE manager (manager_id SERIAL PRIMARY KEY, name character varying, role character varying, password text);
 
 CREATE TABLE rental (rental_id SERIAL PRIMARY KEY, user_id integer, book_id integer, rental_date date, fixed_date date, return_date date, remarks text);
 
 CREATE TABLE stock (book_id SERIAL PRIMARY KEY, inbn bigint NOT NULL, title character varying, arrival_date date, discard_date date, remarks text);
 
 CREATE TABLE user_table (user_id SERIAL PRIMARY KEY, name character varying, post_no bigint, address text, tel text, mail character varying, birthday date, join_date date, secede_date date, update_date timestamp);
 

