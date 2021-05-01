package com.example.testconverage;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    static Map<String, String> database = new HashMap<>();

    public Map<String, String> findAll() {
        return database;
    }

    public String findByKey(String key) {
        return database.getOrDefault(key, "");
    }

    public int save(String key, String data) {
        if (database.containsKey(key)) return 0;

        database.put(key, data);
        return 1;
    }

    public int update(String key, String data) {
        if (!database.containsKey(key)) return 0;

        database.replace(key, data);
        return 1;
    }

    public int delete(String key) {
        if (!database.containsKey(key)) return 0;

        database.remove(key);
        return 1;
    }
}
