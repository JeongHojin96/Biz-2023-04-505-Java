package com.callor.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.callor.bank.config.DBConnection;
import com.callor.bank.models.AccListDto;
import com.callor.bank.service.AccListService;

public class AccListServiceImplV1 implements AccListService {
	
	protected AccServiceImplV1 accService;

	protected Connection dbConn;

	public AccListServiceImplV1() {
		dbConn = DBConnection.getDBConn();
		accService = new AccServiceImplV1();
	}

	public List<AccListDto> selectAll() {
		return null;
	}

	public AccListDto findbyId(long seq) {
		return null;
	}

	public int insert(AccListDto dto) {
		String sql = "INSERT INTO tbl_accList ( "
				+ " aioSEQ, acNum, aioDate, aioTIme, aioDiv, aioInput, aioOutput) "
				+ " VALUES "
				+ " ( "
				+ " seq_accList.NEXTVAL, "
				+ " ?, " // 계좌번호
				+ " ?, " // 거래일자
				+ " ?, " // 거래시각
				+ " ?, " // 거래구분(1:입금, 2:출금)
				+ " ?, " // 입금액
				+ " ? " // 출금액
				+ " ) ";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.acNum);
			pStr.setString(2, dto.aioDate);
			pStr.setString(3, dto.aioTIme);
			pStr.setString(4, dto.aioDiv);
			pStr.setInt(5, dto.aioInput);
			pStr.setInt(6, dto.aioOutput);
			
			// 쿼리 실행하는 method
			// SELECT : executeQuery(),
			// INSERT, UPDATE, DELETE : executeUpdate()
			return pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	
	public List<AccListDto> findByDateDestance(String sDate, String eDate) {
		return null;
	}

	public List<AccListDto> findByAcNum(String acNum) {
		return null;
	}

	public List<AccListDto> findByAcNumAndDateDest(String acNum, String sDate, String eDate) {
		return null;
	}

	public int update(AccListDto dto) {
		
		return 0;
	}

	public int delete(Long seq) {
		return 0;
	}

}
