package edu.friday.common.sec.handle;

import com.alibaba.fastjson.JSON;
import edu.friday.common.constant.HttpStatus;
import edu.friday.common.result.RestResult;
import edu.friday.utils.StringUtils;
import edu.friday.utils.http.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class AuthEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 468844L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        int code = HttpStatus.UNAUTHORIZED;
        String msg = StringUtils.format("请求访问: {} , 认证失败,无法访问系统资源", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(RestResult.error(code, msg)));
    }
}
