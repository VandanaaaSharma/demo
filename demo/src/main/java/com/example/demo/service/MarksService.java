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

    public Marks addMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    public Marks updateMarks(Long id, Marks updatedMarks) {
        return marksRepository.findById(id)
                .map(m -> {
                    m.setMarks(updatedMarks.getMarks());
                    m.setSemester(updatedMarks.getSemester());
                    m.setStudent(updatedMarks.getStudent());
                    m.setSubject(updatedMarks.getSubject());
                    return marksRepository.save(m);
                }).orElse(null);
    }

    public boolean deleteMarks(Long id) {
        if (marksRepository.existsById(id)) {
            marksRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Marks> getMarksByStudent(Long studentId) {
        return marksRepository.findAll()
                .stream()
                .filter(m -> m.getStudent().getId().equals(studentId))
                .toList();
    }

    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }
}
