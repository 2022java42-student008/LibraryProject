DELETE FROM inventory WHERE isbn =9999999999999;

INSERT INTO inventory (isbn, title, code, author, publisher, publish_date)
 VALUES(9784990996314,'土から土器ができるまで／小さな土製品を作る',5,'望月昭秀','ニルソンデザイン事務所','2022-05-24');
 
 
 INSERT INTO inventory (isbn, title, code, author, publisher, publish_date)
 VALUES(9784001160376,'ソロ沼のものがたり',9,'舘野鴻','岩波書店','2022-04-27'),
 (9784534059277,'普通なのにまた行きたくなる｢すごい接客｣',5,'筒木幸枝','日本実業出版社','2022-04-08'),
 (9784813712725,'すべての季節に君だけがいた',9,'春田モカ','スターツ出版文庫','2022-04-01'),
 (9784862763082,'すべての子どもに「話す力」を',8,'竹内明日香','英治出版','2022-04-09'),
 (9784880241968,'光をめざして走れ',9,'古川薫','新日本教育図書','1997-12-31'),
 (9784792771126,'味の文化史',5,'河野友美','世界書院','2017-03-26'),
 (9784882025238,'シルヴィアの恋人たち',9,'エリザベス・ギャスケル','彩流社','1997-12-25');
 
 
INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784990996314,'土から土器ができるまで／小さな土製品を作る','2022-05-25');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784001160376,'ソロ沼のものがたり','2022-04-28');
 
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES (9784534059277,'普通なのにまた行きたくなる｢すごい接客｣','2022-04-11');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784813712725,'すべての季節に君だけがいた','2022-04-05');
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784813712725,'すべての季節に君だけがいた','2022-04-05');
 
INSERT INTO stock (isbn, title, arrival_date)
 VALUES (9784862763082,'すべての子どもに「話す力」を','2022-04-11'),
 (9784880241968,'光をめざして走れ','1999-01-08'),
 (9784792771126,'味の文化史','2017-05-02'),
 (9784882025238,'シルヴィアの恋人たち','1997-12-28');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784569640167,'頭のいい人の片づけ方','2006/03/18');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784831507037,'日本の精神','1995/12/24');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784831507037,'日本の精神','2000/02/11');
 
 DROP TABLE inventory2 CASCADE;
 
 
 
 CREATE TABLE categorycode (code integer PRIMARY KEY, category_name character varying);
 
 CREATE TABLE inventory (inbn bigint NOT NULL, title character varying, code integer, author character varying, publisher character varying, publish_date date);
 
 CREATE TABLE manager (manager_id SERIAL PRIMARY KEY, name character varying, role character varying, password text);
 
 CREATE TABLE rental (rental_id SERIAL PRIMARY KEY, user_id integer, book_id integer, rental_date date, fixed_date date, return_date date, remarks text);
 
 CREATE TABLE stock (book_id SERIAL PRIMARY KEY, inbn bigint NOT NULL, title character varying, arrival_date date, discard_date date, remarks text);
 
 CREATE TABLE user_table (user_id SERIAL PRIMARY KEY, name character varying, post_no bigint, address text, tel text, mail character varying, birthday date, join_date date, update_date timestamp, retire_date date);
 

 
 
 
 
