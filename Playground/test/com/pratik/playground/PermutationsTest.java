package com.pratik.playground;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void twoPermutationsTest() {
        final List<Integer> input = Arrays.asList(1, 2);
        Set<List<Integer>> result = new HashSet<>(Permutations.permutations(input));
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(2, 1)));
    }
}