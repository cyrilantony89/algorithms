package cyril.arsecium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixExpressionEvaluation {

	static Map<String, Integer> mp = new HashMap<>();

	public static void main(String[] args) {

		mp.put("-", 1);
		mp.put("+", 2);
		mp.put("*", 3);
		mp.put("/", 4);

		String s = "3/4+5-2*4"; // 3 4 / 5 + 2 4 * -  >> 3 4 5 + / 2 4 * -
		Stack<String> out = new Stack<>();
		Stack<String> stack = new Stack<>();

		int length = s.length();
		int i = 0;
		while (i < length) {

			String ch = "" + s.charAt(i);
			if (!operand(ch)) {
				out.push(ch);

			} else {
				if (lowtoHigh(ch, stack)) {
					String val2 = out.pop();
					String val1 = out.pop();
					String evaluate = evaluate(val1, val2, stack.pop());
					out.push(evaluate);
				}
				stack.push(ch);
				

			}
			System.out.println("out"+out);
			System.out.println("stack"+stack);
			i++;

		}

		while (!stack.isEmpty()) {
			String val2 = out.pop();
			String val1 = out.pop();
			String evaluate = evaluate(val1, val2, stack.pop());
			out.push(evaluate);

		}
		System.out.println(out.toString());
	}

	private static String evaluate(String val1, String val2, String operand) {

		switch (operand) {
		case "+":
			return String.valueOf(Integer.valueOf(val1) + Integer.valueOf(val2));
		case "-":
			return String.valueOf((Integer.valueOf(val1) - Integer.valueOf(val2)));
		case "*":
			return String.valueOf(Integer.valueOf(val1) * Integer.valueOf(val2));
		case "/":
			return String.valueOf(Integer.valueOf(val1) / Integer.valueOf(val2));
		default:
			return String.valueOf(-1);

		}
	}

	private static boolean lowtoHigh(String ch, Stack<String> stack) {
		if (stack.isEmpty())
			return false;
		return mp.get(ch) < mp.get(stack.peek());

	}

	private static boolean operand(String ch) {
		switch (ch) {
		case "+":
		case "-":
		case "*":
		case "/":
			return true;
		default:
			return false;

		}

	}

}
