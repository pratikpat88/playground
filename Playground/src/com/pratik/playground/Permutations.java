package com.pratik.playground;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    static List<List<Integer>> permutations(Collection<Integer> numbers) {
        return permutations(numbers.iterator());
    }

    private static List<List<Integer>> permutations(Iterator<Integer> it) {
        if (!it.hasNext()) {
            // base case - when no more elements
            final List<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<>());
            return result;
        }
        final Integer current = it.next();
        final List<List<Integer>> otherPermutations = permutations(it);
        final List<List<Integer>> result = new LinkedList<>();
        for (final List<Integer> otherPermutation : otherPermutations) {
            for (int i = 0; i <= otherPermutation.size(); i++) {
                final List<Integer> newPermutation = new LinkedList<>(otherPermutation);
                newPermutation.add(i, current);
                result.add(newPermutation);
            }
        }
        return result;
    }
}
