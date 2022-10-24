create table application
(
    code    varchar(3)   not null,
    name    varchar(255) not null,
    primary key (code),
    unique (name)
);

create table ipinfo
(
    id                bigint generated always as identity,
    application_code  varchar(255) not null,
    ip_range          varchar(30)  not null,
    active            boolean      not null,
    primary key (id),
    unique (application_code, ip_range),
    foreign key (application_code) references application (code)
);

