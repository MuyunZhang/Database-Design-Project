import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class testing {
    static Random rand = new Random();
    static String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
    static String[] wings = {"N", "S", "E", "W"};


    public static void main(String[] args) throws IOException {

        int total = 0;
        int score = 0;
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
        generateDepartments();
        generateRooms();
        generateCourseTypes();
        generateCourses();
        /*for (int i = 1; i <= fileData.size(); i++) {
            if (department.get(i - 1).contains("Biology")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 1 + " );");
            }
            if (department.get(i - 1).contains("Chemistry")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 2 + " );");
            }
            if (department.get(i - 1).contains("CTE, Computer Science & Engineering")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 3 + " );");
            }
            if (department.get(i - 1).contains("English")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 4 + " );");
            }
            if (department.get(i - 1).contains("Mathematics")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 5 + " );");
            }
            if (department.get(i - 1).contains("Physics")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 6 + " );");
            }
            if (department.get(i - 1).contains("Social Studies")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 7 + " );");
            }
            if (department.get(i - 1).contains("Visual & Performing Arts")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 8 + " );");
            }
            if (department.get(i - 1).contains("World Languages & ENL")) {
                System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teacher.get(i - 1) + "'" + ", " + 9 + " );");
            }
        } */
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

    public static ArrayList<Students> generateStudents(){
        ArrayList<Students> studentArrayList = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            String newName = "Student" + i;
            Students student = new Students(i, newName);
            studentArrayList.add(student);
            //System.out.println("INSERT INTO Students ( Student_ID, Student_name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
        return studentArrayList;
    }

    public static ArrayList<Teachers> generateTeachers() throws IOException {
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
        for (int i = 1; i <= teacher.size(); i ++){
            String name = teacher.get(i - 1);
            int de = 0;
            for(int k = 0; k < generateDepartments().size(); k++){
                if(generateDepartments().get(k).getDepartmentName().contains(department.get(k))) {
                    de = generateDepartments().get(k).getDepartmentID();
                }
            }
            Teachers teachers = new Teachers(i, name, de, i); //incomplete
            teachersArrayList.add(teachers);
        }
        for (int i = 0; i < teachersArrayList.size(); i ++){
            System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID ) VALUES ( " + i + ", '" + teachersArrayList.get(i).getName() + "'" + ", " + 9 + ", " + 9 + " );");
        }
        return teachersArrayList;
    }

    public static ArrayList<Departments> generateDepartments() throws IOException {
        ArrayList<Departments> departmentsArrayList = new ArrayList<>();
        String [] departments = {"Biology", "Chemistry", "CTE, Computer Science & Engineering", "English",
                "Mathematics", "Physics", "Social Studies", "Visual & Performing Arts", "World Languages & ENL"};
        System.out.println(departments.length);
        for (int i = 1; i <= departments.length; i++) {
            String name = departments[i-1];
            Departments department = new Departments(name,i);
            departmentsArrayList.add(department);
            String depart = "'" + departments[i-1] + "'";
            System.out.println("INSERT INTO Departments ( Department_ID, Department_Name ) VALUES ( " + departmentsArrayList.get(i-1).getDepartmentID() + ", " + departmentsArrayList.get(i-1).getDepartmentName() + " );");
        }
        return departmentsArrayList;
    }

    public static ArrayList<CourseType> generateCourseTypes() throws IOException{
        ArrayList<CourseType> courseArrayList = new ArrayList<>();
        String [] types = {"AP", "Regents", "Elective"};
        for (int i = 1; i <= types.length; i++) {
            String name = types[i-1];
            CourseType courseType = new CourseType(i,name);
            courseArrayList.add(courseType);
            System.out.println("INSERT INTO Course_Type ( Course_TypeID, Course_Type ) VALUES ( " + i + ", ' " + types[i-1] + "' );");
        }
        return courseArrayList;
    }

    public static ArrayList<Rooms> generateRooms() throws IOException{
        ArrayList<Rooms> roomsArrayList = new ArrayList<>();
        String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] wing = {"N", "S", "E", "W"};
        int count = 1;
        //rooms
        for (int k = 0; k < 9; k ++) {
            for (int w = 0; w < 4; w ++) {
                for (int i = 1; i <= 20; i++) {
                    String name = floors[k] + wing[w] + i;
                    Rooms room = new Rooms(name, count);
                    roomsArrayList.add(room);
                    System.out.println("INSERT INTO Rooms ( Room_ID, Room_Name ) VALUES ( " + roomsArrayList.get(count-1).getRoomID() + ", ' " + roomsArrayList.get(count-1).getRoom() + "' );");
                    count ++;
                }
            }
        }
        return roomsArrayList;
    }

    public static ArrayList<AssignmentType> generateAssignmentType() throws IOException{
        ArrayList<AssignmentType> assignmentTypeArrayList = new ArrayList<>();
        String [] types = {"Minor Assessment", "Major Assessment"};
        for (int i = 1; i <= types.length; i++) {
            String name = types[i-1];
            AssignmentType assignmentType = new AssignmentType(i - 1, name);
            assignmentTypeArrayList.add(assignmentType);
            System.out.println("INSERT INTO Assignment_Type ( Assignment_TypeID, Assignment_Type ) VALUES ( " + i + ", ' " + types[i-1] + "' );");
        }
        return assignmentTypeArrayList;
    }

    public static ArrayList<Courses> generateCourses() throws IOException{
        ArrayList<Courses> coursesArrayList = new ArrayList<>();
        ArrayList<String> all_courses = new ArrayList<>();
        ArrayList<String> data = getFileData("src/courses");

        ArrayList<String> fileData = getFileData("src/courses");
        ArrayList<String> course = new ArrayList<>();
        for(int i = 1; i <= fileData.size(); i ++){
            String name = fileData.get(i-1);
            int typeid = 0;
            if(name.contains("AP") && !name.contains("Pre-AP")){
                typeid = 1;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + name + "', " + 1 + ");");
            }
            else if(name.contains("Regents")){
                typeid = 2;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + name + "', " + 2 + ");");
            }
            else {
                typeid = 3;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + name + "', " + 3 + ");");
            }
            Courses courses = new Courses(i, name, typeid);
            coursesArrayList.add(courses);
        }
        return coursesArrayList;
    }
}

