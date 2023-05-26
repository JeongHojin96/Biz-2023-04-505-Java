package memo.config;

public class DBContract {
	public static final String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER_NAME = "C##myuser";
	public static final String PASSWORD = "12341234";

	public static class MEMO {
		public static final int M_SEQ = 1;
		public static final int M_WRITER = 2;
		public static final int M_DATA = 3;
		public static final int M_SUBJECT = 4;
		public static final int M_CONTENT = 5;

	}

}
