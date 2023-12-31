package technifutur.be.technifutur.exception;

public class EntityNotFoundException extends EntityException {

    public EntityNotFoundException() {
        super("Book not found.");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
