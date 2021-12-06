package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter{
    private final String id;

    public ApplicationIdentifierFilter() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        ((HttpServletResponse)servletResponse).setHeader("Instance-Id", id);
    }
}
