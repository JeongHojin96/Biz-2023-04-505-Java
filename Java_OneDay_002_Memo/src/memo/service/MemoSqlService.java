package memo.service;

import java.util.List;

import memo.models.MemoDto;

public interface MemoSqlService {

	public List<MemoDto> selectAll();

	public MemoDto findBySeq(String m_seq);

	public MemoDto findByWriter(String m_writer);

	public MemoDto findBydate(String m_date);

	public int insert(MemoDto dto);

	public int update(MemoDto dto);

	public int delete(String m_seq);

}
