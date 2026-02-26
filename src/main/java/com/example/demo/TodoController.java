package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String list(Model model) {
        List<String> todos = List.of(
                "Spring Bootの学習",
                "ToDo一覧画面の作成",
                "Controllerの実装"
        );
        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @GetMapping("/new")
    public String newTodo() {
        return "todo/new";
    }

    @GetMapping("/confirm")
    public String confirmView(@RequestParam(value = "title", required = false, defaultValue = "") String title, Model model) {
        model.addAttribute("title", title);
        return "todo/confirm";
    }

    @PostMapping("/confirm")
    public String confirm(@RequestParam("title") String title, Model model) {
        model.addAttribute("title", title);
        return "todo/confirm";
    }

    @GetMapping("/complete")
    public String completeView() {
        return "todo/complete";
    }

    @PostMapping("/complete")
    public String complete(@RequestParam("title") String title) {
        todoService.createTodo(title);
        return "redirect:/todo";
    }
}
