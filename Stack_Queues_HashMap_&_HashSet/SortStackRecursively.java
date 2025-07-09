import java.util.Stack;

class SortStackRecursively {

    public void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertSorted(stack, top);
        }
    }

    private void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }
}
