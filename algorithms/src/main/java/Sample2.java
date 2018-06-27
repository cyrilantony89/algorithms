public class Sample2 {
	public static void main(String[] args) {

		int startVal = 77;// 450;//155;
		int minVal = 40;// 200;//20;
		int unitAmount = 5000;
		double percent = 10.0;
		double trnscnPercent = 0.48;

		int total = 0;
		int totalnum = 0;
		int trnscnCount = 0;
		int val = startVal;
		int num = (int) Math.ceil(unitAmount / val);// 0;

		double ratio = (double) (1 - (percent / 100));
		while (val > minVal) {
			trnscnCount++;
			// num = (int) Math.ceil(unitAmount / val);
			totalnum += num;
			System.out.println("Buy " + num + " shares at Rs." + val);
			total += num * val;
			System.out.println("Total Rs:" + total + "  Shares:" + totalnum + "  Avg:" + total / totalnum);
			System.out.println("Current Loss:" + (total - totalnum * val));
			int profit = totalnum * startVal - total;
			int profitPercent = profit * 100 / total;
			System.out.println("Profit (if sold at Rs." + startVal + "):" + profit + " at " + profitPercent + "%");
			System.out.println("Transactions Num:" + trnscnCount);
			double trnscnChrgs = trnscnCount * unitAmount * (trnscnPercent / 100);
			System.out.println("Transaction Charges:" + trnscnChrgs);
			double grossProfit = total * (percent / 100);
			System.out.println("Profit before charges:" + grossProfit);
			int netProfit = (int) (grossProfit - trnscnChrgs);
			int proPercent = netProfit * 100 / total;
			System.out.println("Profit after charges:" + netProfit + " at " + proPercent + "%");
			System.out.println();
			val = (int) Math.floor(val * ratio);
		}

	}

}
