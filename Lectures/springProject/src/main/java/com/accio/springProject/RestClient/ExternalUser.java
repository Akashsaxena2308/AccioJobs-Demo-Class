package com.accio.springProject.RestClient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalUser(long id, String name) {}
