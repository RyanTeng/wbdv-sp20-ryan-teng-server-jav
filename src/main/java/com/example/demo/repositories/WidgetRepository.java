package com.example.demo.repositories;

import com.example.demo.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository
        extends CrudRepository<Widget, Integer> {

    @Query("SELECT widget FROM Widget widget")
    List<Widget> findAllWidgets();

    @Query("SELECT widget FROM Widget widget WHERE widget.id=:widgetId")
    Widget findWidgetById(
            @Param("widgetId") Integer widgetId);

    // SELECT * FROM cs4550_sp20.widgets WHERE topic_id='222';
    // @Query(nativeQuery = true, value = "SELECT * FROM widgets WHERE topic_id=:tid")
    @Query("SELECT widget FROM Widget widget WHERE widget.topicId=:topicId")
    List<Widget> findWidgetsForTopic(
            @Param("topicId") String topicId);
}
