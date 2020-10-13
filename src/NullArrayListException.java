public class NullArrayListException extends Exception {
    private int num;

    NullArrayListException() {
    }

    public String toString() {
        return "NullArrayListException[ArrayList is empty]  Enter banknotes again:";
    }
}
