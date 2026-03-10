package mk.ukim.finki.emc.bookrental.model.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " with id " + id + " was not found.");
    }
}
