
delete from Country;
delete from City;
delete from HOTEL_AMINITY;
delete from AMINITY;
delete from Hotel_Details;




INSERT INTO Country VALUES (100, 'India');
INSERT INTO Country VALUES (101, 'China');
INSERT INTO Country VALUES (102, 'USA');
INSERT INTO Country VALUES (103, 'England');
INSERT INTO Country VALUES (104, 'Germany');
INSERT INTO Country VALUES (105, 'France');


INSERT INTO City VALUES (100, 'Bangalore', 100);
INSERT INTO City VALUES (101, 'Kolkata', 100);
INSERT INTO City VALUES (102, 'Pune', 100);
INSERT INTO City VALUES (103, 'London', 103);
INSERT INTO City VALUES (105, 'Leeds', 103);
INSERT INTO City VALUES (109, 'Barlin', 105);
INSERT INTO City VALUES (106, 'New work', 102);
INSERT INTO City VALUES (107, 'Dalas', 102);
INSERT INTO City VALUES (108, 'Beiging', 101);

INSERT INTO Hotel_Details(hotel_id,hotel_name,city_city_id,address,contact_no,active) VALUES (100, 'Ibis', 100,'addr1','98869040','y');
INSERT INTO Hotel_Details(hotel_id,hotel_name,city_city_id,address,contact_no,active) VALUES (101, 'Park Plaza', 101,'addr1','98869040',1);
INSERT INTO Hotel_Details(hotel_id,hotel_name,city_city_id,address,contact_no,active) VALUES (103, 'Lake View', 106,'addr1','98869040',1);
INSERT INTO Hotel_Details(hotel_id,hotel_name,city_city_id,address,contact_no,active) VALUES (104, 'Sewnew', 107,'addr1','98869040',1);
INSERT INTO Hotel_Details(hotel_id,hotel_name,city_city_id,address,contact_no,active) VALUES (105, 'Snowy', 103,'addr1','98869040',0);


INSERT INTO AMINITY VALUES(100, 'Room service');
INSERT INTO AMINITY VALUES(101, 'Parking');
INSERT INTO AMINITY VALUES(102, 'Bar');
INSERT INTO AMINITY VALUES(103, 'Spa');
INSERT INTO AMINITY VALUES(104, 'Parking');
INSERT INTO AMINITY VALUES(105, 'Laundry');
INSERT INTO AMINITY VALUES(106, 'Fitness Centre');

INSERT INTO HOTEL_AMINITY VALUES(100, 100);
INSERT INTO HOTEL_AMINITY VALUES(100, 101);
INSERT INTO HOTEL_AMINITY VALUES(100, 102);
INSERT INTO HOTEL_AMINITY VALUES(101, 100);
INSERT INTO HOTEL_AMINITY VALUES(103, 102);
INSERT INTO HOTEL_AMINITY VALUES(103, 100);
INSERT INTO HOTEL_AMINITY VALUES(104, 105);
INSERT INTO HOTEL_AMINITY VALUES(104, 106);