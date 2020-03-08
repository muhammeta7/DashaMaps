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
        Node[] nodeArray = map.getNodeArray();
        String expected = "d";

        // When
        String actual = nodeArray[3].getKey();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void nodeArrayTest2(){
        // Given
        Node[] nodeArray = map.getNodeArray();
        String expected = "z";

        // When
        String actual = nodeArray[25].getKey();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void appendToTest(){
        // Given

        // When

        // Then

    }



}
