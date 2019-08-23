DELETE
FROM books;
--
-- DELETE
-- FROM course;
--
-- DELETE
-- FROM student;
--
-- DELETE
-- FROM instructor;
-- CREATE TABLE books (
--     bookid int,
--     bookTitle VARCHAR(100)	,
--     isbn VARCHAR(100),
--     copy int
-- );

INSERT INTO books(bookid, booktitle, isbn, copy)
    VALUES(1, 'Sally jumps the shark', '20-3333-5321-4', 1986),
          (2,'Lucy hears a who', '23-0192-3443-1', 1999),
          (3, 'Charlie and the Chocolate Factory', '21-8273-0192-2', 1965)

-- INSERT INTO course (courseid, coursename, instructid)
-- 	VALUES (1, 'Data Science', 1),
--            (2, 'JavaScript', 1),
--            (3, 'Node.js',  1),
--            (4, 'Java Back End', 2),
--            (5, 'Mobile IOS', 2),
--            (6, 'Mobile Android',  3);
--
-- INSERT INTO student (studid, studname)
--     VALUES (1, 'John'),
--            (2, 'Julian'),
--            (3, 'Mary'),
--            (4, 'Julian'),
--            (5, 'Tyler'),
--            (6, 'Kim'),
--            (7, 'Juan'),
--            (8, 'Robby'),
--            (9, 'Roberto'),
--            (10, 'Bob'),
--            (11, 'Liz'),
--            (12, 'June'),
--            (13, 'April');
--
-- INSERT INTO studcourses (studid, courseid)
--     VALUES (1, 1),
--            (1, 4),
--            (2, 2),
--            (3, 3),
--            (3, 1),
--            (3, 6);

alter sequence hibernate_sequence restart with 20;