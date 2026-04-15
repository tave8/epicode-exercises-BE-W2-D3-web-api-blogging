package giuseppetavella.web_api_blogging.controllers;


import giuseppetavella.web_api_blogging.entities.Author;
import giuseppetavella.web_api_blogging.entities.BlogPost;
import giuseppetavella.web_api_blogging.payloads.NewAuthorPayload;
import giuseppetavella.web_api_blogging.payloads.NewBlogPostPayload;
import giuseppetavella.web_api_blogging.services.BlogPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {
    
    @Autowired
    private BlogPostsService blogPostsService;

    @GetMapping
    public List<BlogPost> findAll() {
        return this.blogPostsService.findAll();
    }

    @GetMapping("/{blogPostId}")
    public BlogPost findById(@PathVariable UUID blogPostId) {
        return this.blogPostsService.findById(blogPostId);
    }

    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BlogPost add(@RequestBody NewBlogPostPayload body) {
        return this.blogPostsService.saveNewBlogPost(body);
    }
    //
    // @PutMapping("/{blogPostId}")
    // public BlogPost update(@PathVariable String blogPostId, @RequestBody NewBlogPostPayload body) {
    //     return blogPostsService.update(blogPostId, body);
    // }
    //
    //
    // @DeleteMapping("/{blogPostId}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void delete(@PathVariable String blogPostId) {
    //     blogPostsService.delete(blogPostId);
    // }

}
