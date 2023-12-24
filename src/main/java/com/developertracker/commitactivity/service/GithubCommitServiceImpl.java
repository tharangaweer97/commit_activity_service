package com.developertracker.commitactivity.service;


import com.developertracker.commitactivity.dto.CommitDetailsDto;
import com.developertracker.commitactivity.dto.GithubCommitDto;
import com.developertracker.commitactivity.model.GithubCommit;
import com.developertracker.commitactivity.repository.GithubCommitRepository;
import com.developertracker.commitactivity.service.external.GithubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GithubCommitServiceImpl implements GithubCommitService {

    private final GithubExternalClient githubExternalClient;
    private final GithubCommitRepository githubCommitRepository;

    @Override
    public List<GithubCommit> getGithubCommit() {
        List<GithubCommit> githubCommits = new ArrayList<>();

        List<GithubCommitDto> githubCommitDtoList = this.githubExternalClient.getCommitDetails();
        githubCommitDtoList.forEach(githubCommitDto -> {
            GithubCommit githubCommit = this.generateGitHubCommitObject(githubCommitDto);
            githubCommits.add(githubCommit);
        });

        this.githubCommitRepository.saveAll(githubCommits);

        return githubCommits;


    }

    @Override
    public List<GithubCommit> getAllCommits() {

        return this.githubCommitRepository.findAll();
    }

    @Override
    public CommitDetailsDto getAllCommitsByAuthorName(String authorName) {
        List<GithubCommit> gitHubCommits = this.githubCommitRepository.findAllByAuthorName(authorName.trim());
        return CommitDetailsDto.builder().commitCount(gitHubCommits.size()).userCommitList(gitHubCommits).build();
    }

    private GithubCommit generateGitHubCommitObject(GithubCommitDto gitHubCommitDto) {
        return GithubCommit.builder()
                .authorName(gitHubCommitDto.getCommitDto().getAuthorDto().getName())
                .commitMessage(gitHubCommitDto.getCommitDto().getMessage())
                .email(gitHubCommitDto.getCommitDto().getAuthorDto().getEmail())
                .date(gitHubCommitDto.getCommitDto().getAuthorDto().getDate())
                .build();
    }

}




