package giuseppetavella.web_api_blogging.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("L'elemento con ID " + id + " non è stato trovato.");
    }
}
