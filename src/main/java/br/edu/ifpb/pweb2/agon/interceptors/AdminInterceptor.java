package br.edu.ifpb.pweb2.agon.interceptors;

import br.edu.ifpb.pweb2.agon.models.Player;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        boolean logged = session != null  && session.getAttribute("player") != null;

        if (!logged){
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

        Player player = (Player) session.getAttribute("player");

        if (!player.getAdmin()) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

        return true;
    }
}
