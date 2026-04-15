package giuseppetavella.web_api_blogging.services;


import giuseppetavella.web_api_blogging.entities.Author;
import giuseppetavella.web_api_blogging.entities.BlogPost;
import giuseppetavella.web_api_blogging.exceptions.NotFoundException;
import giuseppetavella.web_api_blogging.payloads.NewAuthorPayload;
import giuseppetavella.web_api_blogging.payloads.NewBlogPostPayload;
import giuseppetavella.web_api_blogging.repositories.AuthorsRepository;
import giuseppetavella.web_api_blogging.repositories.BlogPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogPostsService {

    @Autowired
    private BlogPostsRepository blogPostsRepository;
    
    @Autowired
    private AuthorsService authorsService;
    

    public List<BlogPost> findAll() {
        return this.blogPostsRepository.findAll();
    }

    public BlogPost saveNewBlogPost(NewBlogPostPayload body) throws NotFoundException {
        // fai i controlli qui dentro
        
        // prima di aggiungere il blog post, trova l'autore,
       //  se esiste
       Author author = this.authorsService.findById(body.getAuthorId());
        
        BlogPost newBlogPost = new BlogPost(
                author,
                body.getTitolo(),
                body.getCategoria(),
                body.getContenuto(),
                body.getTempoDiLettura()
        );

        this.blogPostsRepository.save(newBlogPost);
        return newBlogPost;
    }

    // public BlogPost update(String blogPostIdStr, NewBlogPostPayload body) {
    //     BlogPost blogPost = this.findOne(blogPostIdStr);
    //
    //     blogPost.setTitolo(body.getTitolo());
    //     blogPost.setCategoria(body.getCategoria());
    //     blogPost.setContenuto(body.getContenuto());
    //     blogPost.setTempoDiLettura(body.getTempoDiLettura());
    //
    //     return blogPost;
    // }
    //
    //
    // public BlogPost delete(String blogPostIdStr) {
    //     BlogPost blogPost = this.findOne(blogPostIdStr);
    //
    //     this.blogPosts.remove(blogPost);
    //
    //     return blogPost;
    // }



    public BlogPost findById(UUID blogPostId) {
        Optional<BlogPost> maybeBlogPost = this.blogPostsRepository.findById(blogPostId);

        if (maybeBlogPost.isEmpty()) {
            throw new NotFoundException(blogPostId, "blog post");
        }

        return maybeBlogPost.get();
    }

}
