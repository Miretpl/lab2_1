package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    static final int[] oneElementSeq = {1};
    static final int[] manyElementsSeq = {2, 3, 4, 5, 6};
    static final BinarySearch binarySearch = BinarySearch.create();

    @Test void searchKeyInOneElementSeqWithKeyInIt() {
        int key = 1;
        var searchResult = binarySearch.search(key, oneElementSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(oneElementSeq[searchResult.getPosition()], key);
    }

    @Test void searchKeyInOneElementSeqWithoutKeyInIt() {
        int key = 2;
        var searchResult = binarySearch.search(key, oneElementSeq);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), -1);
    }

    @Test void searchFirstKeyInManyElementSeqWithoutKeyInIt() {
        int key = 2;
        var searchResult = binarySearch.search(key, manyElementsSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(manyElementsSeq[searchResult.getPosition()], key);
    }

    @Test void searchLastKeyInManyElementSeqWithoutKeyInIt() {
        int key = 6;
        var searchResult = binarySearch.search(key, manyElementsSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(manyElementsSeq[searchResult.getPosition()], key);
    }

    @Test void searchMiddleKeyInManyElementSeqWithoutKeyInIt() {
        int key = 4;
        var searchResult = binarySearch.search(key, manyElementsSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(manyElementsSeq[searchResult.getPosition()], key);
    }

    @Test void searchMissingKeyInManyElementSeqWithoutKeyInIt() {
        int key = 8;
        var searchResult = binarySearch.search(key, manyElementsSeq);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), -1);
    }
}
