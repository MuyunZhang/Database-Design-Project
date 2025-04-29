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

    static ArrayList<Teachers> Teachers;

    static {
        try {
            Teachers = generateTeachers();
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

    static ArrayList<Students> Students = generateStudents();

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

    static ArrayList<AssignmentType> AssignmentTypes;

    static {
        try {
            AssignmentTypes = generateAssignmentType();
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

        /*ArrayList<Departments> Departments = generateDepartments();
        generateStudents();
        generateTeachers();
        generateDepartments();
        generateRooms();
        generateCourseTypes();
        generateCourses();
        generateClasses(); */
        //generateAssignmentType();
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

    public static ArrayList<Students> generateStudents() {
        ArrayList<Students> studentArrayList = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            String newName = "Student" + i;
            Students student = new Students(newName, i, i);
            studentArrayList.add(student);
            System.out.println("INSERT INTO Students ( Student_ID, Student_name ) VALUES ( " + i + ", 'Student" + i + "' );");
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
        for (int i = 1; i <= teacher.size(); i++) {
            String name = teacher.get(i - 1);
            int de = 0;
            for (int k = 0; k < Departments.size(); k++) {
                if (Departments.get(k).getDepartmentName().contains(department.get(k))) {
                    de = Departments.get(k).getDepartmentID();
                }
            }
            ArrayList<Integer> classid = new ArrayList<Integer>();
            for (int j = 0; j < Classes.size(); j ++){
                int teachid = Classes.get(j).getTeacherID();
                if(teachid == i){
                    int idforclass = Classes.get(j).getClassID();
                    classid.add(idforclass);
                }
            }
            for (int g = 0; g < classid.size(); g++){
                for(int o = 0; o < Assignments.size(); o++){
                    if(Assignments.get(o).getClassid() == g+1){
                        Teachers teachers = new Teachers(i, name, de, o+1); //incomplete
                        teachersArrayList.add(teachers);
                    }
                }
            }
        }
        for (int i = 0; i < teachersArrayList.size(); i++) {
            System.out.println("INSERT INTO Teachers ( Teacher_ID, Teacher_Name, Department_ID, Assignment_ID ) VALUES ( " + i + ", '" + teachersArrayList.get(i).getName() + "'" + ", " + 9 + ", " + teachersArrayList.get(i).getAssignmentid() + " );");
        }
        return teachersArrayList;
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

    public static ArrayList<CourseType> generateCourseTypes() throws IOException {
        ArrayList<CourseType> courseArrayList = new ArrayList<>();
        String[] types = {"AP", "Regents", "Elective"};
        for (int i = 1; i <= types.length; i++) {
            String name = types[i - 1];
            CourseType courseType = new CourseType(i, name);
            courseArrayList.add(courseType);
            System.out.println("INSERT INTO Course_Type ( Course_TypeID, Course_Type ) VALUES ( " + i + ", ' " + types[i - 1] + "' );");
        }
        return courseArrayList;
    }

    public static ArrayList<Rooms> generateRooms() throws IOException {
        ArrayList<Rooms> roomsArrayList = new ArrayList<>();
        String[] floors = {"B", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] wing = {"N", "S", "E", "W"};
        int count = 1;
        //rooms
        for (int k = 0; k < 9; k++) {
            for (int w = 0; w < 4; w++) {
                for (int i = 1; i <= 20; i++) {
                    String name = floors[k] + wing[w] + i;
                    Rooms room = new Rooms(name, count);
                    roomsArrayList.add(room);
                    System.out.println("INSERT INTO Rooms ( Room_ID, Room_Name ) VALUES ( " + roomsArrayList.get(count - 1).getRoomID() + ", ' " + roomsArrayList.get(count - 1).getRoom() + "' );");
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
            System.out.println("INSERT INTO Assignment_Type ( Assignment_TypeID, Assignment_Type ) VALUES ( " + i + ", ' " + types[i - 1] + "' );");
        }
        return assignmentTypeArrayList;
    }

    public static ArrayList<Courses> generateCourses() throws IOException {
        ArrayList<Courses> coursesArrayList = new ArrayList<>();
        ArrayList<String> all_courses = new ArrayList<>();
        ArrayList<String> data = getFileData("src/courses");

        ArrayList<String> fileData = getFileData("src/courses");
        ArrayList<String> course = new ArrayList<>();
        for (int i = 1; i <= fileData.size(); i++) {
            String name = fileData.get(i - 1);
            int typeid = 0;
            if (name.contains("AP") && !name.contains("Pre-AP")) {
                typeid = 1;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + name + "', " + 1 + ");");
            } else if (name.contains("Regents")) {
                typeid = 2;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + name + "', " + 2 + ");");
            } else {
                typeid = 3;
                System.out.println("INSERT INTO Courses ( Course_ID, Name, Course_TypeID ) VALUES ( " + i + ", '" + name + "', " + 3 + ");");
            }
            Courses courses = new Courses(i, name, typeid);
            coursesArrayList.add(courses);
        }
        return coursesArrayList;
    }
    public static ArrayList<Classes> generateClasses() throws IOException {
    /* private int classID;
       private int period;
       private int teacherID;
       private int courseID;
       private int roomID; */
        ArrayList<Classes> classesArrayList = new ArrayList<>();
        int classIDCounter = 1;

        ArrayList<Courses> courseArrayList = generateCourses();
        ArrayList<String> fileData = getFileData("src/teachers");
        ArrayList<String> teacher = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            int len = fileData.size();
            String[] list = fileData.get(i).split("\\|");
            String teacher_name = list[0];
            teacher.add(teacher_name);
        }

        for (int i = 0; i < courseArrayList.size(); i++) {
            int offerings = (int) (Math.random() * (5 - 1 + 1)) + 1; // 1 to 5 offerings
            int courseID = Courses.get(i).getCourseid();
            int roommax = Rooms.size();

            for (int k = 0; k < offerings; k++) {
                boolean unique = false;
                int randomPeriod = 0;
                int whichroom = 0;

                while (!unique) {
                    randomPeriod = (int) (Math.random() * 10) + 1; // Period 1 to 10
                    whichroom = (int) (Math.random() * roommax) + 1; // Room 1 to roommax

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
    /* private String name;
       private int id;
       private int typeid;
       private int classid; */

        ArrayList<Assignments> assignmentsArrayList = new ArrayList<>();
        int assignmentIDCounter = 1;

        int minorTypeID = 1;
        int majorTypeID = 2;

        for (int i = 0; i < Classes.size(); i++) {
            int classID = Classes.get(i).getClassID();

            // Create 12 minor assignments
            for (int j = 0; j < 12; j++) {
                String assignmentName = "Minor Assignment " + (j + 1) + " Class " + classID;
                Assignments minorAssignment = new Assignments(assignmentName, assignmentIDCounter, minorTypeID, classID);
                assignmentsArrayList.add(minorAssignment);
                assignmentIDCounter++;
            }

            // Create 3 major assignments
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


    public static ArrayList<Grades> generateGrades() throws IOException{
        ArrayList<Grades> gradesArrayList = new ArrayList<>();
        for(int i = 0; i < Students.size(); i ++){

        }
        int grade = (int) (Math.random() * 100 - 75) + 75;


        return gradesArrayList;
    }
}

//classes is basically course offerings
    /*public static ArrayList<Classes> generateClasses() throws IOException {
        /*private int classID;
        private int period;
        private int teacherID;
        private int courseID;
        private int roomID;
        ArrayList<Classes> classesArrayList = new ArrayList<>();
        for (int i = 0; i < generateCourses().size(); i++) {
            int offerings = (int) (Math.random() * (5 - 1 + 1)) + 1;
            int courseID = generateCourses().get(i).getCourseid();
            int roommax = generateRooms().size();
            int whichroom = (int) (Math.random() * roommax) +1;
            System.out.println(whichroom);
            for (int k = 0; k < offerings; k++) {
                for(int g = 0; g < classesArrayList.size(); g ++){
                    if(classesArrayList.get(g).getRoomID() == 2 && classesArrayList.get(i).getPeriod() == 4)
                }
            }
            //list of classes, adding as we go on instead of adding to list being the final action.
            // Add one class to list, with random room chosen and random period chosen, and add that class to the list.
            // while loop will have something like if the arraylist.get(i).period and . name is equal to the random values currently,
            // then loop again until the random values don't match any values in the table. this will make sure no classes will share same period AND room at the same time
        }
        return classesArrayList;
    } */