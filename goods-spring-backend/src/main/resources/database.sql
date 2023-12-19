SELECT * FROM goods_tbl

INSERT INTO goods_tbl (gno, ggoods, gcontent, gprice, gquan, gimgfile)
VALUES (NULL, '연습1', '연습1', '10000', '10', 'a.jpg');

DELETE FROM goods_tbl WHERE goods_tbl.gno = 1

UPDATE goods_tbl    SET     ggoods = '연습11',
                            gcontent = '연습11',
                            gprice = '100100',
                            gquan = '101',
                            gimgfile = 'a1.jpg'
                    WHERE   goods_tbl.gno = 1
