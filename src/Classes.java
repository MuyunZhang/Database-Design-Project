public class Classes {
    private int classID;
    private int period;
    private int teacherID;
    private int courseID;
    private int roomID;

    public Classes(int classID, int period, int teacherID, int courseID, int roomID){
        this.classID = classID;
        this.period = period;
        this.teacherID = teacherID;
        this.courseID = courseID;
        this.roomID = roomID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getClassID() {
        return classID;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getPeriod() {
        return period;
    }

    public int getTeacherID(){
        return teacherID;
    }
}
