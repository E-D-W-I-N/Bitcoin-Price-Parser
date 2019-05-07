package com.vsk.serviceMix.logger;

import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {

    public Object sendLog(Object body) {
        return body + " Date:  " + LocalDate.now() + " Time: " + LocalTime.now();
    }

}
