package revision.modal;

import revision.modal.marks.AlphabetGrading;
import revision.modal.marks.DivisionGrading;
import revision.modal.marks.Grading;

import java.util.HashMap;
import java.util.Random;

public class Marks {
    private Double nepali;
    private Double english;
    private Double math;
    private Double science;
    private Double socialStudies;

    private Grading g;


    public Marks(){

    }

    public Double getNepali() {
        return nepali;
    }

    public void setNepali(Double nepali) {
        this.nepali = nepali;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getScience() {
        return science;
    }

    public void setScience(Double science) {
        this.science = science;
    }

    public Double getSocialStudies() {
        return socialStudies;
    }

    public void setSocialStudies(Double socialStudies) {
        this.socialStudies = socialStudies;
    }

    public HashMap<String,String> getPassed(){

        HashMap<String ,String> resultmap = new HashMap<>();

        Random random = new Random();
        int i = random.nextInt(10)+1;
        double[] marks ={math,science,english,nepali,socialStudies};
        if(i%2==0){
            g = new DivisionGrading(marks);
        }else{
            g = new AlphabetGrading(marks);
        }

        resultmap.put("percent",String.valueOf(g.percentage()));
        resultmap.put("grade",g.grade());
        resultmap.put("total",String.valueOf(g.total()));
        resultmap.put("passFail",g.isPassed()?"Pass":"Fail");

        return resultmap;
    }

}
