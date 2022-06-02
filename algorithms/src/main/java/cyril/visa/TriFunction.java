package cyril.visa;
// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public interface TriFunction<T, U , V , X> {
	
	public X apply(T one ,U two , V three);
	
}
