package cyril.visa;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class TriFunctionUsage<T, U, V, X>{
	
	

	private T one;
	private U two;
	private V three;

	public X use(TriFunction<T, U, V, X> meth){
		return meth.apply(one, two, three);
		
		
	}
	static ThreadPoolExecutor service;
	public static void main(String[] args) {
		
		TriFunctionUsage<String, String, String, String> triFunctionUsage = new TriFunctionUsage<String, String , String , String>();
		String a = triFunctionUsage.use((a1 , b , c) -> { return null;} );
		
		
		
		 service = new ThreadPoolExecutor(10, 100, 0, null, null);
		
		
		Runnable task = new CustomTask("url");
		service.submit(task  );
		
		
		
	}
	
	static class CustomTask implements Runnable, Parser {
		
		String url;
		CustomTask(String url){
			this.url = url;
		}
		public void run() {
			List<String> parse = parse(url);
			for (String string : parse) {
				service.submit(new CustomTask(url));
			}
		}
		@Override
		public List<String> parse(String url) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	
	static interface Parser {
		List<String>  parse (String url);
	}
	
 	
	
}
