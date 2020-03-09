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
        Node[] nodeArray = map.getNodeArray();
        Integer expected = 26;

        // When
        Integer actual = nodeArray.length;

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void nodeArrayTest(){
        // Given
        Node[] hashArray = map.getNodeArray();
        String expected = "d";

        // When
        String actual = hashArray[3].getKey();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void nodeArrayTest2(){
        // Given
        Node[] hashArray = map.getNodeArray();
        String expected = "z";

        // When
        String actual = hashArray[25].getKey();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void appendToTest(){
        // Given
        Node[] nodeArray = map.getNodeArray();
        Node newNode = new Node("alimony", 1, null);

        // When
        map.appendTo("a", newNode);
        String expected = nodeArray[0].getNext().getKey();


        // Then
        assertTrue(expected.equals("alimony"));
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



}
