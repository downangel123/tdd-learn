package com.odde.tdd;

import java.text.SimpleDateFormat;

public class NowBetter {

    private final TimeProvider timeProvider;

    public NowBetter(){
        this.timeProvider = new SystemTimeProvider();
    }

    public NowBetter(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String getString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .format(timeProvider.getDate());
    }


}
