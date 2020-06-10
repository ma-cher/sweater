package com.example.sweater;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    /*Аннотация @GetMapping гарантирует, что HTTP-запросы GET к /greeting
    отображаются в методе greeting().*/

    @GetMapping("/greeting")
    public String greeting(@RequestParam(
            name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting"; // возвращаем имя файла спринговому контейнеру @Controller, который хотим отобразить, в данном случае - файл гритингс.html
    }

    @GetMapping
    public String main(Map<String, Object> model){
        model.put("some", "let's code!");
        return "main";
    }

}