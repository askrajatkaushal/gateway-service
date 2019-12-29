create table roles (
    id varchar(50) primary key,
    username varchar(25) not null,
    role varchar(25) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on roles (username, role);
