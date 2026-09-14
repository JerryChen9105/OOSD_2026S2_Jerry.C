package SOLID_practice.student_sys;

public class Students implements Gradable {
    
    protected float totalScore;


    public Students(float totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public double getScore() {
        return (double)this.totalScore;
    }

}
