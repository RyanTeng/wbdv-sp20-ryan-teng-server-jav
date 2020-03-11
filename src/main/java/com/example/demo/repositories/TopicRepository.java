package com.example.demo.repositories;

import com.example.demo.models.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository
        extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic")
    List<Topic> findAllTopics();

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:topicId")
    Topic findTopicById(
            @Param("topicId") Integer topicId);

    // SELECT * FROM cs4550_sp20.Topics WHERE topic_id='222';
    // @Query(nativeQuery = true, value = "SELECT * FROM Topics WHERE topic_id=:tid")
    @Query("SELECT topic FROM Topic topic WHERE topic.lessonId=:lessonId")
    List<Topic> findTopicsForLesson(
            @Param("lessonId") String lessonId);
}
