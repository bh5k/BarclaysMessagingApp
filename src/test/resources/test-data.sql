insert into Address (id, line_one, line_two, state, postal_code, country) values (100, '123 street', 'abc', 'UT', '84065', 'USA');
insert into Address (id, line_one, line_two, state, postal_code, country) values (200, '456 street', 'def', 'UT', '84066', 'USA');
insert into Address (id, line_one, line_two, state, postal_code, country) values (300, '789 street', 'ghi', 'UT', '84067', 'USA');
insert into Address (id, line_one, line_two, state, postal_code, country) values (400, '654 street', 'jkl', 'UT', '84068', 'USA');

insert into Person (id, name, email_address, address_id) values (100, 'Bryan', 'who@cares.com', 100);
insert into Person (id, name, email_address, address_id) values (200, 'Steve', 'why@cares.com', 200);
insert into Person (id, name, email_address, address_id) values (300, 'Bryan', 'who@cares.com', 300);
insert into Person (id, name, email_address, address_id) values (400, 'Bryan', 'who@cares.com', 400);

insert into Message (id, content, sender_id) values (150, 'My first message out of the data file', 100);
insert into Message (id, content, sender_id) values (250, 'My second message out of the data file', 200);
insert into Message (id, content, sender_id) values (350, 'My third message out of the data file', 300);
insert into Message (id, content, sender_id) values (450, 'My fourth message out of the data file', 400);
