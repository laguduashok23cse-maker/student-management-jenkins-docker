package com.example.studentmanagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class StudentController {
    private final StudentRepository repository;
    public StudentController(StudentRepository repository) { this.repository=repository; }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", repository.findAll());
        model.addAttribute("student", new Student());
        return "index";
    }
    @PostMapping("/students")
    public String save(@ModelAttribute Student student) {
        repository.save(student);
        return "redirect:/";
    }
    @GetMapping("/students/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("student", repository.findById(id).orElseThrow());
        model.addAttribute("students", repository.findAll());
        return "index";
    }
    @GetMapping("/students/delete/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
