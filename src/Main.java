import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static ArrayList<Departments> Departments;

    static {
        try {
            Departments = generateDepartments();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ArrayList<Teachers> teachersArrayList = new ArrayList<>();
        ArrayList<String> fileData = getFileData("src/teachers");
        ArrayList<String> teacher = new ArrayList<>();
        ArrayList<String> department = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String teacher_name = list[0];
            teacher.add(teacher_name);
        }
        for (int i = 0; i < fileData.size(); i++) {
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String Department = list[1];
            department.add(Department);
        }
        for (int i = 1; i <= teacher.size(); i++) {
            String name = teacher.get(i - 1);
            int de = 0;
            for (int k = 0; k < Departments.size(); k++) {
                if (Departments.get(k).getDepartmentName().contains(department.get(k))) {
                    de = Departments.get(k).getDepartmentID();
                    System.out.println(de);
                }
            }
            Teachers teachers = new Teachers(i, name, de); //incomplete
            teachersArrayList.add(teachers);
        }
        for (int i = 0; i < teachersArrayList.size(); i++) {
            int k = i + 1;
            System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID) VALUES ( " + k + ", \"" + teachersArrayList.get(i).getName() + "\"" + ", " + teachersArrayList.get(i).getDepartmentid() + " );");
        }
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static ArrayList<Departments> generateDepartments() throws IOException {
        ArrayList<Departments> departmentsArrayList = new ArrayList<>();
        String[] departments = {"Biology", "Chemistry", "CTE, Computer Science & Engineering", "English",
                "Mathematics", "Physics", "Social Studies", "Visual & Performing Arts", "World Languages & ENL"};
        System.out.println(departments.length);
        for (int i = 1; i <= departments.length; i++) {
            String name = departments[i - 1];
            Departments department = new Departments(name, i);
            departmentsArrayList.add(department);
            String depart = "'" + departments[i - 1] + "'";
            System.out.println("INSERT INTO Departments ( Department_ID, Department_Name ) VALUES ( " + departmentsArrayList.get(i - 1).getDepartmentID() + ", " + departmentsArrayList.get(i - 1).getDepartmentName() + " );");
        }
        return departmentsArrayList;
    }
}
