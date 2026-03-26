class Student {

    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks){
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void displayStudent(){
        System.out.println("RollNo: "+rollNo);
        System.out.println("Name: "+name);
        System.out.println("Marks: "+marks);
        System.out.println("--------------------");
    }
}
