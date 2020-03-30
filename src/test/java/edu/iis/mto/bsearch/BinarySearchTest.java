package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    static final int ELEMENT_NOT_FOUND = -1;

    static final int[] nullSeq = null;
    static final int[] emptySeq = {};
    static final int[] oneElementSeq = {1};
    static final int[] manyPositiveElementsSeq = {2, 3, 4, 5, 6};
    static final int[] manyNegativeElementsSeq = {-20, -15, -10, -5, 0};
    static final BinarySearch binarySearch = BinarySearch.create();

    @Test public void searchKeyInOneElementSeqWithKeyInIt() {
        int key = 1;
        var searchResult = binarySearch.search(key, oneElementSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(oneElementSeq[searchResult.getPosition()], key);
    }

    @Test public void searchKeyInOneElementSeqWithoutKeyInIt() {
        int key = 2;
        var searchResult = binarySearch.search(key, oneElementSeq);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), ELEMENT_NOT_FOUND);
    }

    @Test public void searchFirstKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 2;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(manyPositiveElementsSeq[searchResult.getPosition()], key);
    }

    @Test public void searchLastKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 6;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(manyPositiveElementsSeq[searchResult.getPosition()], key);
    }

    @Test public void searchMiddleKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 4;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(manyPositiveElementsSeq[searchResult.getPosition()], key);
    }

    @Test public void searchMissingKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 8;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), ELEMENT_NOT_FOUND);
    }

    @Test public void searchMiddleKeyInManyNegativeElementSeqWithoutKeyInIt() {
        int key = -10;
        var searchResult = binarySearch.search(key, manyNegativeElementsSeq);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(manyNegativeElementsSeq[searchResult.getPosition()], key);
    }

    @Test public void searchKeyInEmptySeq() {
        int key = 10;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            binarySearch.search(key, emptySeq);
        });
    }

    @Test public void searchKeyInNullSeq() {
        int key = 10;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            binarySearch.search(key, nullSeq);
        });
    }
}
