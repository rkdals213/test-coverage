package com.example.testconverage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping
    public Map<String, String> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/detail")
    public Map<String, String> findByKey(@RequestParam String key) {
        return Map.of(
                "result", memberService.findByKey(key)
        );
    }

    @PostMapping
    public Map<String, String> save(@RequestParam String key, @RequestParam String data) {
        return Map.of(
                "result", memberService.save(key, data) == 1 ? "success" : "fail"
        );
    }

    @PutMapping
    public Map<String, String> update(@RequestParam String key, @RequestParam String data) {
        return Map.of(
                "result", memberService.update(key, data) == 1 ? "success" : "fail"
        );
    }

    @DeleteMapping
    public Map<String, String> delete(@RequestParam String key) {
        return Map.of(
                "result", memberService.delete(key) == 1 ? "success" : "fail"
        );
    }
}
