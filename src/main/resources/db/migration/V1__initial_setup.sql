create table mnpg.operator
(
    id   varchar(20) primary key,
    name varchar(20) not null,
    tel  varchar(12),
    addr varchar(40)
);

insert into mnpg.operator(id, name, tel, addr)
values ('001', 'a', '111', '四川成都'),
       ('001', 'a', '111', '四川成都'),
       ('001', 'a', '111', '四川成都'),
       ('001', 'a', '111', '四川成都')
on conflict do nothing;