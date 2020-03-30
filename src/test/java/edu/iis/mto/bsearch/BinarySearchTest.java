package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        assertTrue(searchResult.isFound());
        assertThat(key, is(oneElementSeq[searchResult.getPosition()]));
    }

    @Test public void searchKeyInOneElementSeqWithoutKeyInIt() {
        int key = 2;
        var searchResult = binarySearch.search(key, oneElementSeq);

        assertFalse(searchResult.isFound());
        assertThat(ELEMENT_NOT_FOUND, is(searchResult.getPosition()));
    }

    @Test public void searchFirstKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 2;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(key, is(manyPositiveElementsSeq[searchResult.getPosition()]));
    }

    @Test public void searchLastKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 6;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(key, is(manyPositiveElementsSeq[searchResult.getPosition()]));
    }

    @Test public void searchMiddleKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 4;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(key, is(manyPositiveElementsSeq[searchResult.getPosition()]));
    }

    @Test public void searchMissingKeyInManyPositiveElementSeqWithoutKeyInIt() {
        int key = 8;
        var searchResult = binarySearch.search(key, manyPositiveElementsSeq);

        assertFalse(searchResult.isFound());
        assertThat(ELEMENT_NOT_FOUND, is(searchResult.getPosition()));
    }

    @Test public void searchMiddleKeyInManyNegativeElementSeqWithoutKeyInIt() {
        int key = -10;
        var searchResult = binarySearch.search(key, manyNegativeElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(key, is(manyNegativeElementsSeq[searchResult.getPosition()]));
    }

    @Test public void searchKeyInEmptySeq() {
        int key = 10;

        assertThrows(IllegalArgumentException.class, () -> {
            binarySearch.search(key, emptySeq);
        });
    }

    @Test public void searchKeyInNullSeq() {
        int key = 10;

        assertThrows(IllegalArgumentException.class, () -> {
            binarySearch.search(key, nullSeq);
        });
    }
}
