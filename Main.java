import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");


        Set<Student> osztaly ;



        Scanner  input = new Scanner(System.in);
        boolean folytat = true;
        boolean bovit;
        int muvelet = -1;

        while(folytat){

            muvelet = choose(input);


            if(muvelet == 0){
                folytat = false;
            }
            else if (muvelet == 1) {
                osztaly = Beolvas();
                Student st = diakFelvetel();
                bovit = osztaly.add(st);
                if(bovit == false){
                    System.out.println("A kód már használatban van");
                }
                for(Student d : osztaly){
                    System.out.println(d);
                }
                Kiir(osztaly,null);


            }
            else if (muvelet == 2) {
                osztaly = Beolvas();
                String st = nevBeovlas(input);
                search(osztaly,st);


            }
            else if (muvelet == 3) {
                osztaly = Beolvas();
                String kod = kodBeovlas(input);


                Kiir(osztaly,kod);
                osztaly = Beolvas();

            }

        }

        input.close();

    }

    public static Student diakFelvetel(){

        Scanner input = new Scanner(System.in);
        System.out.println("Adja meg a diak nevet:");
        String nev = input.nextLine();

        System.out.println("Adja meg a diak osztályát:");
        String osztaly = input.nextLine();

        System.out.println("Adja meg a diak kódját:");
        String kod = input.nextLine();

        Student d = new Student(kod,nev,osztaly);

        return d;
    }

    public static int choose(Scanner input){
        System.out.println("Adja meg milyen műveletet szeretne elvégezni:");
        System.out.println("Exit (0)");
        System.out.println("New student(1)");
        System.out.println("Find Student(2)");
        System.out.println("Delete Student(3)");
        return Integer.parseInt(input.nextLine());
    }
    public static String kodBeovlas(Scanner input){

        System.out.println("Adja meg a diak kódját:");
        String kod = input.nextLine();
        return kod;

    }

    public static String nevBeovlas(Scanner input){
        //Scanner input = new Scanner(System.in);
        System.out.println("Adja meg a diak nevét:");
        String kod = input.nextLine();
       // input.close();
        return kod;

    }
    public static void search(Set<Student> osztaly,String st){

        boolean found = false;

        for(Student d : osztaly){
            if(d.getName().equals(st)) {
                System.out.println(d);
                found = true;
            }
        }

        if(found == false){
            System.out.println("Not found");
        }

    }

    public static void Kiir(Set<Student> osztaly,String kivetel){
        try {
            FileOutputStream fos = new FileOutputStream("Students.dat",false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            int x = osztaly.size();

            if(kivetel != null){
                x--;
            }

            oos.writeInt(x);
            for(Student d : osztaly){
                if(!d.getCode().equals(kivetel))
                    oos.writeObject(d);
            }

            oos.flush();
            oos.close();
            fos.flush();
            fos.close();

            System.out.println("Data is written to file!");
        } catch (IOException ioe) {
            System.out.println("File write exception: "+ioe);
        }

    }


    public static Set<Student> Beolvas(){
        Set<Student> osztaly = new HashSet<Student>();
        try {
            FileInputStream fis = new FileInputStream("Students.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            int db = ois.readInt();
            Object student = null;
            System.out.println("Data from file:");
            for (int i = 0; i < db; i++) {
                student = ois.readObject();
                Student st = (Student)student;
                osztaly.add(st);
                System.out.println(st);

            }

            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("File read exception: "+e);
        }

        return osztaly;
    }



}