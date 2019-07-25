import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class IdeographicNumber {
	public static void main(String[] args) {
		int X = 9;
		System.out.println("Given Number : " + X);
		System.out.println("SmallestIdeographicNumber : " + smallestIdNum(X));
		
		int N = 15;
		int M = 100;
		long sum = 0;
		for (int i = 1; i <= N ; i++) {
			sum += smallestIdNum(i)%M;
		}
		System.out.println("Result : " + sum);
		

	}

	private static int smallestIdNum(int num) {
		Map<Integer, List<Integer>> digitVsIndexMap = new LinkedHashMap<Integer, List<Integer>>();
		String str = String.valueOf(num);
		for (int i = 0; i < str.length(); i++) {
			Integer digitAtIndex = Integer.valueOf("" + str.charAt(i));
			List<Integer> listOfIndexes = digitVsIndexMap.get(digitAtIndex);
			if (listOfIndexes == null) {
				digitVsIndexMap.put(digitAtIndex, new ArrayList<Integer>());
			}
			digitVsIndexMap.get(digitAtIndex).add(i);
		}
		char[] newStringArray = str.toCharArray();
		int[] digitArray = { 1, 0, 2, 3, 4, 5, 6, 7, 8, 9 };
		int counter = 0;
		for (Entry<Integer, List<Integer>> entry : digitVsIndexMap.entrySet()) {
			List<Integer> listOfIndexes = entry.getValue();
			int digitToReplace = digitArray[counter++];
			for (Integer in : listOfIndexes) {
				newStringArray[in] = ("" + digitToReplace).charAt(0);
			}
		}
		return Integer.valueOf(new String(newStringArray));
	}
}
