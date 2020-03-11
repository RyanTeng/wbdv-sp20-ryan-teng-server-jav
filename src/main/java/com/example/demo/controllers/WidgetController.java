package com.example.demo.controllers;

import com.example.demo.models.Widget;
import com.example.demo.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;


    @PostMapping("api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable("tid") int tid, @RequestBody Widget newWidget) {
        return service.createWidget(tid, newWidget);
    }


    @DeleteMapping("api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") Integer wid) {
        return service.deleteWidget(wid);
    }

    @PutMapping("api/widgets/{wid}")
    public int updateWidget(@PathVariable("wid") int wid, @RequestBody Widget updatedWidget) {
        return service.updateWidget(wid, updatedWidget);
    }

    @GetMapping("api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Integer wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }
}
