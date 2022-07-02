import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char character : expression.toCharArray()) {
            if(character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if(character == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            } else if(!stack.isEmpty() && character == '}') {
                if(stack.peek() == '{') stack.pop();
                else return false;
            } else if(!stack.isEmpty() && character == ']') {
                if(stack.peek() == '[') stack.pop();
                else return false;
            } 
        }
        return stack.isEmpty();
    }
}
