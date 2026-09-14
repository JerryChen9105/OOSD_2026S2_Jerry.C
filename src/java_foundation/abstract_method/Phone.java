package java_foundation.abstract_method;

public abstract class Phone {

    String IP;
    int fieldNum;
    String phoneNum;

    public Phone(String IP, int fieldNum, String phoneNum)
    {
        if (IP.isEmpty() || phoneNum.isEmpty()) {
            this.IP = null;
            fieldNum = -1;
            phoneNum = null;
            return;
        }
        this.IP = IP;
        this.fieldNum = fieldNum;
        this.phoneNum = phoneNum;
    }

    public abstract void call(Phone phone);

}
