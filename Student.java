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

            // if both the object references are
            // referring to the same object.
            if(this == obj)
                return true;

            // it checks if the argument is of the
            // type Geek by comparing the classes
            // of the passed argument and this object.
            // if(!(obj instanceof Geek)) return false; ---> avoid.
            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            // type casting of the argument.
            Student st = (Student) obj;

            // comparing the state of argument with
            // the state of 'this' Object.
            return (st.code.equals(this.code)  );

    }
}
