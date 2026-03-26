class Course {

    int courseId;
    String courseName;

    Course(int courseId, String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
    }

    void displayCourse(){
        System.out.println("Course ID: "+courseId);
        System.out.println("Course Name: "+courseName);
    }
}
