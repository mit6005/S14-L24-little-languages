package music;

/**
 * A binary function f : T x U -> V.
 */
public interface BinaryFunction<T,U,V> {
    /**
     * @param t first argument
     * @param u second argument
     * @return f(t, u)
     */
    V apply(T t, U u);
}
