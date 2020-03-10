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

    public Node findNode(String hashKey, String key){

        for(Node n : hashArray){
            if (n.getKey().equals(hashKey)) {
                Node tempNode = n;
                while (!tempNode.getKey().equals(key)) {
                    if(tempNode.getNext() != null){
                        tempNode = tempNode.getNext();
                    } else {
                        break;
                    }
                }
                return tempNode;
            }
        }
        return null;

    }

    @Override
    public Integer get(String key) {
       String keyHash = HashFunctionOne(key);
       Node newNode = findNode(keyHash, key);
       return newNode.getValue();
    }

    @Override
    public void delete(String key) {
        String keyHash = HashFunctionOne(key);
        removeNode(keyHash, key);
    }

    public void removeNode(String keyHash, String key){

        for (Node node : hashArray) {
            if (node.getKey().equals(keyHash)) {
                Node tempNode = node;
                Node reconnect = node;
                while (tempNode.getNext() != null && !tempNode.getKey().equals(key)) {
                    reconnect = tempNode;
                    tempNode = tempNode.getNext();
                }
                reconnect.setNext(tempNode.getNext());
                tempNode.setNext(null);
            }
        }

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

        long count = 0;
        char a = 'a';
        for (int i = 0; i < hashArray.length; i++) {
            char placeHolder = (char) (a + i);
            Character alphabet = placeHolder;
            count += bucketSize(alphabet.toString());
        }
        return count;

    }

    @Override
    public Integer bucketSize(String key) {

        int count = 0;
        key = HashFunctionOne(key);
        for (Node node : hashArray) {
            if (node.getKey().equals(key)) {
                Node tempNode = node;
                while (tempNode.getNext() != null) {
                    tempNode = tempNode.getNext();
                    count++;
                }
            }
        }
        return count;

    }

    public Node[] getHashArray() {
        return hashArray;
    }

    public void setNodeArray(Node[] nodeArray) {
        this.hashArray = nodeArray;
    }
}










