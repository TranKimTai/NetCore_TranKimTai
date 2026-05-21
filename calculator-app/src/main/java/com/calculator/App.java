package com.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class App {

    // Thêm 2 hàm này để file AppTest.java quét không bị lỗi
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Lỗi: Không thể chia cho 0!");
        return a / b;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // Hiển thị giao diện HTML khi vào trang gốc
    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Xử lý tính toán khi nhấn nút từ giao diện HTML gửi lên
    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") int a,
                            @RequestParam("num2") int b,
                            @RequestParam("operator") String op,
                            Model model) {
        int result = 0;
        String errorMessage = null;

        try {
            switch (op) {
                case "add": result = add(a, b); break;
                case "subtract": result = subtract(a, b); break;
                case "multiply": result = multiply(a, b); break;
                case "divide": result = divide(a, b); break;
            }
        } catch (ArithmeticException e) {
            errorMessage = e.getMessage();
        }

        // Truyền dữ liệu ngược lại cho HTML hiển thị
        model.addAttribute("num1", a);
        model.addAttribute("num2", b);
        model.addAttribute("operator", op);
        model.addAttribute("result", errorMessage == null ? result : null);
        model.addAttribute("error", errorMessage);

        return "index";
    }
}