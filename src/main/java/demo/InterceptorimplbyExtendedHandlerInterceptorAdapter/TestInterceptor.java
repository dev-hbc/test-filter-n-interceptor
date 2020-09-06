package demo.InterceptorimplbyExtendedHandlerInterceptorAdapter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {

    final static String USER_TOKEN_HEADER = "USER_TOKEN";

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        final String token = extractUserTokenFromRequest(request); //可以是NULL
        if(request.getRequestURL().toString().endsWith("/login")){
            return true;
        }
        if(StringUtils.isEmpty(token) || !token.equals("ZHIMAKAIMEN")){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    public static String extractUserTokenFromRequest(final HttpServletRequest request) {
        final String userRoleHeader = request.getHeader(USER_TOKEN_HEADER);
        return userRoleHeader;
    }
}
