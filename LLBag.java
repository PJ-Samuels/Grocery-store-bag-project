import java.util.*;
public class LLBag implements Bag {
    private Node head;
    private int length;
    public LLBag() {
          head = null;
          length = 0;
    }
    public boolean add(Object value) {
        Node newNode = new Node(value);
        Node temp = head;
        if(temp == null)
            head = newNode;
        else{
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        length++;
        return true;
    }
    public boolean contains(Object value) {
        Node temp = head;
        while (temp != null) {
            if(temp.data.equals(value))
                return true;
            temp = temp.next;
        }
        return false;
    }
    public boolean remove(Object value) {
        if (head != null && head.data.equals(value)) {
            head = head.next;
            length--;
            return true;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(value)) {
                temp.next = temp.next.next;
                length--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public String toString() {
        String data = "[";
        Node temp = head;
        while(temp != null) {
            data += temp.data;
            temp = temp.next;
            if(temp != null) 
                data += ", ";
        }
        data += "]";
        return data;
    }
    public int numItems(){
        return length;
    }
    public Object grab(){
        if(length == 0)
            return null;
        int randIndex = (int) (Math.random() * length);
        Node temp = head;

        for(int i = 0; i < randIndex; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public Object[] toArray() {
        Object array[] = new Object[length];
        Node temp = head;
        for (int i = 0; i < length; i++){
            array[i] = temp.data;
            temp = temp.next;
        }
        return array;
    }
}
class Node {
    Object data;
    Node next;
    public Node(Object data){
        this.data = data;
    }
}