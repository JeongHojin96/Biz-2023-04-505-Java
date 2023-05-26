package com.callor.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.student.mapper.sql.StudentSQL;
import com.callor.student.models.StudentDto;


/*
 * Dao(Data Access Object),
 * = Mapper(SQL 문과 DTO 를 자동으로 매칭시킨다)
 * 
 * DB와 연결하여 CRUD를 처리하는 객체
 * 
 * MyVatis 를 사용하게 되면 Dao interface를 생성하고
 * 각 method 에 Annotaion 을 부착하면 SQL명령문을 설정한다
 * 
 * 그러면 나머지 여러가지 코드
 * 	DBMS 에서 데이터를 가져와서 DTO에 담고, 다시 List add 하여
 * 	Return 하는 이러한 코드를 MyBatis 의 SqlSessionFactiory가 대신
 *	 생성해준다
 */
public interface StudentDao {

	@Select(" SELECT * FROM tbl_student ")
	public List<StudentDto> selectAll();
	
	@Select(" SELECT * FROM tbl_student WHERE st_num = #{id} ")
	public StudentDto findById(String Id);
	
	@Delete(" DELETE * FROM tbl_student WHERE st_num = #{id} ")
	public int delete(String id);
	
	@Insert(StudentSQL.STUDENT_INSERT)
	public int insert(StudentDto dto);
	
	@Update(StudentSQL.STUDENT_UPDATE)
	public int update(StudentDto dto);
}
