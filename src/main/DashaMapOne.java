package main;

public class DashaMapOne implements HashMapX {

    Node[] hashArray;

    public DashaMapOne(){

        hashArray = new Node[26];
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            char alphabet = (char)(a + i);
            hashArray[i] = new Node(Character.toString(alphabet), null, null);
        }

    }

    public String HashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }

    public void appendTo(String letter, Node node){

        for (Node n : hashArray) {
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
    public Integer get(String key) {
       return null;
    }

    @Override
    public String delete(String key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (Node node : hashArray) {
            if (node.getNext() != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public Integer bucketSize(String key) {
        return null;
    }

    public Node[] getHashArray() {
        return hashArray;
    }

    public void setNodeArray(Node[] nodeArray) {
        this.hashArray = nodeArray;
    }
}










