public class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }

}

class LRUCache {

    int cap;
    private HashMap<Integer,Node> cache;
    private Node head ;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.cache=new HashMap<>();
        this.head=new Node(0,0);
        this.tail=new Node (0,0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    public void deleteNode(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
    public void insert(Node node){
        Node currNextToHead=head.next;
        node.next=currNextToHead;
        head.next=node;
        node.prev=head;
        currNextToHead.prev=node;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            deleteNode(node);
            insert(node);;
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            node.value=value;
            deleteNode(node);
            insert(node);
        }else{
            if(cache.size()==cap){
                Node lru=tail.prev;
                deleteNode(lru);
                cache.remove(lru.key);
            }
            Node newnode=new Node(key,value);
            cache.put(key,newnode);
            insert(newnode);
        }
    }
}
