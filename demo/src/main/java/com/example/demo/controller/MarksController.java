package com.example.demo.controller;

import com.example.demo.entity.Marks;
import com.example.demo.service.MarksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
@CrossOrigin("*")
public class MarksController {

    private final MarksService marksService;

    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    // Add marks (Teacher)
    @PostMapping("/add")
    public Marks addMarks(@RequestBody Marks marks) {
        return marksService.addMarks(marks);
    }

    // Get marks of a student
    @GetMapping("/student/{id}")
    public List<Marks> getStudentMarks(@PathVariable Long id) {
        return marksService.getMarksByStudent(id);
    }
}
