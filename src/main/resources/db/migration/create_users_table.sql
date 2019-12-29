create table users (
    id varchar(50) primary key,
    username varchar(25) unique,
    password varchar(25) not null,
    active boolean default true not null
);
