package com.developertracker.commitactivity.repository;


import com.developertracker.commitactivity.model.GithubCommit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubCommitRepository extends MongoRepository<GithubCommit, String> {

}