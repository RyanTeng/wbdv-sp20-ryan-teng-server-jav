package com.example.demo.controllers;

import com.example.demo.models.Topic;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicService service;


    @PostMapping("api/lessons/{lid}/topics")
    public Topic createTopic(@PathVariable("lid") String lid, @RequestBody Topic newTopic) {
        return service.createTopic(lid,  newTopic);
    }

    @DeleteMapping("/apitopics/{tid}")
    public int deleteTopic(@PathVariable("tid") Integer tid) {
        return service.deleteTopic(tid);
    }

    @PutMapping("api/topics/{tid}")
    public int updateTopic(@PathVariable("tid") int tid, @RequestBody Topic updatedTopic) {
        return service.updateTopic(tid, updatedTopic);
    }

    @GetMapping("api/topics/{tid}")
    public Topic findTopicById(@PathVariable("tid") Integer tid) {
        return service.findTopicById(tid);
    }

    @GetMapping("api/topics")
    public List<Topic> findAllTopics() {
        return service.findAllTopics();
    }

    @GetMapping("api/lessons/{lid}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lid") String lessonId) {
        return service.findTopicsForLesson(lessonId);
    }
}
