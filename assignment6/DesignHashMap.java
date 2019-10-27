package assignment6;

class ListNode{
    int val,key;
    ListNode next;
    ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class DesignHashMap {

    final ListNode[] nodes = new ListNode[10000];

    public int hash(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    public DesignHashMap() {

    }

    public void put(int key, int value) {
        int hashnum = hash(key);
        ListNode head = nodes[hashnum];
        ListNode newnode = new ListNode(key, value);    //defind input to newnode

        if(head == null)
            nodes[hashnum] = newnode;     // if the place has no node, put the newnode here

        else{
            ListNode same = find(head, key);    //else find where is the head
            if(same == null){
                newnode.next = head;       //add newnode into the same place
                nodes[hashnum] = newnode;
            }else
                same.val = value;    //if there is old node, renew the value
        }

    }

    public ListNode find(ListNode node, int key){
        while(node != null){
            if(node.key == key){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int get(int key) {
        int hashnum = hash(key);
        if(nodes[hashnum] == null)        // if there not has that node, return -1
            return -1;
        ListNode node = find(nodes[hashnum],key);   //find the node and return its value
        if(node == null)
            return -1;
        else
            return node.val;

    }

    public void remove(int key) {
        int hashnum = hash(key);
        if(nodes[hashnum] == null)        // if there not has that node
            return;

        ListNode cur = nodes[hashnum];
        ListNode pre = null;

        while(cur != null){
            if(cur.key == key){
                if(pre != null){
                    pre.next = cur.next;   // directly link of pre and next
                }else{
                    nodes[hashnum] = cur.next;
                }
                break;
            }else{
                pre = cur;        // go on searching for the node
                cur = cur.next;
            }
        }

    }


    public static void main(String args[]){
        DesignHashMap hashMap = new DesignHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));         // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}
