package com.blue.blboard.VO;

import lombok.Data;

    /* bno int(4) NOT null PRIMARY KEY AUTO_INCREMENT,
             bname varchar(50) NOT null,
             bprice int(4),
             bamount int(4),
             btype varchar(4),
             breason varchar(100)*/
@Data
public class BoardVO {
    private int bno;
    private String bname;
    private int bprice;
    private int bamount;
    private String btype;
    private String breason;
}
