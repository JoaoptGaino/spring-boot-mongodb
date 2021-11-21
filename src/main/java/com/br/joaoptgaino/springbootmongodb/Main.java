package com.br.joaoptgaino.springbootmongodb;

import com.br.joaoptgaino.springbootmongodb.students.Address;
import com.br.joaoptgaino.springbootmongodb.students.Gender;
import com.br.joaoptgaino.springbootmongodb.students.Student;
import com.br.joaoptgaino.springbootmongodb.students.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new Address("Brazil", "Chavantes", "18970266");
            Student student = new Student(
                    "João",
                    "Gaino",
                    "joaoptgaino@hotmail.com",
                    Gender.MALE,
                    address,
                    List.of("Computer Science","Physics"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );
            repository.insert(student);
        };
    }
}
