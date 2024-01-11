package com.imran.student.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imran.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	Student findByStudentid(int id);
	
	@Modifying
	@Transactional
	@Query(value="delete from student where studentid=:studentid", nativeQuery=true)
	public int deleteStudentid(@Param("studentid") int id);
	
	@Modifying
	@Transactional
	@Query(value="update student set student_name=:studentname,grade=:grade where studentid=:studentid", nativeQuery=true)
	public int updateStudentid(@Param("studentname") String studentname,@Param("grade") int grade,@Param("studentid") int id);
  

	@Query(value="select * from student where grade=(select max(grade) from student)", nativeQuery=true)
	public Student getMaxGrade();
	
	@Query(value="select avg(grade) from student ", nativeQuery=true)
	public Double getAvgGrade();
    
}
