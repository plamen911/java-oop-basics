package org.lynxlake._02Methods._07ImmutableList;

import java.util.List;

class ImmutableList {
    private List<Integer> collection;

    public ImmutableList(List<Integer> collection) {
        this.collection = collection;
    }

    public ImmutableList getCollection() {
        return new ImmutableList(this.collection);
    }
}
