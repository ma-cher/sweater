package com.example.sweater;
import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo; // наш репозиторий

    /*Аннотация @GetMapping гарантирует, что HTTP-запросы GET к /greeting
    отображаются в методе greeting().*/

    @GetMapping("/greeting")
    public String greeting(@RequestParam(
            name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting"; // возвращаем имя файла спринговому контейнеру @Controller, который хотим отобразить, в данном случае - файл гритингс.html
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages); // для отображения всех сообщений на главной странице
        return "main";
    }

    @PostMapping
    /*аннотация @RequestParam выдергивает из запросов (url) параметры,
     либо из формы ввода на странице
    находит по названию параметров */

    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages); // для отображения всех сообщений на главной странице
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
       Iterable<Message> messages; // Iterable - потому, что findByTag возвращает Iterable

        if(filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);
        return "main";
    }
}