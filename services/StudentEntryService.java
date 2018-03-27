package revision.services;

import revision.data.DataEntry;
import revision.modal.Marks;
import revision.modal.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StudentEntryService {

    static DataEntry de = new DataEntry();

    public static void enterStudentInformation(HashMap<Integer,ArrayList<Student>> si){

        System.out.println("Enter a Class you want to enter information for:-");
        int i = de.nextIntegerWithRange(1,10);

        if(si.get(i)!=null){
            ArrayList<Student> stdList = si.get(i);
            stdList.add(enterStudentInformation());
        }else{
            ArrayList<Student> stdList = new ArrayList<>();
            stdList.add(enterStudentInformation());
            si.put(i,stdList);
        }

    }

    public static void displayStudent(HashMap<Integer,ArrayList<Student>> si){

        Iterator<Integer> iterator = si.keySet().iterator();

        while (iterator.hasNext()) {
            int key = iterator.next();

            System.out.printf("\nDisplaying Information for Class %d ::::::::::::::::", key);

            ArrayList<Student> std = si.get(key);

            studentInformation(std);
        }
    }

    private static void studentInformation(ArrayList<Student> std){
        System.out.println("\n FirstName    |   LastName    |   Age |   Gender  |   RollNo  |\n");

        for (Student s : std) {
            String firstName = s.getFirstName();
            String lastName = s.getLastName();
            Integer age = s.getAge();
            Character gender = s.getGender();
            Integer rollNo = s.getRollNo();

            Marks mark = s.getMarks();

            HashMap<String,String> marksInfo = mark.getPassed();

            System.out.printf(" %s  |   %s  |   %d  |   %c  |   %d  |\n", firstName, lastName, age, gender, rollNo);

            System.out.printf("Displaying marks for %s %s\n",firstName,lastName);
            System.out.println("=========================================================================");
            System.out.println("    Math    |   English |   Science |   Nepali  |   Social Studies  |");
            System.out.printf("%f   |   %f  |   %f  |   %f  |   %f  |\n",mark.getMath(),mark.getEnglish(),mark.getScience(),mark.getNepali(),mark.getSocialStudies());
            System.out.println("=========================================================================");

            System.out.println("Result="+marksInfo.get("passFail"));
            System.out.println("Total="+marksInfo.get("total"));
            System.out.println("Grade="+marksInfo.get("grade"));
            System.out.println("Percentage="+marksInfo.get("percent"));

        }
    }

    private static Student enterStudentInformation(){
        Student std = new Student();
        System.out.println("Enter FirstName of Student");
        String firstName = de.next();

        System.out.println("Enter LastName of Student");

        String lastName = de.next();
        System.out.println("Enter age of Student");

        Integer age = de.nextInt();
        System.out.println("Enter gender of Student");

        Character gender = de.nextChar();

        System.out.println("Enter rollNo of Student");

        Integer rollNo = de.giveAnInteger();

        std.setFirstName(firstName);
        std.setLastName(lastName);
        std.setAge(age);
        std.setGender(gender);
        std.setRollNo(rollNo);
        std.setMarks(enterStudentMarks());
        return std;
    }

    public static Marks enterStudentMarks(){
        Marks marks = new Marks();
        System.out.println("Enter Marks for Nepali:-");
        marks.setNepali(de.nextDoubleWithRange(0,100));

        System.out.println("Enter Marks for English:-");
        marks.setEnglish(de.nextDoubleWithRange(0,100));

        System.out.println("Enter Marks for Math:-");
        marks.setMath(de.nextDoubleWithRange(0,100));

        System.out.println("Enter Marks for Science:-");
        marks.setScience(de.nextDoubleWithRange(0,100));

        System.out.println("Enter Marks for Social Studies:-");
        marks.setSocialStudies(de.nextDoubleWithRange(0,100));
        return marks;
    }


    public static void showStudentOfClass(HashMap<Integer,ArrayList<Student>> si, Integer ofClass){
        if(si.get(ofClass)==null){
            System.out.println("\n\n No Student found in class "+ ofClass+ "\n\n");
        }else{
            studentInformation(si.get(ofClass));
        }
    }



}
