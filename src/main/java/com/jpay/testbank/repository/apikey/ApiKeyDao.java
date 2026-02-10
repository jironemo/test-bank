package com.jpay.testbank.repository.apikey;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpay.testbank.model.auth.ApiKey;

public interface ApiKeyDao extends JpaRepository<ApiKey, Long> {
    public ApiKey findByValue(String apiKeyString);
}
