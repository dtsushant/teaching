package revision;

import revision.data.DataEntry;
import revision.modal.Student;
import revision.services.StudentEntryService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainRevision {

    static HashMap<Integer, ArrayList<Student>> studentInformation = new HashMap<>();

    public static void main(String args[]) {


        DataEntry de = new DataEntry();

        Boolean keepGoing= true;

        do{
            System.out.println("Please Enter what do you want to do:-");
            System.out.println("Enter new Student Information: 1");
            System.out.println("Enter Marks for Student: 2");
            System.out.println("Display All Student: 3");
            System.out.println("Display Student of Class: 4");
            System.out.println("Display Marks of a Student: 5");
            System.out.println("Exit the program: 6");

            Integer option = de.giveAnInteger();

            switch (option){
                case 1:
                    StudentEntryService.enterStudentInformation(studentInformation);
                    break;
                case 2:
                    break;
                case 3:
                    StudentEntryService.displayStudent(studentInformation);
                    break;
                case 4:
                    System.out.println("Enter the class you want to see student of:-");
                    Integer forClass = de.giveAnInteger();
                    StudentEntryService.showStudentOfClass(studentInformation,forClass);
                    break;
                case 5:
                    break;
                default:
                    keepGoing = false;
                    break;
            }
        }while (keepGoing);
    }

}
