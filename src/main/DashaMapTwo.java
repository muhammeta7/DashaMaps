package main;

public class DashaMapTwo extends DashaMap{

    public String HashFunctionTwo(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(1)).toLowerCase();
        }
        return null;
    }

    @Override
    public void set(String key, Integer value) {
        String keyHash = HashFunctionTwo(key);
        Node newNode = new Node(key, value, null);
        appendTo(keyHash, newNode);
    }

    @Override
    public Integer get(String key) {
        String keyHash = HashFunctionTwo(key);
        Node newNode = findNode(keyHash, key);
        return newNode.getValue();
    }

    @Override
    public void delete(String key) {
        String keyHash = HashFunctionTwo(key);
        delete(keyHash, key);
    }

    @Override
    public Integer bucketSize(String key) {
        key = HashFunctionTwo(key);
        return checkBuckets(key);
    }
}
