create table users (
    id int not null auto_increment,
    email varchar(255) not null,
    password varchar(255) not null,

    primary key (id)
);