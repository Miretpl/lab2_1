package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    static final int[] oneElementSeq = {1};
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
}
