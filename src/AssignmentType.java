public class AssignmentType {
    public static void main(String[] args) {
        String [] types = {"Minor Assessment", "Major Assessment"};
        for (int i = 1; i <= types.length; i++) {
            System.out.println("INSERT INTO Assignment_Type ( Assignment_TypeID, Assignment_Type ) VALUES ( " + i + ", ' " + types[i-1] + "' );");
        }
    }

    int typeID;

    String typeName;
    public AssignmentType(int typeID, String typeName){
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
