import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("Cannot pop on empty Stack");
        }
        return this.data.remove(this.data.size() -1);
    }

    public String peek(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("Cannot pop on empty Stack");
        }
        return this.data.get(this.data.size() -1);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }

}
