import java.util.Scanner;

//I want to be able to read inputs for polynomials using an arraylist
public class Bisection {
static double a, b, c;
static double func;
//Idk why changing this to a "static" allows the array to be used everywhere or what "static" really means
static double[] eq;
static double[] EP = {a, b, c};
static double tol = 0.01;
static double fa;
static double fb;
static double fc;
static int counter = 0;

//This is a constructor(?) that reads the input for a quadrartic equation and stores it in an array
public static void input() {
    //array for the equation, idk why it's declared like this but i guess it works
    eq = new double[3];

    //Prompt to explain input style
    System.out.println("please individually input the quadratic equation in this order: 'x^2 coeff, x coeff, constant C'.");

    //Scanner stores inputs into the array. **add something to be able to "exit" the program, and a check which verifies that numbers are being inputted instead of letters**
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
        eq[i] = sc.nextDouble();
    }
    

    //Show the user what the equation they inputted looks like
    System.out.println("The equation you typed is: y = " + eq[0] + "x^2 + " + eq[1] + "x + " + eq[2] + ".");

    System.out.println("What is Xmin?");
    a = sc.nextDouble();
    System.out.println("What is Xmax?");
    b = sc.nextDouble();
    c = ((a + b)/2);
    System.out.println("Given Xmin = " + a + ", Xmax = " + b + ", the midpoint will be " + c + ".");
    sc.close();
}

//This constructor(?) calculates the "y" value of a, b, and c
public static void equation() {

    double x2 = eq[0];
    double x1 = eq[1];
    double x0 = eq[2];
    fa = (x2*Math.pow(a, 2)) + (x1*a) + (x0);
    //System.out.println("the value of 'y' at Xmin is " + fa);
    fb = (x2*Math.pow(b, 2)) + (x1*b) + (x0);
    //System.out.println("the value of 'y' at Xmax is " + fb);
    fc = (x2*Math.pow(c, 2)) + (x1*c) + (x0);
    System.out.println("the value of 'y' at the midpoint is " + fc);
    counter++;


}
//Perform bisection until the root is found within tolerance
public static void bisection() {

    while (fc + tol < 0 || fc - tol > 0) {
        if (fa * fc < 0) {
            b = c;
        } else if (fb * fc < 0) {
            a = c;
        }
        c = (a + b)/2;
        equation();
        System.out.println("the counter is at " + counter);
    }

}

public static void found() {
System.out.println("The root is at x = " + c + ", +- " + tol + ". " + counter + " iteration(s) required.");
}



public static void main(String args[]) {

    input();
    
    equation();
    
    bisection();

    found();
}
}
