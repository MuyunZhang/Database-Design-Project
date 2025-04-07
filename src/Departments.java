import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Departments {
    static String [] departments = {"Biology", "Chemistry", "CTE, Computer Science & Engineering", "English", "Mathematics", "Physics", "Social Studies", "Visual & Performing Arts", "World Languages & ENL"};

    public static void main(String[] args){
        System.out.println(departments.length);
        for (int i = 1; i <= departments.length; i++) {
            String department = "'" + departments[i-1] + "'";
            System.out.println("INSERT INTO Departments ( Department_ID, Department_Name ) VALUES ( " + i + ", " + department + " );");
        }
    }
}

