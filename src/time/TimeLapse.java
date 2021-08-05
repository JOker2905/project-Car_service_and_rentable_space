package time;

import java.sql.Date;

public class TimeLapse {
    java.util.Date currentDate;
    private Thread thread = null;
    private boolean run;
    private ITimeCallback checkTenancyCasesCallback;

    public TimeLapse(final Date currentDate) {
        this.currentDate = currentDate;
        run = true;
    }

    public java.util.Date getCurrentDate() {
        return currentDate;
    }

    public void setCheckTenancyCasesCallback(final ITimeCallback checkTenancyCasesCallback) {
        this.checkTenancyCasesCallback = checkTenancyCasesCallback;
    }

    private void incrementDays() {
        currentDate = new Date(currentDate.getTime() + (1000 * 60 * 60 * 24));
    }

    public void start() {
        thread = new Thread(() -> {
            int counter = 0;
            while(run) {
                if(counter % 2 == 0) {
                    checkTenancyCasesCallback.callback();
                }

                incrementDays();

                try {
                    Thread.sleep(5000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        });
    }
    public Date getRentEnd(){
        return new Date(getCurrentDate().getTime()+15*1000*60*60*24);
    }
    public void stop() {
        run = false;
    }

    public boolean getrun(){
        return run;
    }
}
