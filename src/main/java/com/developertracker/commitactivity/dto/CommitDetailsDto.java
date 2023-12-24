package com.developertracker.commitactivity.dto;

import com.developertracker.commitactivity.model.GithubCommit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommitDetailsDto {

    private int commitCount;

    private List<GithubCommit> userCommitList;
}