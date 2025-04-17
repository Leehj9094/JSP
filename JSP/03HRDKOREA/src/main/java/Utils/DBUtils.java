
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 싱글톤
	private static DBUtils instance;

	private DBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);
	}

	public static DBUtils getInstance() throws Exception {
		if (instance == null)
			instance = new DBUtils();
		return instance;
	}

	// 강사테이블조회
	public List<TeacherDto> selectAllTeacher() throws Exception{
		String sql = "select * from TBL_TEACHER_202201";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		List<TeacherDto> list = new ArrayList();
		TeacherDto dto = null;
		if(rs!=null) {
			while(rs.next()) {
				// code 추가
				dto = new TeacherDto();
				dto.setTeacher_code(rs.getString(1));
				dto.setTeacher_name(rs.getString(2));
				dto.setClass_name(rs.getString(3));
				dto.setClass_price(rs.getInt(4));
				dto.setTeacher_regist_date(rs.getString(5));
				list.add(dto);
			}
		}
		pstmt.close();
		rs.close();
		return list;
	}

	// 회원정보조회
		public List<MemberDto> selectAllMember() throws Exception{
			String sql = "select * from TBL_MEMBER_202201";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			List<MemberDto> member_list = new ArrayList();
			MemberDto dto = null;
			if(rs!=null) {
				while(rs.next()) {
					// code 추가
					dto = new MemberDto();
					dto.setC_no(rs.getString(1));
					dto.setC_name(rs.getString(2));
					dto.setPhone(rs.getString(3));
					dto.setAddress(rs.getString(4));
					dto.setGrade(rs.getString(5));
					member_list.add(dto);
				}
			}
			pstmt.close();
			rs.close();
			return member_list;
		}
		
		// 수강정보
		public List<ClassDto> selectAllClass() throws Exception{
			String sql = "select * from TBL_CLASS_202201";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			List<ClassDto> class_list = new ArrayList();
			ClassDto dto = null;
			if(rs!=null) {
				while(rs.next()) {
					dto = new ClassDto();
					dto.setRegist_month(rs.getString(1));
					dto.setC_no(rs.getString(2));
					dto.setClass_area(rs.getString(3));
					dto.setTuition(rs.getString(4));
					dto.setTeacher_code(rs.getString(5));
					class_list.add(dto);
				}
			}
			pstmt.close();
			rs.close();
			return class_list;
		}
		
		public int insertClass(ClassDto classDto) throws Exception{
			
			pstmt = conn.prepareStatement("insert into TBL_CLASS_202201 values(?,?,?,?,?)");
			pstmt.setString(1, classDto.getRegist_month());
			pstmt.setString(2, classDto.getC_no());
			pstmt.setString(3, classDto.getClass_area());
			pstmt.setString(4, classDto.getTuition());
			pstmt.setString(5, classDto.getTeacher_code());
			
			int result = pstmt.executeUpdate();
			
			conn.commit();
			pstmt.close();
			return result;
			
		}
		
		// SELECT C.REGIST_MONTH,M.C_NO,M.C_NAME,T.CLASS_NAME,C.CLASS_AREA,C.TUITION,M.GRADE
		// FROM TBL_MEMBER_202201 M
		// JOIN TBL_CLASS_202201 C
		// ON C.C_NO=M.C_NO
		// JOIN tbl_teacher_202201 T
		// ON C.TEACHER_CODE=T.TEACHER_CODE; 
		
		public List<Join1Dto> selectAllJoin1() throws Exception{
			String sql = "SELECT C.REGIST_MONTH,M.C_NO,M.C_NAME,T.CLASS_NAME,C.CLASS_AREA,C.TUITION,M.GRADE"
					+ " FROM TBL_MEMBER_202201 M"
					+ " JOIN TBL_CLASS_202201 C"
					+ " ON C.C_NO=M.C_NO"
					+ " JOIN TBL_TEACHER_202201 T"
					+ " ON C.TEACHER_CODE=T.TEACHER_CODE"
					;
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			List<Join1Dto> join_list = new ArrayList();
			Join1Dto dto = null;
			if(rs!=null) {
				while(rs.next()) {
					dto = new Join1Dto();
					dto.setRegist_month(rs.getString(1));
					dto.setC_no(rs.getString(2));
					dto.setC_name(rs.getString(3));
					dto.setClass_name(rs.getString(4));
					dto.setClass_area(rs.getString(5));
					dto.setTuition(rs.getString(6));
					dto.setGrade(rs.getString(7));
					join_list.add(dto);
				}
			}
			pstmt.close();
			rs.close();
			return join_list;
	
		}
		
		// SELECT T.TEACHER_CODE,T.CLASS_NAME,T.TEACHER_NAME,SUM(C.TUITION)
		// FROM TBL_CLASS_202201 C
		// JOIN TBL_TEACHER_202201 T
		// ON C.TEACHER_CODE = T.TEACHER_CODE
		// GROUP BY T.TEACHER_CODE,T.CLASS_NAME,T.TEACHER_NAME
		// ORDER BY SUM(C.TUITION) desc;
		
		public List<Join2Dto> selectAllJoin2() throws Exception{
			String sql = "SELECT T.TEACHER_CODE,T.CLASS_NAME,T.TEACHER_NAME,SUM(C.TUITION)"
					+ " FROM TBL_CLASS_202201 C"
					+ " JOIN TBL_TEACHER_202201 T"
					+ " ON C.TEACHER_CODE = T.TEACHER_CODE"
					+ " GROUP BY T.TEACHER_CODE,T.CLASS_NAME,T.TEACHER_NAME"
					+ " ORDER BY SUM(C.TUITION) desc"
					;
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			List<Join2Dto> join_list = new ArrayList();
			Join2Dto dto = null;
			if(rs!=null) {
				while(rs.next()) {
					dto = new Join2Dto();
					dto.setTeacher_code(rs.getString(1));
					dto.setClass_name(rs.getString(2));
					dto.setTeacher_name(rs.getString(3));
					dto.setTotal_tuition(rs.getString(4));
					join_list.add(dto);
				}
			}
			pstmt.close();
			rs.close();
			return join_list;
	
		}
		
}
