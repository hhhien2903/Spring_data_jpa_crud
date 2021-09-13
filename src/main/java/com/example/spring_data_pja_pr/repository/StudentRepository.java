package com.example.spring_data_pja_pr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_data_pja_pr.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value = "SELECT * FROM tbl_student S", nativeQuery = true)
	public List<Student> findAllByNative();

	@Query(value = "SELECT S FROM Student S")
	public List<Student> findAllByJPQL();

	@Modifying
	@Query(value = "DELETE FROM tbl_student S WHERE S.id = ?1", nativeQuery = true)
	@Transactional
	public Integer deleteByNative(Long studentId);

	@Modifying
	@Query(value = "DELETE FROM Student S WHERE S.id = ?1")
	@Transactional
	public Integer deleteByJPQL(Long studentId);

	@Modifying
	@Query(value = "UPDATE tbl_student S SET S.first_name = :firstName, S.last_name = :lastName, S.email = :email WHERE S.id = :studentId", nativeQuery = true)
	@Transactional
	public Integer updateByNative(@Param("studentId") Long studentId,
			@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("email") String email);

	@Modifying
	@Query(value = "UPDATE Student S SET S.firstName = :firstName, S.lastName = :lastName, S.email = :email WHERE S.id = :studentId")
	@Transactional
	public Integer updateByJPQL(@Param("studentId") Long studentId,
			@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("email") String email);
}
