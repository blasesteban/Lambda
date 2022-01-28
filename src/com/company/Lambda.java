package com.company;

import javax.xml.stream.events.Comment;
import java.util.List;

public class Lambda {

    List<Integer> nums = List.of(3, 4, 5, 6, 6, 7, 8, 5, 4, 2, 2, 5, 6, 7, 4, 32);

    public static void main(String[] args) {
        new Lambda().run();
    }

    void run() {
        //lambda operator
        Command command = n -> n * 10;
        //execute method override
/*        Command command = new Command() {
            *@Override
            *public int execute(int i) {
                *return i + 10;
            *}
        };*/
        process(nums, command);
    }

    private void process(List<Integer> nums, Command command) {
        for (int num : nums) {
            System.out.println(command.execute(num));
        }
    }
}

//abstract class is enough
/*abstract class Command {
*public abstract int execute(int i);
}*/

//lambda needs a FunctionalInterface what has only one method because lambda does not know which method we will override
@FunctionalInterface
interface Command {
    int execute(int i);
}