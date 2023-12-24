package com.developertracker.commitactivity.repository;


import com.developertracker.commitactivity.model.GithubCommit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GithubCommitRepository extends MongoRepository<GithubCommit, String> {
    List<GithubCommit> findAllByAuthorName(String authorName);
}

