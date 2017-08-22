import java.io.IOException;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ai.api.AIServiceException;
import ai.api.model.AIResponse;
import ai.api.web.AIServiceServlet;

/*@WebServlet(urlPatterns = {"/ai"},
    initParams = {
        @WebInitParam(name = MyServiceServlet.PARAM_API_AI_KEY,
        value = "36e0d78753284c17ada1711f2dc6fc25")
    })*/
public class MyServiceServlet extends AIServiceServlet {
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    try {
      AIResponse aiResponse = request(request.getParameter("query"), request.getSession());
      response.setContentType("text/plain");
      response.getWriter().append(aiResponse.getResult().getFulfillment().getSpeech());
    } catch (AIServiceException e) {
      e.printStackTrace();
    }
  }
}