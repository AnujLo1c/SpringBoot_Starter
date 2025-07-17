package com.anujl.blacknwhite.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Override
    public String toString() {
        return id + "::" +
               escape(title) + "::" +
               escape(content) + "::" +
               createdAt;
    }

    public static Post fromString(String str) {
        try {
            String[] parts = str.split("::", -1);
            Post post = new Post();
            post.setId(Long.parseLong(parts[0]));
            post.setTitle(unescape(parts[1]));
            post.setContent(unescape(parts[2]));
            post.setCreatedAt(LocalDateTime.parse(parts[3]));
            return post;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Post format", e);
        }
    }

    private static String escape(String input) {
        return input.replace("::", "__DOUBLECOLON__").replace("\n", "\\n");
    }

    private static String unescape(String input) {
        return input.replace("__DOUBLECOLON__", "::").replace("\\n", "\n");
    }
}
