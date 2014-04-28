package music;

/**
 * An unary function f : T -> U.
 */
public interface UnaryFunction<T,U> {
    /**
     * @param t argument
     * @return f(t)
     */
    U apply(T t);
}
