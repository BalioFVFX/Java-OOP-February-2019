public class MathOperation {

    public MathOperation(){

    }

    public int add (int first, int second){
        return first + second;
    }

    public int add (int first, int second, int third){
        return this.add(first, second) + third;
    }

    public int add (int first, int second, int third, int fourth){
        return this.add(first, second, third) + fourth;
    }
}
