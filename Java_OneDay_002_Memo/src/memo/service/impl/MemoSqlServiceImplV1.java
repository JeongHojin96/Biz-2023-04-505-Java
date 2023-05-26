package memo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import memo.config.DBConnection;
import memo.config.DBContract;
import memo.models.MemoDto;
import memo.service.MemoSqlService;

public class MemoSqlServiceImplV1 implements MemoSqlService {

	protected List<MemoDto> memoList;
	protected Connection dbConn;
	
	public MemoSqlServiceImplV1() {
	memoList = new ArrayList<>();
	dbConn = DBConnection.getDBConn();
	}
//	m_seq, m_writer, m_date, m_subject, m_content
	
	protected MemoDto result2Dto(ResultSet result) {
		MemoDto memoDto = new MemoDto();
		try {
			memoDto.m_seq = result.getInt(DBContract.MEMO.M_SEQ);
			memoDto.m_writer = result.getString(DBContract.MEMO.M_WRITER);
			memoDto.m_date = result.getString(DBContract.MEMO.M_DATA);
			memoDto.m_subject = result.getString(DBContract.MEMO.M_SUBJECT);
			memoDto.m_content = result.getString(DBContract.MEMO.M_CONTENT);
			return memoDto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<MemoDto> selectAll() {
		String sql = " SELECT m_seq, m_writer, m_date, m_subject, m_content "
	+ " FROM tbl_memo "
	+ " ORDER BY m_seq ";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			while (result.next()) {
				MemoDto memoDto = result2Dto(result);
				memoList.add(memoDto);
			}
			return memoList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemoDto findBySeq(String m_seq) {
		String sql = " SELECT m_seq, m_writer, m_date, m_subject, m_content "
				+ " FROM tbl_memo "
				+ " WHERE m_seq = ? "
				+ " ORDER BY m_seq ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, m_seq);

			ResultSet result = pStr.executeQuery();
			if (result.next()) return result2Dto(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemoDto findByWriter(String m_writer) {
		String sql = " SELECT m_seq, m_writer, m_date, m_subject, m_content "
				+ " FROM tbl_memo "
				+ " WHERE m_writer = ? "
				+ " ORDER BY m_writer ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, m_writer);

			ResultSet result = pStr.executeQuery();
			if (result.next()) return result2Dto(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemoDto findBydate(String m_date) {
		String sql = " SELECT m_seq, m_writer, m_date, m_subject, m_content "
				+ " FROM tbl_memo "
				+ " WHERE m_date = ? "
				+ " ORDER BY m_date ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, m_date);

			ResultSet result = pStr.executeQuery();
			if (result.next()) {
				return result2Dto(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insert(MemoDto dto) {
		String sql = " INSERT INTO tbl_Memo( "
				+ " m_seq, m_writer, m_date, m_subject, m_content) "
				+ " VALUES( "
				+ " seq_memoList.NextVAL,"
				+ "?, ?, ?, ?) ";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.m_writer);
			pStr.setString(2, dto.m_date);
			pStr.setString(3, dto.m_subject);
			pStr.setString(4, dto.m_content);
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int update(MemoDto dto) {
		String sql = " UPDATE tbl_memo "
				+ " SET "
				+ " m_writer = ?, "
				+ " m_date = ?, "
				+ " m_subject = ?, "
				+ " m_content = ? "
				+ " WHERE m_seq = ?";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setInt(5, dto.m_seq);
			pStr.setString(1, dto.m_writer);
			pStr.setString(2, dto.m_date);
			pStr.setString(3, dto.m_subject);
			pStr.setString(4, dto.m_content);
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String m_seq) {
		String sql = " DELETE FROM tbl_memo "
				+ " WHERE m_seq = ? ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, m_seq);
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
