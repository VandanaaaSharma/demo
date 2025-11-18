package com.example.demo.service;

import com.example.demo.entity.Marks;
import com.example.demo.repository.MarksRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarksService {

    private final MarksRepository marksRepository;

    public MarksService(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }

    // Add marks
    public Marks addMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    // Get marks by student id
    public List<Marks> getMarksByStudent(Long studentId) {
        return marksRepository.findAll()
                .stream()
                .filter(m -> m.getStudent().getId().equals(studentId))
                .toList();
    }

    // Get all marks
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }
}

