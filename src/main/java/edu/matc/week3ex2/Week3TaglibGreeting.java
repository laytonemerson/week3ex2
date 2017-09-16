package edu.matc.week3ex2;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.util.*;

public class Week3TaglibGreeting extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        out.println(determineGreeting());
    }

    private String determineGreeting() {
        LocalDateTime dateTime = LocalDateTime.now();

        String message;
        if (dateTime.getHour() <= 12) {
            message = "Good Morning";
        } else if (dateTime.getHour() < 17) {
            message = "Good Afternoon";
        } else {
            message = "Good Evening";
        }
        return message;
    }

}