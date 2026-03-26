interface Drawable { 
    void draw(); 
} 
abstract class Shape implements Drawable { 
 
    abstract double calculateArea(); 
} 
class Circle extends Shape { 
 
    private double radius; 
 
    Circle(double radius) { 
        this.radius = radius; 
    } 
 
    @Override 
    double calculateArea() { 
        return Math.PI * radius * radius; 
    } 
 
    @Override 
    public void draw() { 
        System.out.println("Drawing Circle"); 
    } 
} 
class Rectangle extends Shape { 
 
    private double length, width; 
 
    Rectangle(double length, double width) { 
        this.length = length; 
        this.width = width; 
    } 
 
    @Override 
    double calculateArea() { 
        return length * width; 
    } 
 
    @Override 
    public void draw() { 
        System.out.println("Drawing Rectangle"); 
    } 
} 
class Triangle extends Shape { 
 
    private double base, height; 
 
    Triangle(double base, double height) { 
        this.base = base; 
        this.height = height; 
    } 
 
    @Override 
    double calculateArea() { 
        return 0.5 * base * height; 
    } 
 
    @Override 
    public void draw() { 
        System.out.println("Drawing Triangle"); 
    } 
} 
public class ShapeManagementSystem { 
 
    public static void main(String[] args) { 
 
        Shape[] shapes = new Shape[3]; 
        shapes[0] = new Circle(5); 
        shapes[1] = new Rectangle(4, 6); 
        shapes[2] = new Triangle(3, 8); 
 
        double totalArea = 0; 
  
        StringBuilder report = new StringBuilder(); 
        report.append("SHAPE MANAGEMENT REPORT\n"); 
        report.append("========================\n"); 
 
        for (Shape s : shapes) { 
            s.draw(); 
            double area = s.calculateArea(); 
            totalArea += area; 
 
            report.append("Shape: ") 
                  .append(s.getClass().getSimpleName()) 
                  .append("\nArea : ") 
                  .append(String.format("%.2f", area)) 
                  .append("\n------------------------\n"); 
        } 
 
        report.append("Total Area of All Shapes: ") 
              .append(String.format("%.2f", totalArea)); 
 
        System.out.println("\n" + report.toString()); 
    } 
}