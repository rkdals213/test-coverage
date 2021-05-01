package com.example.testconverage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestCoverageApplicationTests {
    @Autowired
    private MemberController controller;

    @Autowired
    private MemberRepository repository;

    @PostConstruct
    void initData() {
        repository.save("first", "firstData");
        repository.save("second", "secondData");
        repository.save("third", "thirdData");
        repository.save("forth", "forthData");
        repository.save("fifth", "fifthData");
    }

    @Test
    void findAll() {
        Map<String, String> result = controller.findAll();
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    void findOne() {
        Map<String, String> result = controller.findByKey("first");
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get("result")).isEqualTo("firstData");
    }

    @Test
    void save() {
        Map<String, String> saveResult = controller.save("sixth", "sixthData");
        Map<String, String> result = controller.findAll();
        assertThat(saveResult.get("result")).isEqualTo("success");
        assertThat(result.size()).isEqualTo(6);
    }

    @Test
    void update() {
        Map<String, String> updateResult = controller.update("first", "firstDataUpdated");
        Map<String, String> result = controller.findAll();
        assertThat(updateResult.get("result")).isEqualTo("success");
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    void delete() {
        Map<String, String> deleteResult = controller.delete("first");
        Map<String, String> result = controller.findAll();
        assertThat(deleteResult.get("result")).isEqualTo("success");
        assertThat(result.size()).isEqualTo(4);
    }
}
