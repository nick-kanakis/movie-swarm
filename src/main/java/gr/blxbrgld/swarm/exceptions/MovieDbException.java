package gr.blxbrgld.swarm.exceptions;

/**
 * The Parent For All Custom Exceptions Related With The MovieDB API
 * @author blxbrgld
 */
public class MovieDbException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MovieDbException(){}

    public MovieDbException(final String message) {
        super(message);
    }

    public MovieDbException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MovieDbException(final Throwable cause) {
        super(cause);
    }
}
