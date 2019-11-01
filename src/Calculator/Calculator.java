package Calculator;

public class Calculator {
    public Calculator() {
    }

    // Bold
    public int add(int a, int b){
        return a + b;
    }

    // Bold
    public double add(double a, double b){
        return a + b;
    }


    public double add(int a, double b){
        return add((double)a, b);
    }

    public int add(int a, int b, int c){
        return add(add(a, b),c);
    }

    public int[] add(int[] arr, int a){
        for (int i = 0; i < arr.length; i++) arr[i] = add(arr[i], a);
        return arr;
    }

    // Bold
    public Rectangle add(Rectangle a, Rectangle b){
        return new Rectangle((a.getLength() + b.getLength()), (a.getWidth() + b.getWidth()));
    }

    public int subtract(int a, int b){
        return add(a, (int)div(b, -1));
    }

    public double subtract(double a, double b){
        return add(a, div(b, -1));
    }

    public double[] subtract(int[] arr, double a){
        double[] darr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) darr[i] = subtract(arr[i], a);
        return darr;
    }

    public Rectangle subtract(Rectangle a, Rectangle b){
        return new Rectangle(subtract(a.getLength(),b.getLength()), subtract(a.getWidth(), b.getWidth()));
    }

    // Bold
    public double div(double a, double b){
        return a/b;
    }

    public double[] div(int[] arr, double a){
        double[] darr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) darr[i] = div(arr[i], a);
        return darr;
    }

    public Rectangle div(Rectangle a, double b){
        return new Rectangle(div(a.getLength(), b), div(a.getWidth(), b));
    }

    public double mult(int a, double b){
        return div(a, div(1, b));
    }

    public double mult(double a, double b){
        return div(a, div(1,b));
    }

    public double[] mult(int[] arr, double a){
        double[] darr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) darr[i] = mult(arr[i], a);
        return darr;
    }

    public Rectangle mult(Rectangle a, double b){
        return new Rectangle(mult(a.getLength(), b), mult(a.getWidth(), b));
    }

    public String mult(int a, String string){
        String rstring = "";
        for (int i = 0; i < a; i++) rstring = rstring.concat(string);
        return rstring;
    }

    public String mult(double a, String string){
        return mult((int)a, string).concat(string.substring(0,(int)mult(string.length(), (subtract(a, (int)a)))));
    }
}
