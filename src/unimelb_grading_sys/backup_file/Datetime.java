package unimelb_grading_sys.backup_file;

public class Datetime {
    String date;
    String time;

    static String DatetimeError = "Invalid datetime formation";

    public Datetime(int year, int month, int day) {
        this.date = String.join("-", Integer.toString(year), Integer.toString(month), Integer.toString(day));
        this.time = "00:00:00";
    }

    public String getDatetime() {
        return this.date + " " + this.time;
    }

    public boolean addTime (int hour, int min, int sec) {
        if (!(0 <= hour) || !(hour < 24)) {
            System.err.println(DatetimeError);
            return false;
        }
        if (!(0 <= min) || !(min < 60)) {
            System.err.println(DatetimeError);
            return false;
        }
        if (!(0 <= sec) || !(sec < 60)) {
            System.err.println(DatetimeError);
            return false;
        }
        this.time = String.join("-", Integer.toString(hour), Integer.toString(min), Integer.toString(sec));
        return true;
    }

}
