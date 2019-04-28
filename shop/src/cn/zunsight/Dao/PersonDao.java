package cn.zunsight.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.JdbcUtils;
import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.servlet.BaseServlet;
import cn.zunsight.domain.PageBean;
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
	public PageBean<Person> findAll(int pc,int ps){
		try {
			//设置pagebean对象pd
			PageBean<Person> pd = new PageBean<Person>();
			//设置当前页码pc和每页记录数ps
			pd.setPc(pc);
			pd.setPs(ps);
			//得到总记录数
			String sql = "select count(*) from person";
			Number num = (Number) qr.query(sql, new ScalarHandler());
			int tr = num.intValue();
			pd.setTr(tr);
			//得到beanlist
			sql = "select * from person order by pname limit ?,?";
			List<Person> beanList = qr.query(sql, 
					new BeanListHandler<Person>(Person.class),(pc-1)*ps,ps);
			pd.setBeanList(beanList);
			return pd;
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
