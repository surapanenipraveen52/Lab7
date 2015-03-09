package org.mn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mn extends HttpServlet {
	public void  doGet(HttpServletRequest req, HttpServletResponse resp)    throws IOException, ServletException{
		doPost(req, resp);
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String paragraph=(String) req.getParameter("data");
		List<String> chunks=new Chunks().getChunks(paragraph);
		String op="";
		for(String s : chunks){
			op=op+"<br>"+s;
		}
		req.setAttribute("op",op);
		req.getRequestDispatcher("home.jsp").forward(req, resp); 
		System.out.println(op);
		//System.out.println(new RelatedWords().getRealtedWords("work"));
	}

}
