package main;

public abstract class DashaMap implements HashMapX{

    Node[] hashArray;

    public DashaMap(){

        hashArray = new Node[26];
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            char alphabet = (char)(a + i);
            hashArray[i] = new Node(Character.toString(alphabet), null, null);
        }

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

    public void delete(String keyHash, String key){

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

    public Node[] getHashArray() {
        return hashArray;
    }

    public void setNodeArray(Node[] nodeArray) {
        this.hashArray = nodeArray;
    }


}
