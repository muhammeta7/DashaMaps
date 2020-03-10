package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class DashaMapTwoTest {
    @Test
    public void dashamapTwoConstructorTest(){
        // Given
        DashaMapTwo map = new DashaMapTwo();
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
        DashaMapTwo map = new DashaMapTwo();
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
        DashaMapTwo map = new DashaMapTwo();
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
        DashaMapTwo map = new DashaMapTwo();
        Node[] nodeArray = map.getHashArray();
        Node newNode = new Node("alimony", 1, null);

        // When
        map.appendTo("l", newNode);
        String expected = nodeArray[11].getNext().getKey();

        // Then
        assertEquals("alimony", expected);
    }

    @Test
    public void appendToMultipleTest(){
        // Given
        DashaMapTwo map = new DashaMapTwo();
        Node[] nodeArray = map.getHashArray();
        Node node1 = new Node("alimony", 1, null);
        Node node2 = new Node("alas", 1, null);

        // When
        map.appendTo("l", node1);
        map.appendTo("l", node2);
        String actual1 = nodeArray[11].getNext().getKey();
        String actual2 = nodeArray[11].getNext().getNext().getKey();

        // Then
        assertEquals("alimony", actual1);
        assertEquals("alas", actual2);
    }


    @Test
    public void isEmptyTest(){
        // Given
        DashaMapTwo map = new DashaMapTwo();
        String expectedKey = "Zipcode";
        Integer expectedValue = 10;

        // When
        map.set(expectedKey, expectedValue);

        // Then
        assertFalse(map.isEmpty());
    }

    @Test
    public void findNodeTest(){
        DashaMapTwo map = new DashaMapTwo();
        map.set("apple", 4);
        assertEquals("apple", map.findNode("p", "apple").getKey() );
    }

    @Test
    public void findNodeForEmptyMap(){
        DashaMapTwo nullMap = new DashaMapTwo();
        assertNotNull(nullMap.findNode("p", "apple"));
    }

    @Test
    public void getTest(){
        // Given
        DashaMapTwo map = new DashaMapTwo();
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
        DashaMapTwo dash = new DashaMapTwo();
        dash.set("alive", 2);
        dash.set("alone", 5);
        dash.set("alas", 3);
        Integer expected = 3;

        // When
        Integer actual = dash.bucketSize("l");

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void size(){
        // Given
        DashaMapTwo dash = new DashaMapTwo();
        dash.set("animal", 2);
        dash.set("apple", 5);
        dash.set("banana", 3);
        dash.set("bats", 3);
        dash.set("zebra", 5);
        dash.set("zygote", 3);
        Long expected = 6l;

        // When
        long actual = dash.size();

        // Then
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void removeNodeTest(){
        // Given
        DashaMapTwo thisMap = new DashaMapTwo();
        thisMap.set("alive", 2);
        thisMap.set("alone", 5);
        thisMap.set("alas", 3);

        // When
        thisMap.delete("l", "alone");
        Node actual = thisMap.findNode("l", "alone");

        // Then
        assertNull(actual.getNext());
        assertNull(thisMap.hashArray[11].getNext().getNext().getNext());
        assertEquals(thisMap.hashArray[11].getNext().getNext().getKey(), "alas");
    }

    @Test
    public void deleteTest(){
        // Given
        DashaMapTwo mappy = new DashaMapTwo();
        mappy.set("alive", 2);
        mappy.set("alone", 5);
        mappy.set("alas", 3);

        // When
        mappy.delete("alone");
        Node actual = mappy.findNode("l", "alone").getNext();

        // Then
        assertNull(actual);
        assertNull(mappy.hashArray[11].getNext().getNext().getNext());
        assertEquals(mappy.hashArray[11].getNext().getNext().getKey(), "alas");
    }
}
