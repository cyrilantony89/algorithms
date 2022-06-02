package cyril.arsecium;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NAV {
	public static void main(String[] args) {
		// tes 1
		System.out.println(calculateNAV("20190331"));

		// tes 2
		System.out.println(calculateNAV("20190725"));
		// tes 3
		System.out.println(calculateNAV("20191205"));

		// tes 4
		System.out.println(calculateNAV("20190119"));

	}

	public static double calculateNAV(String date) {

		double total = 0.0;
		try {
			Map<String, Integer> holdingsMap = findHoldingsMap(date);
			System.out.println(holdingsMap);
			Map<String, Double> priceMap = findPriceMap(date);
			System.out.println(priceMap);

			for (Entry<String, Integer> entry : holdingsMap.entrySet()) {
				String security = entry.getKey();
				int quantity = entry.getValue();
				Double price = priceMap.get(security);
				total += quantity * price;
			}
			return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}

	public static Map<String, Double> findPriceMap(String date) throws Exception {
		URL priceApiUrl = new URL(
				"https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing");
		HttpURLConnection conn = (HttpURLConnection) priceApiUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		int response = conn.getResponseCode();
		Scanner s = new Scanner(priceApiUrl.openStream());
		String res = "";
		while (s.hasNext()) {
			res += s.nextLine();
		}
		s.close();
		return parsePriceJson(res, date);
	}

	public static Map<String, Double> parsePriceJson(String jsonString, String reqdate) {
		Map<String, Double> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		PricePojo[] pricePojos = gson.fromJson(jsonString, PricePojo[].class);
		for (int i = 0; i < pricePojos.length; i++) {
			PricePojo pricePojo = pricePojos[i];
			String date = pricePojo.getDate();
			if (!reqdate.equals(date)) {
				continue;
			}
			String sec = pricePojo.getSecurity();
			Double price = pricePojo.getPrice();
			map.put(sec, price);
		}

		return map;

	}

	static class PricePojo {
		String date;
		String security;
		Double price;

		public String getDate() {
			return this.date;
		}

		public String getSecurity() {
			return this.security;
		}

		public Double getPrice() {
			return this.price;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public void setSecurity(String security) {
			this.security = security;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

	}

	public static Map<String, Integer> findHoldingsMap(String date) throws Exception {
		URL holdingsApiUrl = new URL(
				"https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");
		HttpURLConnection conn = (HttpURLConnection) holdingsApiUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();

		int response = conn.getResponseCode();

		Scanner s = new Scanner(holdingsApiUrl.openStream());

		String res = "";
		while (s.hasNext()) {
			res += s.nextLine();
		}

		s.close();

		return parseHoldingsJson(res, date);
	}

	static class HoldingPojo {
		String date;
		String security;
		int quantity;
		String portfolio;

		public String getDate() {
			return this.date;
		}

		public String getSecurity() {
			return this.security;
		}

		public int getQuantity() {
			return this.quantity;
		}

		public String getPortfolio() {
			return this.portfolio;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public void setSecurity(String security) {
			this.security = security;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public void setPortfolio(String portfolio) {
			this.portfolio = portfolio;
		}

	}

	public static Map<String, Integer> parseHoldingsJson(String jsonString, String reqdate) {
		Map<String, Integer> map = new HashMap<>();
		Gson gson = new GsonBuilder().create();
		HoldingPojo[] holdings = gson.fromJson(jsonString, HoldingPojo[].class);
		for (int i = 0; i < holdings.length; i++) {
			HoldingPojo holding = holdings[i];
			String date = holding.getDate();
			if (!reqdate.equals(date)) {
				continue;
			}
			String sec = holding.getSecurity();
			int quantity = holding.getQuantity();
			int count = 0;
			if (map.containsKey(sec)) {
				count = map.get(sec);
			}
			count += quantity;
			map.put(sec, count);
		}

		return map;

	}

}
