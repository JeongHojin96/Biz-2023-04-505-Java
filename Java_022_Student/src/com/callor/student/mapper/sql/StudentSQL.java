package com.callor.student.mapper.sql;

public class StudentSQL {
	// myBatis 는 final 키워드가 있어야함
	public static final String STUDENT_INSERT
	= " INSERT INTO tbl_student( "
			+ " st_num, st_name, st_dept, st_grade, st_tel) "
			+ " VALUES( "
			+ " #{st_num}, #{st_name}, "
			+ " #{st_dept}, #{st_grade}, #{st_tel} ) ";
	
	public static final String STUDENT_UPDATE
	= " UPDATE tbl_student "
			+ " SET st_name = #{st_name} "
			+ " SET st_dept = #{st_dept} "
			+ " SET st_grade = #{st_grade} "
			+ " SET st_tel = #{st_tel} "
			+ " SET st_num = #{st_num} "
			+ " WHERE st_name = '홍길동' ";
}
