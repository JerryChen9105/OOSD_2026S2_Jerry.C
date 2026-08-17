package unimelb_grading_sys;

public enum SubjectType {
    decipline(0), breath(1), honours(2), research(3), other(4);

    private int typevalue;

    private String subjectTypeError = "Wrong value of subject type";

    SubjectType(int value) {
        this.typevalue = value;
    }

    public int getValue() {
        return typevalue;
    }

    public String nameString() {
        if (this.typevalue < 0 || this.typevalue > 4) {
            System.err.println(subjectTypeError);
            return null;
        }
        String[] list = {"Decipline", "Breath", "Honours", "Research", "Other"};
        return list[this.getValue()];
    }

}
