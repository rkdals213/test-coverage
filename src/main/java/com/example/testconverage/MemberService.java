package com.example.testconverage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {
    @Autowired
    private MemberRepository repository;

    public Map<String, String> findAll() {
        return repository.findAll();
    }

    public String findByKey(String key) {
        return repository.findByKey(key);
    }

    public int save(String key, String data) {
        return repository.save(key, data);
    }

    public int update(String key, String data) {
        return repository.update(key, data);
    }

    public int delete(String key) {
        return repository.delete(key);
    }
}
