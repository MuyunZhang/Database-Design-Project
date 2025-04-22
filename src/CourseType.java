public class CourseType {
    public static void main(String[] args) {
        String [] types = {"AP", "Regents", "Elective"};
        for (int i = 1; i <= types.length; i++) {
            System.out.println("INSERT INTO Course_Type ( Course_TypeID, Course_Type ) VALUES ( " + i + ", ' " + types[i-1] + "' );");
        }
    }
    private String courseType;
    private int courseTypeID;

    public CourseType(int id, String type){
        courseType = type;
        courseTypeID = id;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setCourseTypeID(int courseTypeID) {
        this.courseTypeID = courseTypeID;
    }

    public String getCourseType() {
        return courseType;
    }

    public int getCourseTypeID() {
        return courseTypeID;
    }
}
