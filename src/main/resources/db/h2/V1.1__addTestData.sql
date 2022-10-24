insert into application (code, name) values ('RGR', 'BOIP Register api');
insert into application (code, name) values ('TVW', 'TmView');
insert into application (code, name) values ('SSN', 'Subscriptions');

insert into ipinfo(application_code, ip_range, active)
values('RGR', '10.0.0.0/8', true);

insert into ipinfo(application_code, ip_range, active)
values('RGR', '172.16.0.0/12', true);

insert into ipinfo(application_code, ip_range, active)
values('RGR', '192.168.0.0/8', false);

insert into ipinfo(application_code, ip_range, active)
values('RGR', '192.168.0.0/16', false);

insert into ipinfo(application_code, ip_range, active)
values('RGR', '192.168.0.0/24', false);

insert into ipinfo(application_code, ip_range, active)
values('RGR', '192.168.0.0/32', false);

insert into ipinfo(application_code, ip_range, active)
values('TVW', '192.168.0.0/16', true);

insert into ipinfo(application_code, ip_range, active)
values('SSN', '192.168.0.0/24', true);
