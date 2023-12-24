package com.developertracker.commitactivity.service;


import com.developertracker.commitactivity.dto.CommitDetailsDto;
import com.developertracker.commitactivity.model.GithubCommit;

import java.util.List;

public interface GithubCommitService {
    List<GithubCommit> getGithubCommit();

    List<GithubCommit> getAllCommits();

   CommitDetailsDto getAllCommitsByAuthorName(String authorName);
}

