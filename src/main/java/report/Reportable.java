package report;

/**
 * Represents visitor acceptor
 * @param <V>
 */
public interface Reportable<V> {

    void visit(V visitor);
}
