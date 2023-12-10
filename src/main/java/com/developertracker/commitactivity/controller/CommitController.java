package com.developertracker.commitactivity.controller;

import com.developertracker.commitactivity.model.GithubCommit;
import com.developertracker.commitactivity.service.GithubCommitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class CommitController {
    private GithubCommitService githubCommitService;

    @GetMapping("/contributors")
    public ResponseEntity<List<GithubCommit>> getGithubCommit() {
        return ResponseEntity.ok(this.githubCommitService.getGithubCommit());
    }

    @GetMapping("/commits/get-all")
    public ResponseEntity<List<GithubCommit>> getAllCommits() {
        return ResponseEntity.ok(this.githubCommitService.getAllCommits());
    }
}