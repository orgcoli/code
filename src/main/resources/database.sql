CREATE TABLE hrd_tbl(
                        id int(4) NOT null PRIMARY KEY AUTO_INCREMENT,
                        subject varchar(100) not null,
                        category varchar(50),
                        times varchar(50),
                        dates varchar(30),
                        money int(4),
                        people int(4)
);

INSERT INTO hrd_tbl (id, subject, category, times, dates, money, people)
VALUES (NULL, 연습1, 연습1, 연습1, 연습1, 1, 1);
SELECT * FROM hrd_tbl WHERE 1
UPDATE hrd_tbl SET id=[value-1],
    subject=[value-2],
    category=[value-3],
    times=[value-4],
    dates=[value-5],
    money=[value-6],
    people=[value-7]
WHERE 1
DELETE FROM hrd_tbl WHERE 0