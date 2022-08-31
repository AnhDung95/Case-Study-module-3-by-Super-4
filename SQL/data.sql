create database bookcase;
use bookcase;

create table category(
                         id int not null auto_increment primary key ,
                         name nvarchar(100) not null
);

create table publishers(
                           id int not null auto_increment primary key ,
                           name nvarchar(100) not null
);

create table book(
                     id int not null auto_increment primary key,
                     name nvarchar(100) not null,
                     `describe` nvarchar(500) not null ,
                     author nvarchar(100) not null ,
                     category_Id int not null ,
                     publishers_Id int not null ,
                     quantity int not null default '0',
                     img varchar(255) not null ,
                     `status` nvarchar(10) default 'new',
                     `create` timestamp default current_timestamp,
                     key `FK_publishers` (publishers_Id),
                     key `Fk_category` (category_Id),
                     constraint `FK_publishers` foreign key (publishers_Id) references publishers (id),
                     constraint `FK_category` foreign key (category_Id) references category (id)
);

create table users(
                      id int not null auto_increment primary key ,
                      account varchar(100) not null ,
                      password varchar(100) not null ,
                      firstName nvarchar(100) not null ,
                      lastName nvarchar(100) not null ,
                      address nvarchar(100) not null ,
                      phone varchar(20) not null ,
                      email varchar(100) not null ,
                      role enum('ADMIN','USER') default 'USER'
);

create table review(
                       id int not null auto_increment,
                       book_Id int default null,
                       user_Id int default null,
                       comment text,
                       primary key (id) ,
                       key `FK_book_Id` (book_Id),
                       key `FK_user_Id` (user_Id),
                       constraint `FK_book_Id` foreign key (book_Id) references book (id),
                       constraint `FK_user_Id` foreign key (user_Id) references users (id)
);

create table rental (
                        id int not null auto_increment primary key ,
                        user_Id int not null ,
                        `create` timestamp default current_timestamp,
                        delivery timestamp default current_timestamp,
                        `status` varchar(100) not null ,
                        address nvarchar(255) not null,
                        phone varchar(20) not null,
                        staff_Id int not null,
                        total double not null default '0',
                        key `FK_staff_Id` (staff_Id),
                        key`FK_users_Id` (user_Id),
                        constraint `FK_staff_Id` foreign key (staff_Id) references users(id),
                        constraint `FK_users_Id` foreign key (user_Id) references users(id)
);

create table rental_Bill(
                            bill_Id int not null,
                            book_Id int not null,
                            total double not null,
                            quantity int not null default '0',
                            primary key(bill_Id,book_Id),
                            key `FK_bookId` (book_Id),
                            key`FK_billId` (bill_Id),
                            constraint `FK_bookId` foreign key (book_Id) references book (id),
                            constraint `FK_billId` foreign key (bill_Id) references rental (id)
);

create table rate (
                      id int not null auto_increment primary key,
                      book_Id int not null,
                      rate int not null,
                      key `FKBookId` (book_Id),
                      constraint `FKBookId` foreign key (book_Id) references book (id)
);
