package revision.modal.marks;

public abstract class Result implements Grading {

    protected double totalMarks = 500;
    public double totalMarksObtained;
    public boolean isPassed = true;
    public double passmark =32;


    protected void total(double[] marks){
        totalMarksObtained = 0;
        for(int i=0; i<marks.length;i++){
            if(marks[i]< passmark){
                isPassed = false;
                totalMarksObtained =0;
                break;
            }
            totalMarksObtained+=marks[i];
        }

    }

    public double total(){
        return totalMarksObtained;
    }

    public boolean isPassed(){
        return isPassed;
    }

    public double percentage(){
        return (totalMarksObtained/totalMarks)*100;
    }


}
