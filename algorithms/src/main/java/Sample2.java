public class Sample2 {
	public static void main(String[] args) {

		double startVal = 100.00;
		double minVal = 1.0;
		int unitAmount = 5000;
		double percent = 5.0;
		double trnscnPercent = 0.48;

		int total = 0;
		int totalnum = 0;
		int trnscnCount = 0;
		double val = startVal;
		int num = 0;

		double ratio = (double) (1 - (percent / 100));
		while (val > minVal) {
			trnscnCount++;
			num = (int) Math.floor(unitAmount / val);
			totalnum += num;
			System.out.println("Buy " + num + " shares at Rs:" + val);
			total += num * val;
			double avg = Math.round((total*10.0)/(totalnum*10.0));
			System.out.println("Total Rs:" + total + "  Shares:" + totalnum + "  Avg:" + avg);
			double loss = Math.round((total - totalnum * val) * 10.0 / 10.0);
			double lossPercent = Math.round((loss * 100 / total)*10.0/10.0);
			System.out.println("Current Loss:" + loss + " @ " + lossPercent + " %");
			double profit = totalnum * startVal - total;
			double profitPercent = profit * 100 / total;
			System.out.println("Profit (if sold at Rs:" + startVal + "):" + Math.round(profit*10.0/10.0) + " at " + Math.round(profitPercent*10.0/10.0) + "%");
			System.out.println("Transactions Num:" + trnscnCount);
			double trnscnChrgs = trnscnCount * unitAmount * (trnscnPercent / 100);
			System.out.println("Transaction Charges:" + Math.round(trnscnChrgs*10.0/10.0));
			double grossProfit = total * (percent / 100);
			System.out.println("Profit before charges:" + Math.round(grossProfit*10.0/10.0));
			int netProfit = (int) (grossProfit - trnscnChrgs);
			int proPercent = netProfit * 100 / total;
			System.out.println("Profit after charges:" + netProfit + " at " + proPercent + "%");
			System.out.println();
			val = Math.round(val * ratio*10.0)/10.0;;
		}

	}

}
