package org.lynxlake.methods.immutableList;

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
