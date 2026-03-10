package mk.ukim.finki.emc.bookrental.model.exception;

public class NoAvailableCopiesException extends RuntimeException {

    public NoAvailableCopiesException(Long id) {
        super("Book with id " + id + " has no available copies.");
    }
}