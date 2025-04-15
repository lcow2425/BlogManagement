package models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlogTest {

    @Test
    public void testGetPostsByAuthorAgeReturnsCorrectPostIds() {
        Person p1 = Person.builder().id("1").firstName("John").lastName("Doe").age(30).gender("Male").build();
        Person p2 = Person.builder().id("2").firstName("Jane").lastName("Doe").age(25).gender("Female").build();

        BlogPost bp1 = BlogPost.builder().id("p1").authorId("1").postContent("Post by John").build();
        BlogPost bp2 = BlogPost.builder().id("p2").authorId("2").postContent("Post by Jane").build();
        BlogPost bp3 = BlogPost.builder().id("p3").authorId("2").postContent("Another post by Jane").build();

        Blog blog = new Blog(Arrays.asList(bp1, bp2, bp3), Arrays.asList(p1, p2));
        List<String> result = blog.getPostsByAuthorAge(25);

        assertEquals(2, result.size());
        assertTrue(result.contains("p2"));
        assertTrue(result.contains("p3"));
    }

    @Test
    public void testGetPostsByAuthorAgeWithNoMatch() {
        Person p1 = Person.builder().id("1").firstName("John").lastName("Doe").age(30).gender("Male").build();
        BlogPost bp1 = BlogPost.builder().id("p1").authorId("1").postContent("Post by John").build();

        Blog blog = new Blog(Collections.singletonList(bp1), Collections.singletonList(p1));
        List<String> result = blog.getPostsByAuthorAge(99);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetPostsByAuthorAgeWithMissingAuthor() {
        BlogPost bp1 = BlogPost.builder().id("p1").authorId("404").postContent("Unknown author").build();
        Blog blog = new Blog(Collections.singletonList(bp1), Collections.emptyList());

        List<String> result = blog.getPostsByAuthorAge(25);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetPostsByAuthorAgeWithEmptyLists() {
        Blog blog = new Blog(Collections.emptyList(), Collections.emptyList());
        List<String> result = blog.getPostsByAuthorAge(25);
        assertTrue(result.isEmpty());
    }
}