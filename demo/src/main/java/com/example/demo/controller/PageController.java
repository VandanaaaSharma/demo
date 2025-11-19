package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Home role selection page
    @GetMapping("/role-selection.html")
    public String roleSelectionPage() {
        return "role-selection";
    }

    // Student pages
    @GetMapping("/student-register.html")
    public String studentRegisterPage() {
        return "student-register";
    }

    @GetMapping("/student-login.html")
    public String studentLoginPage() {
        return "student-login";
    }

    @GetMapping("/student-dashboard.html")
    public String studentDashboardPage() {
        return "student-dashboard";
    }

    // Teacher pages
    @GetMapping("/teacher-register.html")
    public String teacherRegisterPage() {
        return "teacher-register";
    }

    @GetMapping("/teacher-login.html")
    public String teacherLoginPage() {
        return "teacher-login";
    }

    @GetMapping("/teacher-dashboard.html")
    public String teacherDashboardPage() {
        return "teacher-dashboard";
    }
}
