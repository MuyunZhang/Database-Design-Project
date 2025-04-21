import java.util.ArrayList;
import java.util.Random;

public class testing2 {
    public static void main(String[] args) {
        String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] wings = {"N", "S", "E", "W"};
        String[] courseTypes = {"Elective", "Regents", "AP"};
        String[] assignmentTypes = {"Minor Assessment", "Major Assessment"};
        String[] departments = {"Math", "History", "Science", "English"};

        ArrayList<String> rooms = new ArrayList<>();
        Random rand = new Random();

        // Generate rooms
        for (String floor : floors) {
            for (String wing : wings) {
                for (int i = 1; i <= 20; i++) {
                    rooms.add(floor + wing + i);
                }
            }
        }

        // Generate Course Types
        System.out.println("INSERT INTO Course_Type (Course_TypeID, Course_Type) VALUES");
        for (int i = 0; i < courseTypes.length; i++) {
            System.out.printf("(%d, '%s')%s\n", i + 1, courseTypes[i], i == courseTypes.length - 1 ? ";" : ",");
        }

        // Generate Departments
        System.out.println("INSERT INTO Departments (Department_ID, Department_Name) VALUES");
        for (int i = 0; i < departments.length; i++) {
            System.out.printf("(%d, '%s')%s\n", i + 1, departments[i], i == departments.length - 1 ? ";" : ",");
        }

        // Generate Courses
        System.out.println("INSERT INTO Courses (Course_ID, Name, Course_TypeID) VALUES");
        for (int i = 1; i <= 10; i++) {
            String courseName = "Course" + i;
            int courseTypeId = rand.nextInt(3) + 1;
            System.out.printf("(%d, '%s', %d)%s\n", i, courseName, courseTypeId, i == 10 ? ";" : ",");
        }

        // Generate Teachers
        System.out.println("INSERT INTO Teachers (Teacher_ID, Teacher_Name, Department_ID) VALUES");
        for (int i = 1; i <= 5; i++) {
            String teacherName = "Teacher" + i;
            int departmentId = rand.nextInt(departments.length) + 1;
            System.out.printf("(%d, '%s', %d)%s\n", i, teacherName, departmentId, i == 5 ? ";" : ",");
        }

        // Generate Classes
        System.out.println("INSERT INTO Classes (Class_ID, Period, Course_ID, Teacher_ID, Room_ID) VALUES");
        for (int i = 1; i <= 10; i++) {
            int period = rand.nextInt(10) + 1;
            int courseId = rand.nextInt(10) + 1;
            int teacherId = rand.nextInt(5) + 1;
            int roomId = rand.nextInt(rooms.size());
            System.out.printf("(%d, %d, %d, %d, %d)%s\n", i, period, courseId, teacherId, roomId + 1, i == 10 ? ";" : ",");
        }

        // Generate Assignments
        System.out.println("INSERT INTO Assignments (Assignment_ID, Assignment_Name, Class_ID, Assignment_TypeID) VALUES");
        for (int i = 1; i <= 15; i++) {
            String assignmentName = "Assignment" + i;
            int classId = rand.nextInt(10) + 1;
            int assignmentTypeId = rand.nextInt(2) + 1;
            System.out.printf("(%d, '%s', %d, %d)%s\n", i, assignmentName, classId, assignmentTypeId, i == 15 ? ";" : ",");
        }

        // Generate Students
        System.out.println("INSERT INTO Students (Student_ID, Student_Name) VALUES");
        for (int i = 1; i <= 5000; i++) {
            System.out.printf("(%d, 'Student%d')%s\n", i, i, i == 5000 ? ";" : ",");
        }

        // Generate Schedule
        System.out.println("INSERT INTO Schedule (Student_ID, Class_ID) VALUES");
        for (int i = 1; i <= 5000; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("(%d, %d)%s\n", i, rand.nextInt(10) + 1, (i == 5000 && j == 10) ? ";" : ",");
            }
        }

        // Generate Grades
        System.out.println("INSERT INTO Grades (Assignment_ID, Grade, Student_ID) VALUES");
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 5000; j++) {
                int grade = rand.nextInt(26) + 75; // Random grade between 75 and 100
                System.out.printf("(%d, %d, %d)%s\n", i, grade, j, (i == 15 && j == 5000) ? ";" : ",");
            }
        }
    }
}
