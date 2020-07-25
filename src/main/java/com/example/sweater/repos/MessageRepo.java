package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository; // чтобы получить полный список полей
                                                            // или найти определенный по идентификатору
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag); // назван по правилам Spring JPA: find - ключевое слово искать
    // by - по какому полю
    // tag - по имени поля тэг
}
