CREATE TABLE blboard_tbl(
                            bno int(4) NOT null PRIMARY KEY AUTO_INCREMENT,
                            bname varchar(50) NOT null,
                            bprice int(4),
                            bamount int(4),
                            btype varchar(4),
                            breason varchar(100)
);
SELECT * FROM blboard_tbl
INSERT INTO blboard_tbl (bno, bname, bprice, bamount, btype, breason)
VALUES (NULL, '연습1', '1000', '3', '불량', '불량');
SELECT * FROM blboard_tbl WHERE 1
UPDATE blboard_tbl SET bno='[value-1]',
                       bname='[value-2]',
                       bprice='[value-3]',
                       bamount='[value-4]',
                       btype='[value-5]',
                       breason='[value-6]' WHERE 1
DELETE FROM blboard_tbl WHERE 0
