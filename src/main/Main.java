package main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Blog;
import models.BlogPost;
import models.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Person> persons = mapper.readValue(new File("person.json"), new TypeReference<List<Person>>() {});
            List<BlogPost> posts = mapper.readValue(new File("blogPosts.json"), new TypeReference<List<BlogPost>>() {});

            Blog blog = new Blog(posts, persons);

            Integer ageFilter = 25;
            List<String> filteredPosts = blog.getPostsByAuthorAge(ageFilter);
            System.out.println("Posts by authors aged " + ageFilter + ": " + filteredPosts);

            System.out.println("Total Blog Posts: " + blog.getPosts().size());
            System.out.println("Total Contributors: " + blog.getContributors().size());

        } catch (IOException e) {
            System.err.println("Error reading JSON files: " + e.getMessage());
        }
    }
}