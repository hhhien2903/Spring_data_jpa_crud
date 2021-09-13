package com.example.spring_data_pja_pr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring_data_pja_pr.entity.Student;
import com.example.spring_data_pja_pr.repository.StudentRepository;

@SpringBootApplication
public class SpringDataPjaPrApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	private Student initialStudent = Student.builder().firstName("Hien").lastName("Hoang")
			.email("test@test.com").build();

	public static void main(String[] args) {
		SpringApplication.run(SpringDataPjaPrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method
		// stub
		Student studentResult = add(initialStudent);
		System.out.println("Added new student: " + studentResult);

		findAllByNative();
		findAllByJPQL();
		// deleteByJPA(studentResult);
		// deleteByNative(studentResult.getId());
		// deleteByJPQL(studentResult.getId());

		// Student modifiedStudent = studentResult;
		// modifiedStudent.setLastName("Mr");
		// modifiedStudent.setFirstName("BiN");
		// modifiedStudent.email("mr@bin.com);

		// updateByJPA(modifiedStudent);
		// updateByNative(modifiedStudent);
		// updateByJPQL(modifiedStudent);
	}

	private Student add(Student student) {
		return studentRepository.save(student);
	}

	private void findAllByNative() {
		List<Student> list = this.studentRepository.findAllByNative();
		for (Student student : list) {
			System.out.println("Find All By Native: " + student.toString());
		}
	}

	private void findAllByJPQL() {
		List<Student> list = this.studentRepository.findAllByJPQL();
		for (Student student : list) {
			System.out.println("Find All By JPQL: " + student.toString());
		}
	}

	private void deleteByJPA(Student student) {
		studentRepository.delete(student);
	}

	private void deleteByNative(Long studentId) {
		System.out.println("Deleted By Native"
				+ studentRepository.deleteByNative(studentId) + " rows");
	}

	private void deleteByJPQL(Long studentId) {
		System.out.println(
				"Deleted By JPQL " + studentRepository.deleteByJPQL(studentId) + " rows");
	}

	private void updateByJPA(Student student) {
		System.out.println("Updated student: " + studentRepository.save(student));
	}

	private void updateByJPQL(Student student) {
		System.out.println("Updated By JPQL "
				+ studentRepository.updateByJPQL(student.getId(), student.getFirstName(),
						student.getLastName(), student.getEmail())
				+ " rows");
	}

	private void updateByNative(Student student) {
		System.out.println("Updated By Native "
				+ studentRepository.updateByJPQL(student.getId(), student.getFirstName(),
						student.getLastName(), student.getEmail())
				+ " rows");
	}
}
