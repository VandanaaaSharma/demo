// package com.example.demo.service;

// import com.example.demo.entity.Marks;
// import com.example.demo.repository.MarksRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class MarksServiceImpl implements MarksService {

//     private final MarksRepository marksRepository;

//     public MarksServiceImpl(MarksRepository marksRepository) {
//         this.marksRepository = marksRepository;
//     }

//     @Override
//     public Marks addMarks(Marks marks) {
//         return marksRepository.save(marks);
//     }

//     @Override
//     public Marks updateMarks(Long id, Marks updatedMarks) {
//         Marks existing = marksRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Mark not found"));

//         existing.setMarks(updatedMarks.getMarks());
//         existing.setSemester(updatedMarks.getSemester());
//         existing.setStudent(updatedMarks.getStudent());
//         existing.setSubject(updatedMarks.getSubject());

//         return marksRepository.save(existing);
//     }

//     @Override
//     public boolean deleteMarks(Long id) {
//         if (marksRepository.existsById(id)) {
//             marksRepository.deleteById(id);
//             return true;
//         }
//         return false;
//     }

//     @Override
//     public List<Marks> getMarksByStudent(String studentId) {
//         return marksRepository.findAll()
//                 .stream()
//                 .filter(m -> String.valueOf(m.getStudent().getId()).equals(studentId))
//                 .toList();
//     }

//     @Override
//     public Marks getMarkById(Long id) {
//         return marksRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<Marks> getAllMarks() {
//         return marksRepository.findAll();
//     }
// }
