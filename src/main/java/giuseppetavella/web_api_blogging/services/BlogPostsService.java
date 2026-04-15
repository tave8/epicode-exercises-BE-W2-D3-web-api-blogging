package giuseppetavella.web_api_blogging.services;


import giuseppetavella.web_api_blogging.entities.Author;
import giuseppetavella.web_api_blogging.entities.BlogPost;
import giuseppetavella.web_api_blogging.payloads.NewAuthorPayload;
import giuseppetavella.web_api_blogging.payloads.NewBlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BlogPostsService {

    private final List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> findAll() {
        return this.blogPosts;
    }

    public BlogPost add(NewBlogPostPayload body) {
        BlogPost newBlogPost = new BlogPost(
                body.getTitolo(),
                body.getCategoria(),
                body.getContenuto(),
                body.getTempoDiLettura()
        );

        this.blogPosts.add(newBlogPost);
        return newBlogPost;
    }

    public BlogPost update(String blogPostIdStr, NewBlogPostPayload body) {
        BlogPost blogPost = this.findOne(blogPostIdStr);

        blogPost.setTitolo(body.getTitolo());
        blogPost.setCategoria(body.getCategoria());
        blogPost.setContenuto(body.getContenuto());
        blogPost.setTempoDiLettura(body.getTempoDiLettura());

        return blogPost;
    }


    public BlogPost delete(String blogPostIdStr) {
        BlogPost blogPost = this.findOne(blogPostIdStr);

        this.blogPosts.remove(blogPost);

        return blogPost;
    }



    public BlogPost findOne(String blogPostIdStr) {
        UUID blogPostId;

        try {
            blogPostId = UUID.fromString(blogPostIdStr);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex);
        }

        BlogPost blogPostFound = null;

        // find by id
        for (BlogPost blogPost : this.blogPosts) {
            if (blogPost.getId().equals(blogPostId)) {
                blogPostFound = blogPost;
            }
        }

        if (blogPostFound == null) {
            throw new RuntimeException("blog post with ID " + blogPostIdStr + " was not found");
        }

        return blogPostFound;
    }

}
