package giuseppetavella.web_api_blogging.services;


import giuseppetavella.web_api_blogging.entities.Author;
import giuseppetavella.web_api_blogging.entities.BlogPost;
import giuseppetavella.web_api_blogging.exceptions.NotFoundException;
import giuseppetavella.web_api_blogging.payloads.BlogPostToSendPayload;
import giuseppetavella.web_api_blogging.payloads.NewAuthorPayload;
import giuseppetavella.web_api_blogging.payloads.NewBlogPostPayload;
import giuseppetavella.web_api_blogging.repositories.AuthorsRepository;
import giuseppetavella.web_api_blogging.repositories.BlogPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    

    public Page<BlogPost> findAll(int page, int size, String sortBy) {
        // the size of each page (how many elements in each page)
        int finalSize = Math.min(10, size);
        // the page number
        int finalPage = Math.max(0, page);
        // page is the function that will get translated to SQL,
        // that will in turn filter the result set
        Pageable pageable = PageRequest.of(finalPage, finalSize, Sort.by(sortBy));
        // fare map tra gli oggetti del content e quello che voglio tornare (rappresentazione)
        return this.blogPostsRepository.findAll(pageable);
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


    public BlogPostToSendPayload findByIdAsPayload(UUID blogPostId) {
        BlogPost blogPost = this.findById(blogPostId);
        // map 
        BlogPostToSendPayload blogPostToSendPayload = new BlogPostToSendPayload(
                blogPost.getBlogPostId(),
                blogPost.getTitolo(),
                blogPost.getCategoria(),
                blogPost.getContenuto(),
                blogPost.getTempoDiLettura()
        );
        
        return blogPostToSendPayload;
    }


    public BlogPost findById(UUID blogPostId) {
        Optional<BlogPost> maybeBlogPost = this.blogPostsRepository.findById(blogPostId);

        if (maybeBlogPost.isEmpty()) {
            throw new NotFoundException(blogPostId, "blog post");
        }

        return maybeBlogPost.get();
    }

}
