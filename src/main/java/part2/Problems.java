package part2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Problems {
    //problem 1
    public static int[] problem1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    //problem 2
    public static boolean problem2(int x) {
        String numStr = Integer.toString(x);
        char[] numChars = numStr.toCharArray();

        for (int i = 0, j = numChars.length - 1; i < j; i++, j--) {
            char temp = numChars[i];
            numChars[i] = numChars[j];
            numChars[j] = temp;
        }

        String reversedStr = new String(numChars);

        return numStr.equals(reversedStr);
    }

    public static String problem3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < firstStr.length() && i < lastStr.length(); i++) {
            if (firstStr.charAt(i) == lastStr.charAt(i)) {
                commonPrefix.append(firstStr.charAt(i));
            } else {
                break;
            }
        }
        return commonPrefix.toString();
    }

    //problem 4
    public static int problem4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = romanValues.get(s.charAt(i));
            //subtract condition
            if (i < s.length() - 1 && romanValues.get(s.charAt(i + 1)) > cur) {
                result -= cur;
            } else {
                result += cur;
            }
        }

        return result;
    }

    //problem 5
    public static boolean problem5(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char bracket = st.pop();
                if ((c == ')' && bracket != '(') ||
                        (c == ']' && bracket != '[') ||
                        (c == '}' && bracket != '{')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static LinkedList<Integer> problem6(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        // base
        if (list1 == null || list1.isEmpty()) {
            return list2;
        } else if (list2 == null || list2.isEmpty()) {
            return list1;
        }

        LinkedList<Integer> mergedList = new LinkedList<>();
        int i = 0, j = 0;

        // splice lists
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }
        }

        // append remaining elements
        while (i < list1.size()) {
            mergedList.add(list1.get(i++));
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j++));
        }

        return mergedList;
    }

    public static int[] problem7(int[] digits) {
        int len = digits.length;
        int lastElement = digits[len - 1];
        if (lastElement != 9) {
            digits[len - 1] = lastElement + 1;
            return digits;
        } else {
            int rem = 1;
            for (int i = len - 1; i >= 0; i--) {
                int sum = digits[i] + rem;
                digits[i] = sum % 10;
                rem = sum / 10;
                if (rem == 0) {
                    return digits;
                }
            }

            int[] result = new int[len + 1];
            result[0] = rem;

            System.arraycopy(digits, 0, result, 1, len);

            return result;
        }
    }


}
