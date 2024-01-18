package part2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestDrive {

    @Test
    public void testProblem1() {
        int[][] numbersList = {{2, 7, 11}, {3, 2, 4}, {3, 3}};
        int[] targetList = {9, 6, 6};
        int[][] expectedList = {{0, 1}, {1, 2}, {0, 1}};

        for (int i = 0; i < numbersList.length; i++) {
            int[] numbers = numbersList[i];
            int target = targetList[i];
            int[] expected = expectedList[i];

            int[] output = Problems.problem1(numbers, target);
            assertArrayEquals(expected, output);
        }
    }

    @Test
    public void testProblem2() {
        int[] P2NL = {121, -121, 1221, 12345, 0, 12321};
        boolean[] P2EL = {true, false, true, false, true, true};

        for (int i = 0; i < P2NL.length; i++) {
            int P2num = P2NL[i];
            boolean P2expected = P2EL[i];

            boolean output = Problems.problem2(P2num);
            assertEquals(P2expected, output);
        }
    }

    @Test
    public void testProblem3() {
        String[][] strsList = {{"flower", "flow", "flight"}, {"dog", "racecar", "car"}};
        String[] P3EL = {"fl", ""};

        for (int i = 0; i < strsList.length; i++) {
            String[] strs = strsList[i];
            String P3expected = P3EL[i];

            String output = Problems.problem3(strs);
            assertEquals(P3expected, output);
        }
    }

    @Test
    public void testProblem4() {
        String[] romanNumerals = {"III", "LVIII", "MCMXCIV"};
        int[] P4EL = {3, 58, 1994};

        for (int i = 0; i < romanNumerals.length; i++) {
            String P4num = romanNumerals[i];
            int P4expected = P4EL[i];

            int output = Problems.problem4(P4num);
            assertEquals(P4expected, output);
        }
    }

    @Test
    public void testProblem5() {
        String[] inputStrings = {"()", "()[]{}", "(]"};
        boolean[] P5EL = {true, true, false};

        for (int i = 0; i < inputStrings.length; i++) {
            String input = inputStrings[i];
            boolean expected = P5EL[i];

            boolean output = Problems.problem5(input);
            assertEquals(expected, output);
        }
    }

    @Test
    public void testProblem6() {
        LinkedList<Integer>[] list1Array = new LinkedList[]{
                new LinkedList<>(List.of(1, 3, 5, 7)),
                new LinkedList<>(List.of(1, 2, 4)),
                new LinkedList<>(List.of(5, 8, 10))
        };

        LinkedList<Integer>[] list2Array = new LinkedList[]{
                new LinkedList<>(List.of(2, 4, 6, 8)),
                new LinkedList<>(List.of(3, 5, 6)),
                new LinkedList<>(List.of(1, 7, 9))
        };

        LinkedList<Integer>[] expectedArray = new LinkedList[]{
                new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8)),
                new LinkedList<>(List.of(1, 2, 3, 4, 5, 6)),
                new LinkedList<>(List.of(1, 5, 7, 8, 9, 10))
        };

        for (int testCase = 0; testCase < list1Array.length; testCase++) {
            LinkedList<Integer> list1 = list1Array[testCase];
            LinkedList<Integer> list2 = list2Array[testCase];
            LinkedList<Integer> expected = expectedArray[testCase];

            LinkedList<Integer> output = Problems.problem6(list1, list2);
            assertIterableEquals(expected, output);
        }
    }

    @Test
    public void testProblem7() {
        int[] input1 = {1, 2, 3};
        int[] expected1 = {1, 2, 4};
        assertArrayEquals(expected1, Problems.problem7(input1));

        int[] input2 = {4, 3, 2, 1};
        int[] expected2 = {4, 3, 2, 2};
        assertArrayEquals(expected2, Problems.problem7(input2));

        int[] input3 = {9};
        int[] expected3 = {1, 0};
        assertArrayEquals(expected3, Problems.problem7(input3));
    }



}
