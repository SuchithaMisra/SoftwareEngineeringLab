package c;

public class TestMe {

    private double value = Double.NaN;

    public static void main(String[] args){
        System.out.println("hello world!");
    }

    public TestMe() {}

    public double square() {
        // creating a sqaure with the value
        return value * value;
    }

    public double cube(){
        //creating a value with the value
        return value * value * value;
    }

    public double triangle(){
        // creating a triangle with the value
        return value * value * .5;
    }

    public double area(TestMe testMe){
        // returns the rectangular area using this value and another TestMe object
        double v = testMe.getValue();
        return v * value;
    }

    public TestMe doubleSizeTestMe(){
        // returns a TestMe object who's value is twice the size of the calling TestMe
        TestMe testMe2 = new TestMe();
        testMe2.setValue(value * 2);
        return testMe2;
    }

    public void setValue(double v){
        value = v;
    }

    public double getValue(){
        return value;
    }


}