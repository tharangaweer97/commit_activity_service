package com.developertracker.commitactivity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubCommitDto {

    @JsonProperty("commit")
    private CommitDto commitDto;


}