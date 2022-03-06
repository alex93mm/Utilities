package com.example.demo;

import com.example.demo.entities.Student;
import com.example.demo.models.Address;
import com.example.demo.models.Gender;
import com.example.demo.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			Address address = new Address(
					"Spain",
					"Elche",
					"03203"
			);
			Student student = new Student(
					"Alejandro",
					"Martinez",
					"alejandro93mm@gmail.com",
					Gender.MALE,
					address,
					List.of("Maths", "ComputerScience"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

//			usingMongoTemplateAndQuery(repository, mongoTemplate, student);

			repository.findStudentByEmail(student.getEmail())
					.ifPresentOrElse(studentMail -> {
						System.out.println("Student with email " + studentMail + " alredy exists");
					}, () -> {
						System.out.println("Inserting student " + student);
						repository.insert(student);
					});

		};
	}

	private void usingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(student.getEmail()));

		List<Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() > 1) {
			throw new IllegalStateException("Found many students with the same email");
		}

		if (students.isEmpty()) {
			System.out.println("Inserting student " + student);
			repository.insert(student);
		} else {
			System.out.println("Student with email " + student.getEmail() + " alredy exists");
		}
	}
}
