package com.example.crudspringboot.controller;

import com.example.crudspringboot.model.Student;
import com.example.crudspringboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        logger.info("StudentController initialized");
    }

    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {
        model.addAttribute("currentUri", request.getRequestURI());
        logger.info("Request URI: {}", request.getRequestURI());
    }

    // Test endpoint to verify application is working
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        logger.info("Test endpoint accessed");
        return "Application is working! Student count: " + studentService.getAllStudents().size();
    }

    // Root route - redirect to students page
    @GetMapping("/")
    public String home() {
        logger.info("Root route accessed, redirecting to /students");
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        logger.info("List students route accessed");
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String showAddStudentForm(Model model) {
        logger.info("Add student form route accessed");
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        logger.info("Saving student: {}", student.getName());
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        logger.info("Edit student form route accessed for id: {}", id);
        Student student = studentService.getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        logger.info("Updating student with id: {}", id);
        student.setId(id);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        logger.info("Deleting student with id: {}", id);
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
