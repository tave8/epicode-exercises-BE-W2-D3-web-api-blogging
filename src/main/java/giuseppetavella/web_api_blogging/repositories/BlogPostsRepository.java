package giuseppetavella.web_api_blogging.repositories;

import giuseppetavella.web_api_blogging.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogPostsRepository extends JpaRepository<BlogPost, UUID> {
    
    
    
}
