import java.util.ArrayList;

public class Assignments {

    private String name;

    private int id;

    private int typeid;

    private int classid;

    public Assignments(String name, int id, int typeid, int classid){
        this.id = id;
        this.name = name;
        this.typeid = typeid;
        this.classid = classid;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTypeid(int id){
        typeid = id;
    }

    public void setClassid(int id){
        classid = id;
    }

    public int getId() {
        return id;
    }

    public int getTypeid(){
        return typeid;
    }

    public String getName() {
        return name;
    }

    public int getClassid() {
        return classid;
    }
}
