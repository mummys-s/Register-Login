package cn.zunsight.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zunsight.domain.Person;
import cn.zunsight.service.PersonService;

public class LoadServlet extends HttpServlet {
	private PersonService service = new PersonService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取id
		String pid = request.getParameter("pid");
		//调用service的方法
		Person person = service.findById(pid);
		//保存到request中
		request.setAttribute("person", person);
		//转发到edit.jsp
		request.getRequestDispatcher("/edit.jsp").forward(request, response);

	}

}