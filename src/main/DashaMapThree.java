package main;

public class DashaMapThree extends DashaMap{

    public String HashFunctionThree(String input) {
        if (input.length() > 1) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        return null;
    }


    @Override
    public void set(String key, Integer value) {
        String keyHash = HashFunctionThree(key);
        Node newNode = new Node(key, value, null);
        appendTo(keyHash, newNode);
    }

    @Override
    public Integer get(String key) {
        String keyHash = HashFunctionThree(key);
        Node newNode = findNode(keyHash, key);
        return newNode.getValue();
    }

    @Override
    public void delete(String key) {
        String keyHash = HashFunctionThree(key);
        delete(keyHash, key);
    }

    @Override
    public Integer bucketSize(String key) {
        key = HashFunctionThree(key);
        return checkBuckets(key);
    }
}
