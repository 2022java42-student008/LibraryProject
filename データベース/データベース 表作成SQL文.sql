DELETE FROM inventory WHERE isbn =9999999999999;

INSERT INTO inventory (isbn, title, code, author, publisher, publish_date)
 VALUES(9784990996314,'�y����y�킪�ł���܂Ł^�����ȓy���i�����',5,'�]�����G','�j���\���f�U�C��������','2022-05-24');
 
 
 INSERT INTO inventory (isbn, title, code, author, publisher, publish_date)
 VALUES(9784001160376,'�\�����̂��̂�����',9,'�ږ썃','��g���X','2022-04-27'),
 (9784534059277,'���ʂȂ̂ɂ܂��s�������Ȃ颂������ڋq�',5,'���؍K�}','���{���Əo�Ŏ�','2022-04-08'),
 (9784813712725,'���ׂĂ̋G�߂ɌN����������',9,'�t�c���J','�X�^�[�c�o�ŕ���','2022-04-01'),
 (9784862763082,'���ׂĂ̎q�ǂ��Ɂu�b���́v��',8,'�|��������','�p���o��','2022-04-09'),
 (9784880241968,'�����߂����đ���',9,'�Ð�O','�V���{����}��','1997-12-31'),
 (9784792771126,'���̕����j',5,'�͖�F��','���E���@','2017-03-26'),
 (9784882025238,'�V�����B�A�̗��l����',9,'�G���U�x�X�E�M���X�P��','�ʗ���','1997-12-25');
 
 
INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784990996314,'�y����y�킪�ł���܂Ł^�����ȓy���i�����','2022-05-25');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784001160376,'�\�����̂��̂�����','2022-04-28');
 
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES (9784534059277,'���ʂȂ̂ɂ܂��s�������Ȃ颂������ڋq�','2022-04-11');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784813712725,'���ׂĂ̋G�߂ɌN����������','2022-04-05');
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784813712725,'���ׂĂ̋G�߂ɌN����������','2022-04-05');
 
INSERT INTO stock (isbn, title, arrival_date)
 VALUES (9784862763082,'���ׂĂ̎q�ǂ��Ɂu�b���́v��','2022-04-11'),
 (9784880241968,'�����߂����đ���','1999-01-08'),
 (9784792771126,'���̕����j','2017-05-02'),
 (9784882025238,'�V�����B�A�̗��l����','1997-12-28');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784569640167,'���̂����l�̕ЂÂ���','2006/03/18');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784831507037,'���{�̐��_','1995/12/24');
 
 INSERT INTO stock (isbn, title, arrival_date)
 VALUES(9784831507037,'���{�̐��_','2000/02/11');
 
 DROP TABLE inventory2 CASCADE;
 
 
 
 CREATE TABLE categorycode (code integer PRIMARY KEY, category_name character varying);
 
 CREATE TABLE inventory (inbn bigint NOT NULL, title character varying, code integer, author character varying, publisher character varying, publish_date date);
 
 CREATE TABLE manager (manager_id SERIAL PRIMARY KEY, name character varying, role character varying, password text);
 
 CREATE TABLE rental (rental_id SERIAL PRIMARY KEY, user_id integer, book_id integer, rental_date date, fixed_date date, return_date date, remarks text);
 
 CREATE TABLE stock (book_id SERIAL PRIMARY KEY, inbn bigint NOT NULL, title character varying, arrival_date date, discard_date date, remarks text);
 
 CREATE TABLE user_table (user_id SERIAL PRIMARY KEY, name character varying, post_no bigint, address text, tel text, mail character varying, birthday date, join_date date, update_date timestamp, retire_date date);
 

 
 
 
 
