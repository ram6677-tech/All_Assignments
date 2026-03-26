import java.util.ArrayList;
public class StudentManagement {
    static ArrayList <Student> students = new ArrayList<>();

    static void addStudent(Student s){
        students.add(s);
    }

    static int calculateTotalMarks() {
        int total = 0;
        for(Student s : students){
            total +=s.marks;
        }
        return total;
    }

    static void displayAllStudents(){
        for(Student s : students){
            s.displayStudent();
        }
    }

    public static void main(String[] args) {
        
        Course course = new Course(101, "Java Programming");
        course.displayCourse();
        System.out.println("=======================");

        addStudent(new Student(1, "Ram", 80));
        addStudent(new Student(2, "Sunil", 90));
        addStudent(new Student(3, "Bhagya", 100));

        displayAllStudents();
        System.out.println("Total Marks of All Students: "+calculateTotalMarks());
    }
}
