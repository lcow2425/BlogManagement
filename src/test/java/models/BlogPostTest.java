package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {
    @Test
    void testValidBlogPostCreation() {
        BlogPost post = new BlogPost("101", "1", "This is a test post.");
        assertEquals("101", post.getId());
    }

    @Test
    void testInvalidBlogPostCreation() {
        assertThrows(IllegalArgumentException.class, () -> new BlogPost(null, "1", "Post content"));
        assertThrows(IllegalArgumentException.class, () -> new BlogPost("101", null, "Post content"));
    }
}