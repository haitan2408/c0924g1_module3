create
database c0924g1_db;

use
c0924g1_db;

create table students
(
    id                  int auto_increment primary key,
    name_student        varchar(100),
    description_student text,
    dob                 date
);

drop table students;

insert into students(name_student, description_student, dob) value ("HaiTT", "Vip pro", "1111-11-11");

select *
from students;

update students
set name_student = "hai"
where id = 1;