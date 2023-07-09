insert into SEC_User (email, encryptedPassword, ENABLED)
values ('admin@admin.com', '$2a$10$1ltibqiyyBJMJQ4hqM7f0OusP6np/IHshkYc4TjedwHnwwNChQZCy', 1);

insert into SEC_User (email, encryptedPassword, ENABLED)
values ('user@user.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);


 
insert into sec_role (roleName)
values ('ROLE_ADMIN');
 
insert into sec_role (roleName)
values ('ROLE_USER');

insert into user_role (userId, roleId)
values (1, 1);
 
insert into user_role (userId, roleId)
values (1, 2);
 
insert into user_role (userId, roleId)
values (2, 2);

insert into manufacturer (manufacturer)
values ('giant bicycle');

insert into manufacturer (manufacturer)
values ('trek bikes');

insert into manufacturer (manufacturer)
values ('Redline');
insert into manufacturer (manufacturer)
values ('Perfect body lab');

insert into manufacturer (manufacturer)
values ('Burley');

insert into bike (manufacturerID, bikeModel, year, colour, price) 
	values ('1', 'superbike', '2010', 'blue', '2000');


