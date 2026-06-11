class Node{
    int value;
    Node next ;
    Node prev;

    public Node(int value,Node next ,Node prev){
        this.value=value;
        this.next=next;
        this.prev=prev;
    }
}

class MyCircularQueue {
    int capacity;
    Node head;
    Node tail;
    
    public MyCircularQueue(int k) {
        this.capacity=k;
        this.head=new Node (0,null,null);
        this.tail=new Node (0,null,null);
        this.head.next=tail;
        this.tail.prev=head;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        Node newNode =new Node(value,tail,tail.prev);
        tail.prev.next=newNode;
        tail.prev=newNode;
        capacity--;
        return true;

    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head.next=head.next.next;
        head.next.prev=head;
        capacity++;
        return true;

        
    }
    
    public int Front() {
        return isEmpty()?-1:head.next.value;
    }
    
    public int Rear() {
        return isEmpty()?-1:tail.prev.value;
    }
    
    public boolean isEmpty() {
        return head.next==tail? true: false;
    }
    
    public boolean isFull() {
        return capacity==0? true: false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */