import java.io.*;
import java.util.*;

public class testing {
    static Random rand = new Random();
    static String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
    static String[] wings = {"N", "S", "E", "W"};
    static int ROOM_MAX = 20;

    public static void main(String[] args) throws IOException {
        generateRooms();
        generateDepartments("teachers.txt");
        generateTeachers("teachers.txt");
        generateCourses("courses.txt");
        generateCourseTypes();
        generateAssignmentTypes();
        generateStudents(5000);
        generateClasses();
        generateAssignments();
        generateGrades();
        generateSchedules();
    }

    static void generateRooms() {
        int id = 1;
        for (String floor : floors) {
            for (String wing : wings) {
                for (int i = 1; i <= ROOM_MAX; i++) {
                    String room = floor + wing + i;
                    System.out.println("INSERT INTO Rooms VALUES (" + id++ + ", '" + room + "');");
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
}
