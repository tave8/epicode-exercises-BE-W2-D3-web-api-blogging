package giuseppetavella.web_api_blogging.controllers;


import giuseppetavella.web_api_blogging.entities.Author;
import giuseppetavella.web_api_blogging.entities.BlogPost;
import giuseppetavella.web_api_blogging.payloads.NewAuthorPayload;
import giuseppetavella.web_api_blogging.payloads.NewBlogPostPayload;
import giuseppetavella.web_api_blogging.services.BlogPostsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostsController {

    private final BlogPostsService blogPostsService;
    
    public BlogPostsController(BlogPostsService blogPostsService) {
        this.blogPostsService = blogPostsService;
    }


    @GetMapping
    public List<BlogPost> findAll() {
        return blogPostsService.findAll();
    }

    @GetMapping("/{blogPostId}")
    public BlogPost findOne(@PathVariable String blogPostId) {
        return blogPostsService.findOne(blogPostId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public BlogPost add(@RequestBody NewBlogPostPayload body) {
        return blogPostsService.add(body);
    }

    @PutMapping("/{blogPostId}")
    public BlogPost update(@PathVariable String blogPostId, @RequestBody NewBlogPostPayload body) {
        return blogPostsService.update(blogPostId, body);
    }


    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String blogPostId) {
        blogPostsService.delete(blogPostId);
    }

}
