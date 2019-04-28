package cn.zunsight.test;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;
import cn.zunsight.Dao.PersonDao;
import cn.zunsight.domain.Person;

public class TestDao {
	private PersonDao  dao = new PersonDao();
	
	@Test
	public void add() throws SQLException {
		for(int i=0;i<100;i++) {
			Person p = new Person();
			p.setPid(UUID.randomUUID().toString());
			p.setPname("person_" + i);
			p.setPpassword("123" + i + "45");
			if(i>10) {
				p.setPtel("136" + i + "456" + i + "123");
			}else {
				p.setPtel("136" + i + "46" + i + "123");
			}
			dao.add(p);
		}
	}
	
	

}
