package com.developertracker.commitactivity.dto;

import com.developertracker.commitactivity.model.GithubCommit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommitDto {


        @JsonProperty("author")
        private AuthorDto authorDto;

        private String message;
    }