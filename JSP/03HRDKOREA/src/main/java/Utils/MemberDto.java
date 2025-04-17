package Utils;

public class MemberDto {

	private String c_no;
	private String c_name;
	private String phone;
	private String address;
	private String grade;
	
	// 모든 인자
	public MemberDto() {}
	public MemberDto(String c_no, String c_name, String phone, String address, String grade) {
		super();
		this.c_no = c_no;
		this.c_name = c_name;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
	}
	// getter und setter
	public String getC_no() {
		return c_no;
	}
	public void setC_no(String c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	// toString
	@Override
	public String toString() {
		return "MemberDto [C_no=" + c_no + ", C_name=" + c_name + ", phone=" + phone + ", address=" + address
				+ ", grade=" + grade + "]";
	}
	
	
}
