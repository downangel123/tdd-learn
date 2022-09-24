package com.odde.tdd;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NowTest {

    @Test
    public void nowPatternCheck() {
        Now now = new Now();
        String formatStr = now.getString();
        //Date backDate = DateUtil.parse(formatStr,"yyyy-MM-dd HH:mm:ss.SSS");
        Pattern p = Pattern.compile("^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]).[0-9]{3}$");
        assertEquals(true, p.matcher(formatStr).find());
    }

    @Test
    void nowTest() {
        NowBetter now = new NowBetter(() -> DateUtil.parse("2022-09-24 14:23:01.123", "yyyy-MM-dd HH:mm:ss.SSS"));
        assertEquals("2022-09-24 14:23:01.123", now.getString());
    }


}
