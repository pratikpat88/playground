package com.pratik.playground;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final List<Integer> input = Arrays.asList(1, 2, 3);
        final List<List<Integer>> result = Permutations.permutations(input);
        System.out.println("Input: " + input);
        System.out.println("Result: " + result);
    }
}
