package cn.zunsight.domain;

public class Person {
	private String pid;
	private String pname;
	private String ppassword;
	private String ptel;
	
	public Person() {
		
	}

	public Person(String pid, String pname, String ppassword, String ptel) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ppassword = ppassword;
		this.ptel = ptel;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPpassword() {
		return ppassword;
	}

	public void setPpassword(String ppassword) {
		this.ppassword = ppassword;
	}

	public String getPtel() {
		return ptel;
	}

	public void setPtel(String ptel) {
		this.ptel = ptel;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", ppassword=" + ppassword + ", ptel=" + ptel + "]";
	}

}
