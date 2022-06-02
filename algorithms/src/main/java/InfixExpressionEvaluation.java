import java.io.FileReader;
import java.io.LineNumberReader;

public class InfixExpressionEvaluation {

	public static void main(String[] args) {

		String socufile = "/Users/cantony/Downloads/airbnb.html	";
		try (FileReader fReader = new FileReader(socufile);
				LineNumberReader lnReader = new LineNumberReader(fReader);) {
			while (lnReader.skip(Long.MAX_VALUE) > 0)
				;
			int totalcount = lnReader.getLineNumber() + 1;
			System.out.println("The line num : " + totalcount);
			if (totalcount > 3) {
				throw new Exception("File line count exceeded MAX LIMIT of 50000");
			}
		} catch (Exception e1) {
			e1.printStackTrace();			// DO NOTHING. This exception will be caught
			// and thrown later during actual processing
		}

	}

}
