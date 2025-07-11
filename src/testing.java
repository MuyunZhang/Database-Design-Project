import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class testing {

    static ArrayList<AssignmentType> AssignmentTypes;

    static {
        try {
            AssignmentTypes = generateAssignmentType();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Departments> Departments;

    static {
        try {
            Departments = generateDepartments();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Rooms> Rooms;

    static {
        try {
            Rooms = generateRooms();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<CourseType> Coursetypes;

    static {
        try {
            Coursetypes = generateCourseTypes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Courses> Courses;

    static {
        try {
            Courses = generateCourses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Teachers> Teachers;
    static {
        try {
            Teachers = generateTeachers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Classes> Classes;

    static {
        try {
            Classes = generateClasses();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Assignments> Assignments;

    static {
        try {
            Assignments = generateAssignments();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static ArrayList<Students> Students = generateStudents();

    static ArrayList<Schedule> Schedules;

    static {
        try {
            Schedules = generateSchedules();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


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
        generateGrades();
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

    public static ArrayList<Students> generateStudents() {
        ArrayList<Students> studentArrayList = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            String newName = "Student" + i;
            Students student = new Students(newName, i, i);
            studentArrayList.add(student);
            System.out.println("INSERT INTO Students ( Student_ID, Student_Name ) VALUES ( " + i + ", 'Student" + i + "' );");
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
        for(int i = 1; i <= teacher.size(); i ++){
            if(department.get(i-1).contains("Biology")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 1); //incomplete
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("Chemistry")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 2);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("CTE, Computer Science & Engineering")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 3);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("English")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 4);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("Health & PE")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 5);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("Mathematics")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 6);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("Physics")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 7);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("Social Studies")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 8);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("Visual & Performing Arts")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 9);
                teachersArrayList.add(teachers);
            }
            if(department.get(i-1).contains("World Languages & ENL")){
                Teachers teachers = new Teachers(i, teacher.get(i-1), 10);
                teachersArrayList.add(teachers);
            }
        }
        for (int i = 0; i < teachersArrayList.size(); i++) {
            int k = i + 1;
            System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID) VALUES ( " + k + ", \"" + teachersArrayList.get(i).getName() + "\"" + ", " + teachersArrayList.get(i).getDepartmentid()  + " );");
        }
        return teachersArrayList;
    }

    public static ArrayList<Departments> generateDepartments() throws IOException {
        ArrayList<Departments> departmentsArrayList = new ArrayList<>();
        String[] departments = {"Biology", "Chemistry", "CTE, Computer Science & Engineering", "English", "Health & PE",
                "Mathematics", "Physics", "Social Studies", "Visual & Performing Arts", "World Languages & ENL"};
        for (int i = 1; i <= departments.length; i++) {
            String name = departments[i - 1];
            Departments department = new Departments(name, i);
            departmentsArrayList.add(department);
            String depart = "'" + departments[i - 1] + "'";
            System.out.println("INSERT INTO Departments ( Department_ID, Department_Name ) VALUES ( " + departmentsArrayList.get(i - 1).getDepartmentID() + ", \"" + departmentsArrayList.get(i - 1).getDepartmentName() + "\" );");
        }
        return departmentsArrayList;
    }

    public static ArrayList<CourseType> generateCourseTypes() throws IOException {
        ArrayList<CourseType> courseTypeArrayList = new ArrayList<>();
        String[] types = {"AP", "Regents", "Elective"};
        for (int i = 1; i <= types.length; i++) {
            String name = types[i - 1];
            CourseType courseType = new CourseType(i, name);
            courseTypeArrayList.add(courseType);
            System.out.println("INSERT INTO Course_Type ( Course_TypeID, Course_Type ) VALUES ( " + i + ", '" + types[i - 1] + "' );");
        }
        return courseTypeArrayList;
    }

    public static ArrayList<Rooms> generateRooms() throws IOException {
        ArrayList<Rooms> roomsArrayList = new ArrayList<>();
        String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] wing = {"N", "S", "E", "W"};
        int count = 1;
        for (int k = 0; k < 9; k++) {
            for (int w = 0; w < 4; w++) {
                for (int i = 1; i <= 20; i++) {
                    String name = floors[k] + wing[w] + i;
                    Rooms room = new Rooms(name, count);
                    roomsArrayList.add(room);
                    System.out.println("INSERT INTO Rooms ( Room_ID, Room_Name ) VALUES ( " + roomsArrayList.get(count - 1).getRoomID() + ", '" + roomsArrayList.get(count - 1).getRoom() + "' );");
                    count++;
                }
            }
        }
        return roomsArrayList;
    }

    public static ArrayList<AssignmentType> generateAssignmentType() throws IOException {
        ArrayList<AssignmentType> assignmentTypeArrayList = new ArrayList<>();
        String[] types = {"Minor Assessment", "Major Assessment"};
        for (int i = 1; i <= types.length; i++) {
            String name = types[i - 1];
            AssignmentType assignmentType = new AssignmentType(i - 1, name);
            assignmentTypeArrayList.add(assignmentType);
            System.out.println("INSERT INTO Assignment_Type ( Assignment_TypeID, Assignment_Type ) VALUES ( " + i + ", '" + types[i - 1] + "' );");
        }
        return assignmentTypeArrayList;
    }

    public static ArrayList<Courses> generateCourses() throws IOException {
        ArrayList<Courses> coursesArrayList = new ArrayList<>();
        ArrayList<String> fileData = getFileData("src/courses");
        for (int i = 1; i <= fileData.size(); i++) {
            String name = fileData.get(i - 1);
            int typeid = 0;
            if (name.contains("AP") && !name.contains("Pre-AP") && !name.contains("-AP")) {
                typeid = 1;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", \"" + name + "\", " + 1 + ");");
            } else if (name.contains("Regents")) {
                typeid = 2;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", \"" + name + "\", " + 2 + ");");
            } else {
                typeid = 3;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", \"" + name + "\", " + 3 + ");");
            }
            Courses courses = new Courses(i, name, typeid);
            coursesArrayList.add(courses);
        }
        return coursesArrayList;
    }
    public static ArrayList<Classes> generateClasses() throws IOException {
        ArrayList<Classes> classesArrayList = new ArrayList<>();
        int classIDCounter = 1;
        ArrayList<String> fileData = getFileData("src/teachers");
        ArrayList<String> teacher = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String teacher_name = list[0];
            teacher.add(teacher_name);
        }

        for (int i = 0; i < Courses.size(); i++) {
            int offerings = (int) (Math.random() * (5 - 1 + 1)) + 1;
            int courseID = Courses.get(i).getCourseid();
            int roommax = Rooms.size();

            for (int k = 0; k < offerings; k++) {
                boolean unique = false;
                int randomPeriod = 0;
                int whichroom = 0;

                while (!unique) {
                    randomPeriod = (int) (Math.random() * 10) + 1;
                    whichroom = (int) (Math.random() * roommax) + 1;

                    unique = true;
                    for (int g = 0; g < classesArrayList.size(); g++) {
                        if (classesArrayList.get(g).getPeriod() == randomPeriod &&
                                classesArrayList.get(g).getRoomID() == whichroom) {
                            unique = false;
                            break;
                        }
                    }
                }
                int teacherID = (int) (Math.random() * teacher.size()) + 1;

                Classes newClass = new Classes(classIDCounter, randomPeriod, teacherID, courseID, whichroom);
                classesArrayList.add(newClass);
                classIDCounter++;
            }
        }

        for (int i = 0; i < classesArrayList.size(); i++) {
            System.out.println("INSERT INTO Classes (Class_ID, Period, Course_ID, Teacher_ID, Room_ID) VALUES ("
                    + classesArrayList.get(i).getClassID() + ", "
                    + classesArrayList.get(i).getPeriod() + ", "
                    + classesArrayList.get(i).getCourseID() + ", "
                    + classesArrayList.get(i).getTeacherID() + ", "
                    + classesArrayList.get(i).getRoomID() + ");");
        }
        return classesArrayList;
    }

    public static ArrayList<Assignments> generateAssignments() throws IOException {
        ArrayList<Assignments> assignmentsArrayList = new ArrayList<>();
        int assignmentIDCounter = 1;

        int minorTypeID = 1;
        int majorTypeID = 2;

        for (int i = 0; i < Classes.size(); i++) {
            int classID = Classes.get(i).getClassID();

            for (int j = 0; j < 12; j++) {
                String assignmentName = "Minor Assignment " + (j + 1) + " Class " + classID;
                Assignments minorAssignment = new Assignments(assignmentName, assignmentIDCounter, minorTypeID, classID);
                assignmentsArrayList.add(minorAssignment);
                assignmentIDCounter++;
            }

            for (int j = 0; j < 3; j++) {
                String assignmentName = "Major Assignment " + (j + 1) + " Class " + classID;
                Assignments majorAssignment = new Assignments(assignmentName, assignmentIDCounter, majorTypeID, classID);
                assignmentsArrayList.add(majorAssignment);
                assignmentIDCounter++;
            }
        }

        for (int i = 0; i < assignmentsArrayList.size(); i++) {
            System.out.println("INSERT INTO Assignments (Assignment_Name, Assignment_ID, Class_ID, Assignment_TypeID) VALUES ('"
                    + assignmentsArrayList.get(i).getName() + "', "
                    + assignmentsArrayList.get(i).getId() + ", "
                    + assignmentsArrayList.get(i).getClassid() + ", "
                    + assignmentsArrayList.get(i).getTypeid() + ");");
        }
        return assignmentsArrayList;
    }

    public static ArrayList<Schedule> generateSchedules() throws IOException{
        ArrayList<Schedule> scheduleArrayList = new ArrayList<Schedule>();
        int scheduleID = 0;
        for(int s = 0; s < Students.size(); s ++) {
            ArrayList<Classes> studentClasses = new ArrayList<>();
            for (int period = 1; period <= 10; period++) {
                int randomClassID = (int) (Math.random() * Classes.size()) + 1;
                boolean isValid = false;
                while (!isValid){
                    if(Classes.get(randomClassID - 1).getPeriod() == period){
                        scheduleID ++;
                        Schedule schedule = new Schedule(scheduleID, s+1, Classes.get(randomClassID - 1).getClassID());
                        scheduleArrayList.add(schedule);
                        System.out.println("INSERT INTO Schedule (Schedule_ID, Student_ID, Class_ID) VALUES (" + (scheduleID) + ", " + scheduleArrayList.get(scheduleID - 1).getStudentID() + ", " + scheduleArrayList.get(scheduleID - 1).getClassID() + ");");
                        isValid = true;
                    }
                    else{
                        randomClassID = (int) (Math.random() * Classes.size()) + 1;
                    }
                }
            }
        }
        return scheduleArrayList;
    }


    public static ArrayList<Grades> generateGrades() throws IOException{
        ArrayList<Grades> gradesArrayList = new ArrayList<>();
        int gradeid = -1;
        for(int i = 0; i < Schedules.size(); i ++){
            int classid = Schedules.get(i).getClassID();
            int student = Schedules.get(i).getStudentID();
            for(int k = 0; k < Assignments.size(); k ++){
                if(Assignments.get(k).getClassid() == classid){
                    int grade = (int) (Math.random() * 26) + 75;
                    int assignmentid = Assignments.get(k).getId();
                    Grades Grade = new Grades(grade, assignmentid, student);
                    gradesArrayList.add(Grade);
                    gradeid++;
                    System.out.println("INSERT INTO Grades (Assignment_ID, Grade, Student_ID) VALUES (" + gradesArrayList.get(gradeid).getAssignmentID() + ", " + gradesArrayList.get(gradeid).getGrade() + ", " + gradesArrayList.get(gradeid).getStudentID() + ");");
                }
            }
        }
        return gradesArrayList;
    }
}
