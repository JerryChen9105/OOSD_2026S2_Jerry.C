package unimelb_grading_sys;

public class Grade {
    float score;
    GradeMark gm;

    static String gradeRangeError = "out of the normal score range";

    public enum GradeMark {
        N(0), NH(1), P(2), H3(3), H2B(4), H2A(5), H1(6), CNT(7);

        private int gm;

        GradeMark (int gm) {
            this.gm = gm;
        }

        public int getValue() {
            return gm;
        }
    }

    public GradeMark getGradeMark(float score) {
        if (score < -100 || score > 100) {
            System.err.println(gradeRangeError);
            return null;
        }
        if (score == -1) return GradeMark.CNT;
        if (score < 0) return GradeMark.NH;
        if (score < 50) return GradeMark.N;
        if (score < 60) return GradeMark.P;
        if (score < 70) return GradeMark.H3;
        if (score < 75) return GradeMark.H2B;
        if (score < 80) return GradeMark.H2A;
        return GradeMark.H1;
    }

    public String nameString(float score) {
        String[] list = {"N", "NH", "P", "H3", "H2B", "H2A", "H1", "CNT"};
        return list[getGradeMark(score).getValue()];
    }

    public Grade(float score) {
        if (score < -100 || score > 100) {
            System.err.println(gradeRangeError);
            this.score = 0;
            this.gm = GradeMark.CNT;
        } else {
            this.score = score;
            this.gm = getGradeMark(score);
        }
    }
}
