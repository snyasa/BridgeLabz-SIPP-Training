public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start = 0;  // Points to the oldest element
    private int count = 0;  // Number of elements in buffer

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    public void insert(int value) {
        int index = (start + count) % size;

        // If buffer is full, overwrite the oldest (move start)
        if (count == size) {
            buffer[start] = value;
            start = (start + 1) % size;
        } else {
            buffer[index] = value;
            count++;
        }
    }

    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (start + i) % size;
            System.out.print(buffer[index]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();  
        cb.insert(4);             
        cb.printBuffer();  

        cb.insert(5);      
        cb.printBuffer();  
    }
}
