alter table mnpg.operator
    add column permission_level varchar(10);

update mnpg.operator
set permission_level = 'low'
where permission_level is null;