package revision.modal.marks;

public class DivisionGrading extends Result {

    public DivisionGrading(double marks[]){
        total(marks);
    }

    public String grade(){
        String grade="";
        double percentage = percentage();

        if(percentage<passmark){
            grade="Fail";
        }else if(percentage >passmark && percentage < 60){
            grade = "3rd";
        }else if(percentage >60 && percentage < 70){
            grade = "2nd";
        }else if(percentage >70 && percentage < 80){
            grade = "1st";
        }else if(percentage >80 && percentage < 90){
            grade = "Distinction";
        }else if(percentage >90 ){
            grade = "Outstanding";
        }

        return grade;
    }
}
