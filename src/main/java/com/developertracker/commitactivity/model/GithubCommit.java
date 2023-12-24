package com.developertracker.commitactivity.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "github_commits")

public class GithubCommit {

    @Id
    private String id;

    private String authorName;

    private String commitMessage;

    private String date;

    private String email;
}