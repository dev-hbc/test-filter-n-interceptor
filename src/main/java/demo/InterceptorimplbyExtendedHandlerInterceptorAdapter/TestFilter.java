package demo.InterceptorimplbyExtendedHandlerInterceptorAdapter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter requests by validating the authorization from the request header.
 */
public class TestFilter implements Filter {
    private final static String USER_ROLE_HEADER = "UserRole";
    private final static String USER_ROLE_FIELD_TYLE = "Type=";

    /**
     * Validates if the http header contains valid user role argument
     */
    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("TestFilter Executed by XmlBeanConfig");

        final String userRoleType = extractUserRoleTypeFromRequest(request);
        if (userRoleType == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setHeader("ECHO", "YOUR USER TYPE IS NULL");
            filterChain.doFilter(request, response);
        }
        else if (userRoleType.equals(Constants.UserRoles.user)) {
            response.setHeader("ECHO", "YOUR USER TYPE IS USER");
            filterChain.doFilter(request, response);
        } else if (userRoleType.equals(Constants.UserRoles.admin)) {
            response.setHeader("ECHO", "YOUR USER TYPE IS ADMIN");
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            filterChain.doFilter(request, response);
        }
    }

    /**
     * Extracts token from request.
     *
     * @param request httpRequest
     * @return UserRoleType if success, null if failed to extract
     */
    public static String extractUserRoleTypeFromRequest(final HttpServletRequest request) {
        final String userRoleHeader = request.getHeader(USER_ROLE_HEADER);
        if (StringUtils.isNotEmpty(userRoleHeader) && userRoleHeader.startsWith(USER_ROLE_FIELD_TYLE)) {
            return userRoleHeader.substring(USER_ROLE_FIELD_TYLE.length());
        }
        return null;
    }
}