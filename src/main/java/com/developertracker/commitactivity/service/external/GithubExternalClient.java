package com.developertracker.commitactivity.service.external;


import com.developertracker.commitactivity.dto.GithubCommitDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GithubExternalClient {

    private final RestTemplate restTemplate;

    @Value("${github.commit-detail-url}")
    private String githubCommitDetailsUrl;

    public GithubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GithubCommitDto> getCommitDetails() {
        ResponseEntity<List<GithubCommitDto>> response = restTemplate.exchange(githubCommitDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }

}