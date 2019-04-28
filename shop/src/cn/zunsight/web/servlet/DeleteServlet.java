package cn.zunsight.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zunsight.domain.Person;
import cn.zunsight.service.PersonService;

public class DeleteServlet extends HttpServlet {
	private PersonService service = new PersonService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取id
		String pid = request.getParameter("pid");
		System.out.println("servlet:"+pid);
		//调用service方法
		service.delete(pid);
		/*response.getWriter().print("<h1>删除成功！</h1><a href='" + 
				request.getContextPath() + 
				"/list" + "'>点击这里去显示用户</a>");*/
		request.getRequestDispatcher("/list").forward(request, response);

	}



}