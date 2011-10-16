
package org.frc3780.library;

/**
 *
 * @author Oliver Graff (Team 3780)
 */
public class LinkedList {
    private Node m_head;
    
    private static class Node {
        private Node m_next;
        private Object m_obj;
        /**
         * Creates a new Node with Object obj
         * @param obj The object for this node to contain
         */
        public Node(Object obj) {
            this.m_obj = obj;
            m_next = null;
        }
        /**
         * Set the next node this one has
         * @param newNext the new next node
         */
        public void setNext(Node newNext) {
            m_next = newNext;
        }
        /**
         * Gets the next node
         * @return the next node in the linked list
         */
        public Node getNext() {
            return m_next;
        }
        public Object getObject() {
            return m_obj;
        }
        
    }
    /**
     * Gets the Object at index i
     * @param i Index to get
     * @return The object at index i
     */
    public Object get(int i) {
        Node n = m_head;
        for(int num = 0; num < i; num++ ) {
            n = n.getNext();
            if(n == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return n.getObject();
    }
    public int size() {
        int size = 0;
        Node n = m_head;
        while(n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }
    public void addToBeggining(Object obj) {
        Node newHead = new Node(obj);
        newHead.setNext(m_head);
        m_head = newHead;
    }
    
}
