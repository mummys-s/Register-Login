package cn.zunsight.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zunsight.domain.PageBean;
import cn.zunsight.domain.Person;
import cn.zunsight.service.PersonService;

public class ListPersonServlet extends HttpServlet {
	private PersonService service = new PersonService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*//调用service的findAll方法
		List<Person> list = service.findAll();
		//保存到request中
		request.setAttribute("personlist", list);
		//转发到ListPerson.jsp中
		request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);*/
		
		//获取页面的pc
		int pc = getPc(request);
		//设置ps
		int ps = 10;
		//调用service方法
		PageBean<Person> pd = service.findAll(pc, ps);
		//保存到request中
		request.setAttribute("pd", pd);
		//转发到list
		request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);
		
		

	}
	//获取pc
	public int getPc(HttpServletRequest request) {
		//获取pc
		//	如果pc不存在，则pc为1
		//	如果pc存在，则转化为对应的int类型
		String pc = request.getParameter("pc");
		if(pc == null || pc.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(pc);
	}



}