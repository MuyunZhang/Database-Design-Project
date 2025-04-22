public class Schedule {
    private int studentID;
    private int classID;

    public Schedule(int studentID, int classID){
        this.classID = classID;
        this.studentID = studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getClassID() {
        return classID;
    }

    public int getStudentID() {
        return studentID;
    }
}
