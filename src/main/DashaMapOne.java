package main;

public class DashaMapOne extends DashaMap  {

    public String HashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }

    @Override
    public void set(String key, Integer value) {
        String keyHash = HashFunctionOne(key);
        Node newNode = new Node(key, value, null);
        appendTo(keyHash, newNode);
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
        delete(keyHash, key);
    }

    @Override
    public Integer bucketSize(String key) {
        key = HashFunctionOne(key);
        return checkBuckets(key);
    }


}










