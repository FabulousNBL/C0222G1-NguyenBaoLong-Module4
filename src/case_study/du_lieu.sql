use case_spring;
-- delete from customer_type; 
insert into customer_type (type) values ("Diamond"),("Platinum"),("Gold"),("Silver"),("Member");
-- delete from degree;
insert into degree (name) values ("Trung cấp"),("Cao đẳng"),("Đại học"),("Sau đại học");
-- delete from division;
insert into division (name) values ('Sale – Marketing'),('Hành Chính'),('Phục vụ'),('Quản lý');
-- delete from position;
insert into position (name) values ('lễ tân'),('phục vụ'),('chuyên viên'),('giám sát'),('quản lý'),('giám đốc');
-- delete from rent_type;
INSERT INTO rent_type (type)
VALUES('năm'),('tháng'),('ngày'),('giờ');
-- delete from service_type;
INSERT INTO service_type (name)
VALUES('Villa'),('House'),('Room');
-- delete from service;
insert into service(name,area,cost,amount_customer,standard_room,description,pool_area,floor,rent_type_id,service_type_id)
values
('Villa Beach Front' ,25000 ,10000000 , 10,'vip','Có hồ bơi' ,500 ,4 ,3 , 1 ),
('House Princess 01' ,14000 ,5000000 , 7,'vip','Có thêm bếp nướng' ,0 ,3 ,2 , 2 ),
('Room Twin 01' ,5000 ,1000000 , 2,'normal','Có tivi' ,0 ,0 ,4 , 3 ),
('Villa No Beach Front' ,22000 ,9000000 , 8,'normal','Có hồ bơi' ,300 ,3 ,3 , 1 ),
('House Princess 02' ,10000 ,4000000 , 5,'normal','Có thêm bếp nướng' ,0 ,2 ,3 , 2 ),
('Room Twin 02' ,3000 ,900000 , 2,'normal','Có tivi' ,0 ,0 ,4 , 3 );
-- delete from user;
insert into user (user_name , password) values ("skynumber1","123456"),("skynumber2","123456"),("skynumber3","123456"),("skynumber4","123456"),("skynumber5","123456"),("skynumber6","123456"),("skynumber7","123456"),("skynumber8","123456"),("skynumber9","123456"),("skynumber10","123456");
-- delete from employee;
insert into employee(name,birthday,card_id,salary,phone,email,address,position_id,degree_id,division_id,user_name)
values
('Nguyễn Văn An','1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1,'skynumber1'),
('Lê Văn Bình','1997-04-09',654231234,7000000,0934212314,'binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2,'skynumber2'),
('Hồ Thị Yến','1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2,'skynumber3'),
('Võ Công Toản','1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com','77 Hoàng Diệu, Quảng Trị',1,4,4,'skynumber4'),
('Nguyễn Bỉnh Phát','1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com','43 Yên Bái, Đà Nẵng',2,1,1,'skynumber5'),
('Khúc Nguyễn An Nghi','2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3,'skynumber6'),
('Nguyễn Hữu Hà','1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2,'skynumber7'),
('Nguyễn Hà Đông','1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4,'skynumber8'),
('Tòng Hoang','1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4,'skynumber9'),
('Nguyễn Công Đạo','1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2,'skynumber10');
-- delete from customer;
insert into customer(name,birthday,gender,customer_id_card,phone,email,address,type_id, code_customer)
values
("Nguyễn Thị Hào","1970-11-07",0,"643431213","0945423362","thihao07@gmail.com","Đà Nẵng",5,'KH-0001'),
("Phạm Xuân Diệu","1992-08-08",1,"016561645","016589161516","abc@gmail.com","Quảng Trị",3,'KH-0002'),
("Trương Đình Nghệ","1990-02-27",1,"016561645","016589161516","abcd@gmail.com","Vinh",1,'KH-0003'),
("Dương Văn Quan","1981-07-08",1,"543432111","0490039241","duongquan@gmail.com","Đà Nẵng",1,'KH-0004'),
("Hoàng Trần Nhi Nhi","1995-12-09",0,"795453345","0312345678","nhinhi123@gmail.com","Gia Lai",4,'KH-0005'),
("Tôn Nữ Mộc Châu","2005-12-06",0,"732434215","0988888844","tonnuchau@gmail.com","Đà Nẵng",4,'KH-0006'),
("Nguyễn Mỹ Kim","1984-04-08",0,"856453123","0912345698","kimcuong84@gmail.com","Hồ Chí Minh",1,'KH-0007'),
("Nguyễn Thị Hào","1999-04-08",0,"965656433","0763212345","haohao99@gmail.com","Kon Tum",3,'KH-0008'),
("Trần Đại Danh","1994-07-01",1,"432341235","0643343433","danhhai99@gmail.com","Quảng Ngãi",1,'KH-0009'),
("Nguyễn Tâm Đắc","1989-07-01",1,"344343432","0987654321","dactam@gmail.com","Đà Nẵng",2,'KH-0010');