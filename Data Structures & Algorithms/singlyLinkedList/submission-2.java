class LinkedList {

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {

        Node currNode = head;

        for(int i=0; i<index; i++) {

            if(currNode == null) {
                return -1;
            }

            currNode = currNode.next;
        }

        if(currNode == null) {
            return -1;
        }

        return currNode.value;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean remove(int index) {
       
        Node currNode = head;
        Node prevNode = null;
        for(int i=0; i<index; i++) {
            if(currNode == null) {
                return false;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }

        if(currNode == null) {
            return false;
        }

        if(index == 0) {
            head = currNode.next;
            if(currNode.next == null) {
                tail = head;
            }

        } else if(currNode.next == null) {
            if(prevNode != null) {
                prevNode.next = null;
                tail = prevNode;
            }
        } else {
            prevNode.next = currNode.next;
            currNode.next = null;
        }

        return true;

    }

    public ArrayList<Integer> getValues() {
        Node currNode = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(currNode != null) {
            list.add(currNode.value);
            currNode = currNode.next;
        }
        return list;
    }
}
