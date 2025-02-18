package models;

import com.fasterxml.jackson.databind.annotation.Jacksonized;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Jacksonized
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    public BlogPost(String id, String authorId, String postContent) {
        if (id == null) throw new IllegalArgumentException("Post ID cannot be null.");
        if (authorId == null) throw new IllegalArgumentException("Author ID cannot be null.");

        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }
}