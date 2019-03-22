import java.util.ArrayDeque;

public class Memory implements Operation{
    private ArrayDeque<Integer> memoryStack;

    public Memory() {
        this.memoryStack = new ArrayDeque<>();
    }


    @Override
    public void addOperand(int operand) {
        this.memoryStack.push(operand);
    }

    @Override
    public int getResult() {
        return this.memoryStack.pop();
    }

    @Override
    public boolean isCompleted() {
        return this.memoryStack.size() > 0;
    }
}
