package com.example.demo.controller;

import com.example.demo.entity.Mark;
import com.example.demo.service.MarkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarkController {

    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    // Teacher adds marks
    @PostMapping("/teacher/addMarks")
    public String addMarks(@ModelAttribute Mark mark, Model model) {
        markService.save(mark);
        model.addAttribute("message", "Marks Added Successfully!");
        return "teacher-dashboard";
    }

    // Student views marks
    @GetMapping("/student/marks/{studentId}")
    public String viewMarks(@PathVariable Long studentId, Model model) {
        model.addAttribute("marksList", markService.getMarksByStudent(studentId));
        model.addAttribute("studentId", studentId);
        return "student-marks";
    }
}
