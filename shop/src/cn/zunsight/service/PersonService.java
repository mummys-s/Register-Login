package cn.zunsight.service;

/*
 * 	业务层
 */

import java.sql.SQLException;
import java.util.List;

import cn.zunsight.Dao.PersonDao;
import cn.zunsight.domain.Person;

public class PersonService {
	private PersonDao dao = new PersonDao();

	//注册功能
	public void register(Person form) throws PersonException {
		Person person = dao.login(form.getPname(), form.getPpassword());
		if(person != null) throw new PersonException("用户名已被注册!");
		
		dao.add(form);
	}
	
	//登录功能
	public Person login(Person form) throws PersonException {
		Person person = dao.login(form.getPname(), form.getPpassword());
		if(person == null) throw new PersonException("用户名或密码错误！");
		
		return person;
	}
	
}
