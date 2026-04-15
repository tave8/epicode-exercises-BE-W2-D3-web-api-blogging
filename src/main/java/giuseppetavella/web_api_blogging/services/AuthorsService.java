package giuseppetavella.web_api_blogging.services;


import giuseppetavella.web_api_blogging.entities.Author;
import giuseppetavella.web_api_blogging.payloads.NewAuthorPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorsService {
    
    private final List<Author> authors = new ArrayList<>();
    
    public List<Author> findAll() {
        return this.authors;
    }
    
    public Author add(NewAuthorPayload body) {
        Author newAuthor = new Author(
                body.getNome(),
                body.getCognome(),
                body.getEmail(),
                body.getDataNascita()
        );
        
        authors.add(newAuthor);
        return newAuthor;
    }

    public Author update(String authorIdStr, NewAuthorPayload body) {
        Author author = this.findOne(authorIdStr);
        
        author.setNome(body.getNome());
        author.setCognome(body.getCognome());
        author.setEmail(body.getEmail());
        author.setDataNascita(body.getDataNascita());
        
        return author;
    }


    public Author delete(String authorIdStr) {
        Author author = this.findOne(authorIdStr);

        this.authors.remove(author);

        return author;
    }
    
    
    
    public Author findOne(String authorIdStr) {
        UUID authorId;
        
        try {
            authorId = UUID.fromString(authorIdStr);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex);
        }
        
        Author authorFound = null;
        
        // find by id
        for (Author author : this.authors) {
            if (author.getId().equals(authorId)) {
                authorFound = author;
            }
        }
        
        if (authorFound == null) {
            throw new RuntimeException("author with ID " + authorIdStr + " was not found");
        }
        
        return authorFound;
    }
    
}
