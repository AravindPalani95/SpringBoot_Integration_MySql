use dev;

create table location (location_id int, location_name varchar(100),primary key(location_id));


insert into location values(100,'Kelambakkam');
insert into location values(101,'Navalur');
insert into location values(102,'Sholinganaloore');

commit;

select * from location;

create table restaurant (restaurant_id int, restaurant_name varchar(100),rating int, max_price double, location_id int, primary key(restaurant_id));

insert into restaurant values(1000, 'BBQ' , 5, 1000, 100);
insert into restaurant values(1001, 'Asia World' , 4, 800, 100);
insert into restaurant values(1002, '7 Star' , 4, 700, 101);
insert into restaurant values(1003, 'Paradaise' , 5, 800, 101);
insert into restaurant values(1004, 'RR Hotel' , 4, 600, 102);

commit;

select * from restaurant;

create table order_summary (order_id int, user_id int, restaurant_id int,restaurant_name varchar(100),primary key(order_id));

create table order_item_summary (order_id int,item_summary_id int, item_id int,item_name varchar(100), item_price double, discount float, primary key(item_summary_id), foreign key (order_id) references order_summary(order_id));


select * from order_summary;

select * from order_item_summary;

create table item (restaurant_id int, item_id int, restaurant_name varchar(20), item_name varchar(100), item_price double, status varchar(100), primary key(item_id));

insert into item values(100,900,'BBQ','Dosa',100,'available');
insert into item values(100,901,'BBQ','Idly',120,'available');


commit;

select * from item;
