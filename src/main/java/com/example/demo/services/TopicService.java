package com.example.demo.services;

import com.example.demo.models.Topic;
import com.example.demo.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    List<Topic> topicList = new ArrayList<Topic>();

    @Autowired
    TopicRepository topicRepository;

    public Topic createTopic(String lessonId, Topic newTopic) {
        newTopic.setLessonId(lessonId);
        return topicRepository.save(newTopic);
    }

    public Topic findTopicById(Integer topicId) {
        return topicRepository.findTopicById(topicId);
    }

    public List<Topic> findAllTopics() {
        return topicRepository.findAllTopics();
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }

    public int deleteTopic(Integer topicId) {
        topicRepository.deleteById(topicId);
        return 1;
    }

    public int updateTopic(int topicId, Topic updatedTopic) {
        for (int i = 0; i < topicList.size(); i++) {
            if (topicList.get(i).getId() == topicId) {
                topicList.set(i, updatedTopic);
                return 1;
            }
        }
        return 0;
    }
}
