package revision.modal.marks;

public class AlphabetGrading extends Result {

    public AlphabetGrading(double marks[]){
        total(marks);

        //9818414841
    }

    public String grade(){
        String grade="";
        double percentage = percentage();

        if(percentage<passmark){
            grade="F";
        }else if(percentage >passmark && percentage < 60){
            grade = "D";
        }else if(percentage >60 && percentage < 70){
            grade = "C";
        }else if(percentage >70 && percentage < 80){
            grade = "B";
        }else if(percentage >80 && percentage < 90){
            grade = "A";
        }else if(percentage >90 ){
            grade = "A+";
        }

        return grade;
    }
}
