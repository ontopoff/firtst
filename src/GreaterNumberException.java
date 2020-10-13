public class GreaterNumberException extends Exception {
    private long num;

    GreaterNumberException(long errNum){
        num = errNum;
    }

    public String toString() {
        return "GreaterNumberException[Number " + num + " greater then input value]";
    }
}