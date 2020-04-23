-- insert pet categories
insert into types (name) values ('Hamster');
insert into types (name) values ('Broască Ţistoasă');
insert into types (name) values ('Şarpe');
insert into types (name) values ('Arici');
insert into types (name) values ('Meduza');
insert into types (name) values ('Peşte');
insert into types (name) values ('Papagal');

-- insert vets
insert into vet (first_name , last_name) values ( 'Vladimir', 'Voronin' );
insert into vet (first_name , last_name) values ( 'Dima', 'Maslenikov');
insert into vet (first_name , last_name) values ( 'Iurie', 'Leanca');
insert into vet (first_name , last_name) values ( 'Mihai', 'Ghimpu');
insert into vet (first_name , last_name) values ( 'Vlad', 'Plahotniuc');
insert into vet (first_name , last_name) values ( 'Igor', 'Dodon');

-- insert vet specialities
insert into specialties (description) values ('Chirurg');
insert into specialties (description) values ('Dentist');
insert into specialties (description) values ('Traumatolog');
insert into specialties (description) values ('ORL');
insert into specialties (description) values ('Vaccinolog');
insert into specialties (description) values ('Psiholog');

-- connect vet with speciality
insert into vets (vet_id, speciality_id) values (1, 1);
insert into vets (vet_id, speciality_id) values (2, 2);
insert into vets (vet_id, speciality_id) values (3, 3);
insert into vets (vet_id, speciality_id) values (4, 4);
insert into vets (vet_id, speciality_id) values (5, 5);
insert into vets (vet_id, speciality_id) values (6, 6);

