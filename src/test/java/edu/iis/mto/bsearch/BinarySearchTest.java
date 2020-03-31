package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinarySearchTest {

    static final int ELEMENT_NOT_FOUND = -1;

    static final int[] nullSeq = null;
    static final int[] emptySeq = {};
    static final int[] oneElementSeq = {1};
    static final int[] positiveElementsSeq = {2, 3, 4, 5, 6};
    static final int[] negativeElementsSeq = {-20, -15, -10, -5, 0};
    static final int[] unsortedElementsSeq = {-20, 15, -10, 5, 0};
    static final int[] duplicatedElementsSeq = {15, 15, -10, 5, 5, 5};

    static final BinarySearch binarySearch = BinarySearch.create();

    @Test public void searchKeyInOneElementSeq() {
        int key = 1;
        int position = 0;
        var searchResult = binarySearch.search(key, oneElementSeq);

        assertTrue(searchResult.isFound());
        assertThat(position, is(searchResult.getPosition()));
        assertThat(key, is(oneElementSeq[searchResult.getPosition()]));
    }

    @Test public void searchMissingKeyInOneElementSeq() {
        int key = 2;
        var searchResult = binarySearch.search(key, oneElementSeq);

        assertFalse(searchResult.isFound());
        assertThat(ELEMENT_NOT_FOUND, is(searchResult.getPosition()));
    }

    @Test public void searchFirstKeyInManyPositiveElementSeq() {
        int key = 2;
        int position = 0;
        var searchResult = binarySearch.search(key, positiveElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(position, is(searchResult.getPosition()));
        assertThat(key, is(positiveElementsSeq[searchResult.getPosition()]));
    }

    @Test public void searchLastKeyInManyPositiveElementSeq() {
        int key = 6;
        int position = 4;
        var searchResult = binarySearch.search(key, positiveElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(position, is(searchResult.getPosition()));
        assertThat(key, is(positiveElementsSeq[searchResult.getPosition()]));
    }

    @Test public void searchMiddleKeyInManyPositiveElementSeq() {
        int key = 4;
        int position = 2;
        var searchResult = binarySearch.search(key, positiveElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(position, is(searchResult.getPosition()));
        assertThat(key, is(positiveElementsSeq[searchResult.getPosition()]));
    }

    @Test public void searchMissingKeyInManyPositiveElementSeq() {
        int key = 8;
        var searchResult = binarySearch.search(key, positiveElementsSeq);

        assertFalse(searchResult.isFound());
        assertThat(ELEMENT_NOT_FOUND, is(searchResult.getPosition()));
    }

    @Test public void searchMiddleKeyInManyNegativeElementSeq() {
        int key = -10;
        int position = 2;
        var searchResult = binarySearch.search(key, negativeElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(position, is(searchResult.getPosition()));
        assertThat(key, is(negativeElementsSeq[searchResult.getPosition()]));
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

    @Test public void searchMissingKeyInManyUnsortedElementSeq() {
        int key = 8;
        var searchResult = binarySearch.search(key, unsortedElementsSeq);

        assertFalse(searchResult.isFound());
        assertThat(ELEMENT_NOT_FOUND, is(searchResult.getPosition()));
    }

    @Test public void searchMiddleKeyInManyUnsortedElementSeq() {
        int key = 0;
        var searchResult = binarySearch.search(key, unsortedElementsSeq);

        assertFalse(searchResult.isFound());
        assertThat(ELEMENT_NOT_FOUND, is(searchResult.getPosition()));
    }

    @Test public void searchMiddleKeyInManyDuplicatedElementSeq() {
        int key = 3;
        var searchResult = binarySearch.search(key, duplicatedElementsSeq);

        assertFalse(searchResult.isFound());
        assertThat(ELEMENT_NOT_FOUND, is(searchResult.getPosition()));
    }

    @Test public void searchKeyInManyDuplicatedElementSeq() {
        int key = 5;
        int position = 3;
        var searchResult = binarySearch.search(key, duplicatedElementsSeq);

        assertTrue(searchResult.isFound());
        assertThat(position, is(not(searchResult.getPosition())));
    }
}
