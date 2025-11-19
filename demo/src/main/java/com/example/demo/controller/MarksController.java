package com.example.demo.controller;

import com.example.demo.entity.Marks;
import com.example.demo.entity.Student;
import com.example.demo.service.MarksService;
import com.example.demo.service.StudentService;
import com.example.demo.service.SubjectService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marks")
@CrossOrigin("*")
public class MarksController {

    private final MarksService marksService;
    private final StudentService studentService;
    private final SubjectService subjectService;

    public MarksController(MarksService marksService, StudentService studentService, SubjectService subjectService) {
        this.marksService = marksService;
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    // Add marks using studentId
    @PostMapping("/add")
    public Marks addMarks(@RequestParam String studentId,
                          @RequestParam int semester,
                          @RequestParam Long subjectId,
                          @RequestParam int marks) {

        Student student = studentService.getStudentByStudentId(studentId);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        Marks newMarks = Marks.builder()
                .student(student)
                .semester(semester)
                .marks(marks)
                .subject(subjectService.getSubjectById(subjectId))
                .build();

        return marksService.addMarks(newMarks);
    }

    // Get student marks using studentId
    @GetMapping("/student")
    public List<Marks> getStudentMarks(@RequestParam String studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        if (student == null) return List.of();
        return marksService.getMarksByStudent(student.getId());
    }
}
