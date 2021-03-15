package server;

public class Others implements servlets {
    @Override
    public void service(Request request, Response response) {
        response.println("<html>");
        response.println("<head>");
        response.println("<title>");
        response.println("服务器响应成功");
        response.println("</title>");
        response.println("</head>");
        response.println("<body>");
        response.println("我回来了"+"中不中？");
        response.println("</body>");
        response.println("</html>");
    }
}
