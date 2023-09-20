import java.io.Serializable;

public class Student implements Serializable {

    private String code;
    private String name;
    private String cl;//class

    private static final long serialVersionUID = 6529685098267757690L;
    public Student(String code, String name, String cl) {
        this.code = code;
        this.name = name;
        this.cl = cl;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cl='" + cl + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

            if(this == obj)
                return true;

            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            Student st = (Student) obj;

            return (st.code.equals(this.code)  );

    }
}
