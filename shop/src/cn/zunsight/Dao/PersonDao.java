package cn.zunsight.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
	
	//查找全部
	public List<Person> findAll(){
		try {
			String sql = "select * from person";
			return qr.query(sql, new BeanListHandler<Person>(Person.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//加载用户
	public Person findById(String pid) {
		try {
			String sql = "select * from person where pid=?";
			return qr.query(sql, new BeanHandler<Person>(Person.class),pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//修改用户信息
	public void edit(Person p){
		try {
			String sql = "update person set pname=?,ptel=?,ppassword=? where pid=?";
			Object[] params = {p.getPname(),p.getPtel(),p.getPpassword(),p.getPid()};
			qr.update(sql,params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//删除用户
	public void delete(String pid) {
		try {
			System.out.println("dao:"+pid);
			String sql  = "delete from person where pid=?";//'"+xxx+"'
			Object[] param = {pid};
			qr.update(sql,pid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	 

}
