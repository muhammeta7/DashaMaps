package main;

public interface HashMapX {

    // fundamentals
    public void set(String key, String value);
    public String delete(String key);
    public String get(String key);
    public boolean isEmpty();
    public long size();
    public Integer bucketSize(String key); // used for tests

}
