
public class GuideDto {

	// id,종목명,순번,가이드
	public String id;
	public String list;
	public String SEQ;
	public String Guid;
	
	public GuideDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GuideDto(String id, String list, String sEQ, String guid) {
		super();
		this.id = id;
		this.list = list;
		SEQ = sEQ;
		Guid = guid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	public String getGuid() {
		return Guid;
	}
	public void setGuid(String guid) {
		Guid = guid;
	}
	@Override
	public String toString() {
		return "GuideDto [id=" + id + ", list=" + list + ", SEQ=" + SEQ + ", Guid=" + Guid + "]";
	}
	
	
}
