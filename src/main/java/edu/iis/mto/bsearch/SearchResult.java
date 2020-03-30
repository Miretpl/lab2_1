/**
 *
 */
package edu.iis.mto.bsearch;

import java.util.Objects;

public class SearchResult {

    private static final int NOT_FOUND = -1;
    private int position = NOT_FOUND;

    public boolean isFound() {
        return position > NOT_FOUND;
    }

    void setPosition(int position) {
        if (position > NOT_FOUND) {
            this.position = position;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override public int hashCode() {
        return Objects.hash(position);
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SearchResult other = (SearchResult) obj;
        return position == other.position;
    }

    @Override public String toString() {

        return isFound() ? "( element at position " + position + ")" : "element not found";
    }
}
