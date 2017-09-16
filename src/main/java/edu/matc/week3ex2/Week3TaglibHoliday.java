package edu.matc.week3ex2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.util.*;

public class Week3TaglibHoliday  extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println(determineHolidays());
    }


    public String determineHolidays() {

        Map<MonthDay, String> holidayList = new TreeMap<MonthDay, String>();

        holidayList.put(MonthDay.of(1,1),"New Years Day");
        holidayList.put(MonthDay.of(1,16),"Martin Luther King Jr Day");
        holidayList.put(MonthDay.of(2,20),"George Washington's Birthday");
        holidayList.put(MonthDay.of(5,29), "Memorial Day");
        holidayList.put(MonthDay.of(7,4),"Independence Day");
        holidayList.put(MonthDay.of(9,4),"Labor Day");
        holidayList.put(MonthDay.of(10,9),"Columbus Day");
        holidayList.put(MonthDay.of(11,10),"Veterans Day");
        holidayList.put(MonthDay.of(11,23),"Thanksgiving Day");
        holidayList.put(MonthDay.of(12,25),"Christmas Day");

        MonthDay now = MonthDay.now();

        String message;
        if (holidayList.containsKey(now)) {
            message = "Happy Holidays! It's " + holidayList.get(now);
        } else {
            message = "No Holidays today :(";
        }

        return message;
    }


}
