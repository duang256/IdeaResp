package server;

public class RegisterServlet implements servlets{

    @Override
    public void service(Request request,Response response) {
        response.println("<html>");
        response.println("<head>");
        response.println("<title>");
        response.println("服务器响应成功");
        response.println("</title>");
        response.println("</head>");
        response.println("<body>");
        response.println("颜太太终于回来了"+request.getParameterValue("fav")+request.getParameterValue("uname"));
        response.println("</body>");
        response.println("</html>");
    }
}
