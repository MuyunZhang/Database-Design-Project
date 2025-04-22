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
        for (int i = 1; i <= fileData.size(); i++) {
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

    public ArrayList<Students> GenerateStudents(){
        ArrayList<Students> studentArrayList = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            String newName = "Student" + i;
            Students student = new Students(i, newName);
            studentArrayList.add(student);
            System.out.println("INSERT INTO Students ( Student_ID, Student_name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }
        return studentArrayList;
    }

    public ArrayList<Teachers> GenerateTeachers(){
        ArrayList<Teachers> teachersArrayList = new ArrayList<>();
        return teachersArrayList;
    }
}


    /*static void generateRooms() {
        //rooms
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int k = 0; k < 9; k ++) {
            for (int w = 0; w < 4; w ++) {
                for (int i = 1; i <= 20; i++) {
                    rooms.add(i);
                    System.out.println(floors[k] + wings[w] + i);
                }
            }
        }
    }


    static void generateDepartments(String teacherFile) throws IOException {
        Set<String> departments = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(teacherFile))) {
            String line;
            int id = 1;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (departments.add(parts[1])) {
                    System.out.println("INSERT INTO Departments VALUES (" + id++ + ", '" + parts[1].trim() + "');");
                }
            }
        }
    }

    static void generateTeachers(String teacherFile) throws IOException {
        Map<String, Integer> departmentMap = new HashMap<>();
        int deptId = 1;
        int id = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(teacherFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String name = parts[0].trim();
                String dept = parts[1].trim();
                if (!departmentMap.containsKey(dept)) {
                    departmentMap.put(dept, deptId++);
                }
                System.out.println("INSERT INTO Teachers VALUES (" + id++ + ", '" + name + "', " + departmentMap.get(dept) + ");");
            }
        }
    }

    static void generateCourses(String courseFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(courseFile))) {
            String line;
            int id = 1;
            while ((line = br.readLine()) != null) {
                String name = line.trim();
                int typeId = rand.nextInt(3) + 1; // 1-3 for Elective, Regents, AP
                System.out.println("INSERT INTO Courses VALUES (" + id++ + ", '" + name + "', " + typeId + ");");
            }
        }
    }

    static void generateCourseTypes() {
        System.out.println("INSERT INTO Course_Type VALUES (1, 'Elective');");
        System.out.println("INSERT INTO Course_Type VALUES (2, 'Regents');");
        System.out.println("INSERT INTO Course_Type VALUES (3, 'AP');");
    }

    static void generateAssignmentTypes() {
        System.out.println("INSERT INTO Assignment_Type VALUES (1, 'Minor Assessment');");
        System.out.println("INSERT INTO Assignment_Type VALUES (2, 'Major Assessment');");
    }

    static void generateStudents(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println("INSERT INTO Students VALUES (" + i + ", 'Student" + i + "');");
        }
    }

    static void generateClasses() {
        int id = 1;
        for (int period = 1; period <= 10; period++) {
            for (int i = 1; i <= 5; i++) {
                int courseId = rand.nextInt(100) + 1; // Random course
                int teacherId = rand.nextInt(50) + 1; // Random teacher
                int roomId = rand.nextInt(160) + 1; // Random room
                System.out.println("INSERT INTO Classes VALUES (" + id++ + ", " + period + ", " + courseId + ", " + teacherId + ", " + roomId + ");");
            }
        }
    }

    static void generateAssignments() {
        int id = 1;
        for (int classId = 1; classId <= 50; classId++) {
            for (int i = 0; i < 15; i++) {
                String name = "Assignment " + (i + 1);
                int typeId = (i < 12) ? 1 : 2; // 12 Minor, 3 Major
                System.out.println("INSERT INTO Assignments VALUES ('" + name + "', " + id++ + ", " + classId + ", " + typeId + ");");
            }
        }
    }

    static void generateGrades() {
        for (int studentId = 1; studentId <= 5000; studentId++) {
            for (int assignmentId = 1; assignmentId <= 15; assignmentId++) {
                int grade = rand.nextInt(26) + 75; // Grades between 75 and 100
                System.out.println("INSERT INTO Grades VALUES (" + assignmentId + ", " + grade + ", " + studentId + ");");
            }
        }
    }

    static void generateSchedules() {
        for (int studentId = 1; studentId <= 5000; studentId++) {
            for (int period = 1; period <= 10; period++) {
                int classId = rand.nextInt(50) + 1; // Random class
                System.out.println("INSERT INTO Schedule VALUES (" + studentId + ", " + classId + ");");
            }
        }
    }
} */
