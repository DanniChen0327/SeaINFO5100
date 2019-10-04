package assignment4;

public class ShapeTester{
    public static void main(String[] args){
        Shape s = new Shape();
        Rectangle r = new Rectangle(2.0, 3.0);
        Circle c = new Circle(4.0);
        Square sq = new Square(4.0);

        r.getArea();
        r.getPerimeter();
        c.getArea();
        c.getPerimeter();
        sq.getArea();
        sq.getPerimeter();
        r.draw();
        c.draw();
        s.draw();
        sq.draw();

    }
}

class Shape{
    protected String name;
    private double perimeter;
    private double area;

    public void draw(){
        System.out.println("Deawing Shape");
    }
    public void getArea(){

    }

    public void getPerimeter(){

    }
}

class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    public void draw(){
        System.out.println("Drawing Circle");
    }
    public void getArea(){
        double area = Math.PI * this.radius * this.radius;
        System.out.println(area);
    }

    public void getPerimeter(){
        double perimeter =2 * Math.PI * this.radius;
        System.out.println(perimeter);
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public void draw(){
        System.out.println("Drawing Rectangle");
    }

    public void getArea(){
        double area = this.width * this.height;
        System.out.println(area);
    }

    public void getPerimeter(){
        double perimeter = 2* (this.width + this.height);
        System.out.println(perimeter);
    }
}

class Square extends Shape{
    private double side;

    public Square(double side){
        this.side = side;
    }

    public void draw(){
        System.out.println("Drawing Square");
    }

    public void getArea(){
        double area = Math.pow(this.side, 2);
        System.out.println(area);
    }

    public void getPerimeter(){
        double perimeter = 4 * this.side;
        System.out.println(perimeter);
    }

}