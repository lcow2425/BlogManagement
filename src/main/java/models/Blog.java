package models;

import lombok.Getter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }

    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
                .filter(post -> {
                    Person author = contributors.stream()
                            .filter(person -> Objects.equals(person.getId(), post.getAuthorId()))
                            .findFirst()
                            .orElse(null);
                    return author != null && Objects.equals(author.getAge(), age);
                })
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }
}