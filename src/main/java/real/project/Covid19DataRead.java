package real.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Covid19DataRead.do")
public class Covid19DataRead extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String dataPortal = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson";
		dataPortal += "?serviceKey=aPmizO0HolL8uomWwhaTuW5QleF%2BiSKuZvc%2F3m0DRmRcDCOVf%2BY2jrQTiwwbVMbfRUEzFvj2XmSKHZhB9ltmfA%3D%3D";
		dataPortal += "&pageNo=1";
		dataPortal += "&numOfRows=10";
		dataPortal += "&startCreateDt="+req.getParameter("startCreateDt");
		dataPortal += "&endCreateDt="+req.getParameter("endCreateDt");
		
		String s = crawling01(dataPortal);
		System.out.println(s);
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.println(s);
		writer.close();
	}
	public String crawling01(String addr) {
		URL url;
		StringBuffer sourceCode = new StringBuffer();
		try {
			url = new URL(addr);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String sourceLine = "";
			while((sourceLine=br.readLine()) != null) {
				sourceCode.append(sourceLine+"\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sourceCode.toString();
	}
	
	
}
