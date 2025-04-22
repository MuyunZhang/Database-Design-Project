public class Grades {
    private int assignmentID;
    private int studentID;
    private int grade;

    public Grades(int grade, int assignmentID, int studentID){
        this.grade = grade;
        this.assignmentID = assignmentID;
        this.studentID = studentID;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getGrade() {
        return grade;
    }

    public int getAssignmentID(){
        return assignmentID;
    }

    public int getStudentID() {
        return studentID;
    }
}
