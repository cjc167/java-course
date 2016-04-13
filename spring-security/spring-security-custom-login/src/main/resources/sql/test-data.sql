--insert into users (username, password, enabled) values ('admin', '1234', true);
insert into users (username, password, enabled) values ('admin', '81dc9bdb52d04dc20036dbd8313ed055', true);

insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');

insert into groups (id, group_name) values (10000, 'admin');

insert into group_authorities (group_id, authority) values (10000, 'ROLE_USER');

insert into group_members (id, username, group_id) values (20000, 'admin', 10000);