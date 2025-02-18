package models;

import lombok.Getter;
import java.util.List;

@Getter
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }
}