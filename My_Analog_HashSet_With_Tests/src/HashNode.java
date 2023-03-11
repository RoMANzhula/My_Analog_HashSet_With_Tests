public class HashNode {
    private String msg;
    private HashNode next;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }

    public HashNode(String msg, HashNode next) {
        this.msg = msg;
        this.next = next;
    }

    public HashNode() {
    }
}
