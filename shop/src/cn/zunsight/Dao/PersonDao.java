package cn.zunsight.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.servlet.BaseServlet;
import cn.zunsight.domain.Person;

/*
 * 	数据访问层
 */
public class PersonDao {
	private QueryRunner qr = new TxQueryRunner();

	//增加用户
	public void add(Person p){
		try {
			String sql = "INSERT INTO person VALUES(?,?,?,?)";
			Object[] params = { p.getPid(), p.getPname(), p.getPpassword(), p.getPtel() };
			int row = qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//查找用户
	//根据用户名和密码查找
	public Person login(String pname,String ppassword){
		try {
			String sql = "select * from person where pname=? and ppassword=?";
			return qr.query(sql, new BeanHandler<Person>(Person.class),pname,ppassword);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	

}
