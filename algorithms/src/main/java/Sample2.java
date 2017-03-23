public class Sample2 {
    public static void main(String[] args) {

        int val = 100;
        int num = 0;
        int total = 0;
        int totalnum = 0;
        int count = 0;
        double percent = 4.0;
        double ratio = (double) (1 - (percent / 100));
        while (val > 20) {
            count++;
            val = (int) Math.floor(val * ratio);
            num = (int) Math.ceil(4000 / val);
            totalnum += num;
            System.out.println("Buy " + num + " at Rs." + val);
            total += num * val;
            System.out.println("Total:" + total + "  Shares:" + totalnum + "  Avg:" + total / totalnum);
            System.out.println("Current Loss:" + (total - totalnum * val));
            System.out.println("Profit(is sold at Rs.100):" + (totalnum * 100 - total));
            System.out.println("Transactions:" + count);
            System.out.println("Transaction Charges:" + count * 20);
            System.out.println("Profit before charges:" + total * (percent / 100));
            System.out.println("Profit after charges:" + ((total * (percent / 100)) - (count * 20)));
            System.out.println();
        }

    }

}
