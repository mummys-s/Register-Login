package cn.zunsight.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zunsight.domain.Person;
import cn.zunsight.service.PersonService;

public class ListPersonServlet extends HttpServlet {
	private PersonService service = new PersonService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//调用service的findAll方法
		List<Person> list = service.findAll();
		//保存到request中
		request.setAttribute("personlist", list);
		//转发到ListPerson.jsp中
		request.getRequestDispatcher("/ListPerson.jsp").forward(request, response);

	}



}