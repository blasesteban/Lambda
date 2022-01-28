package com.company;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambda2 {

    List<Integer> nums = List.of(3, 4, 5, 6, 6, 7, 8, 5, 4, 2, 2, 5, 6, 7, 4, 32);

    public static void main(String[] args) {
        new Lambda().run();
    }

    private void run() {
        Function<Integer, Integer> command = n -> n * 10;
        BiFunction<Integer, Integer, Integer> command2 = (n, m) -> n * m;
        process(nums, command);
        process2(nums, command2);
    }

    private void process(List<Integer> nums, Function<Integer, Integer> command) {
        for (int num : nums) {
            System.out.println(command.apply(num));
        }
    }

    private void process2(List<Integer> nums, BiFunction<Integer, Integer, Integer> command) {
        for (int num : nums) {
            System.out.println(command.apply(num, 2));
        }
    }
}