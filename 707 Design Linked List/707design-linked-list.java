class MyLinkedList {
    int val;
    MyLinkedList next;
    MyLinkedList head = null;

    public MyLinkedList() {}

    public MyLinkedList(int val) {
        this.val = val;
    }

    public int get(int index) {
        MyLinkedList t = head;
        while (t != null && index > 0) {
            t = t.next;
            index--;
        }
        return (t == null) ? -1 : t.val;
    }

    public void addAtHead(int val) {
        MyLinkedList node = new MyLinkedList(val);
        node.next = head;
        head = node;
    }

    public void addAtTail(int val) {
        MyLinkedList node = new MyLinkedList(val);
        if (head == null) {
            head = node;
            return;
        }
        MyLinkedList t = head;
        while (t.next != null) {
            t = t.next;
        }
        t.next = node;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        MyLinkedList t = head;
        while (t != null && index > 1) {
            t = t.next;
            index--;
        }
        if (t == null) return;
        MyLinkedList node = new MyLinkedList(val);
        node.next = t.next;
        t.next = node;
    }

    public void deleteAtIndex(int index) {
        if (head == null) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        MyLinkedList t = head;
        while (t != null && index > 1) {
            t = t.next;
            index--;
        }
        if (t == null || t.next == null) return;
        t.next = t.next.next;
    }
}
