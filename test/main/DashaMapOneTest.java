package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DashaMapOneTest {
    DashaMapOne map;

    @Before
    public void setup(){
         map = new DashaMapOne();
    }

    @Test
    public void dashamapConstructorTest(){
        // Given
        Node[] nodeArray = map.getHashArray();
        Integer expected = 26;

        // When
        Integer actual = nodeArray.length;

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void nodeArrayTest(){
        // Given
        Node[] hashArray = map.getHashArray();
        String expected = "d";

        // When
        String actual = hashArray[3].getKey();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void nodeArrayTest2(){
        // Given
        Node[] hashArray = map.getHashArray();
        String expected = "z";

        // When
        String actual = hashArray[25].getKey();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void appendToTest(){
        // Given
        Node[] nodeArray = map.getHashArray();
        Node newNode = new Node("alimony", 1, null);

        // When
        map.appendTo("a", newNode);
        String expected = nodeArray[0].getNext().getKey();

        // Then
        assertEquals("alimony", expected);
    }

    @Test
    public void appendToMultipleTest(){
        // Given
        Node[] nodeArray = map.getHashArray();
        Node node1 = new Node("alimony", 1, null);
        Node node2 = new Node("atlas", 1, null);

        // When
        map.appendTo("a", node1);
        map.appendTo("a", node2);
        String actual1 = nodeArray[0].getNext().getKey();
        String actual2 = nodeArray[0].getNext().getNext().getKey();
        Integer actual = nodeArray[0].getValue();

        // Then
        assertEquals("alimony", actual1);
        assertEquals("atlas", actual2);
    }


    @Test
    public void isEmptyTest(){
        // Given
        String expectedKey = "Zipcode";
        Integer expectedValue = 10;

        // When
        map.set(expectedKey, expectedValue);

        // Then
        assertFalse(map.isEmpty());
    }

    @Test
    public void findNodeTest(){
        map.set("apple", 4);
        assertEquals("apple", map.findNode("a", "apple").getKey() );
    }

    @Test
    public void findNodeForEmptyMap(){
        DashaMapOne nullMap = new DashaMapOne();
        assertNotNull(nullMap.findNode("a", "apple"));
    }

    @Test
    public void getTest(){
        // Given
        map.set("animal", 5);
        Integer expected = 5;
        // When
        Integer actual = map.get("animal");

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void bucketSizeTest(){
        // Given
        DashaMapOne dash = new DashaMapOne();
        map.set("animal", 2);
        map.set("apple", 5);
        map.set("aristocrat", 3);
        Integer expected = 3;

        // When
        Integer actual = map.bucketSize("a");

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void size(){
        // Given
        DashaMapOne dash = new DashaMapOne();
        map.set("animal", 2);
        map.set("apple", 5);
        map.set("banana", 3);
        map.set("bats", 3);
        map.set("zebra", 5);
        map.set("zygote", 3);
        Long expected = 6l;

        // When
        long actual = map.size();

        // Then
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void removeNodeTest(){
        // Given
        DashaMapOne thisMap = new DashaMapOne();
        thisMap.set("apple", 4);
        thisMap.set("alimony", 4);

        // When


        // Then
//        assertEquals("apple", map.findNode("a", "apple").getKey() );
    }


}
