package main;

public class DashaMapOne implements HashMapX {

    Node[] nodeArray;

    public DashaMapOne(){

        nodeArray = new Node[26];
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            char alphabet = (char)(a + i);
            nodeArray[i] = new Node(Character.toString(alphabet), null, null);
        }

    }

    private String HashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }

    public void appendTo(String letter, Node node){

        for (Node n : nodeArray) {
            if (n.getKey().equals(letter)) {
                Node tempNode = n;
                while (tempNode.getNext() != null) {
                    tempNode = tempNode.getNext();
                }
                tempNode.setNext(node);
            }
        }

    }

    @Override
    public void set(String key, Integer value) {
        String keyHash = HashFunctionOne(key);
        Node newNode = new Node(key, value, null);
        appendTo(keyHash, newNode);
    }

    @Override
    public String delete(String key) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public Integer bucketSize(String key) {
        return null;
    }

    public Node[] getNodeArray() {
        return nodeArray;
    }

    public void setNodeArray(Node[] nodeArray) {
        this.nodeArray = nodeArray;
    }
}


