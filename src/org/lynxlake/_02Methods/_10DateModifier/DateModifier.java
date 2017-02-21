package org.lynxlake._02Methods._10DateModifier;

import java.util.Calendar;
import java.util.Date;

class DateModifier {
    private long diffDays;

    public void calculate(String startDateStr, String endDateStr) {
        String[] params = startDateStr.trim().split("\\s+");
        int yy1 = Integer.parseInt(params[0]);
        int mm1 = Integer.parseInt(params[1]);
        int dd1 = Integer.parseInt(params[2]);

        params = endDateStr.trim().split("\\s+");
        int yy2 = Integer.parseInt(params[0]);
        int mm2 = Integer.parseInt(params[1]);
        int dd2 = Integer.parseInt(params[2]);

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(yy1, mm1, dd1);
        end.set(yy2, mm2, dd2);
        Date startDate = start.getTime();
        Date endDate = end.getTime();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = Math.abs(endTime - startTime);
        this.diffDays = diffTime / (1000 * 60 * 60 * 24);
    }

    public long getDiffDays() {
        return this.diffDays;
    }
}
