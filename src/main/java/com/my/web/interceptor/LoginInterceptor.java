package com.my.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.my.web.domain.LoginDTO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = null;
		session = request.getSession();
		// MemberVO vo = (MemberVO) session.getAttribute("login");
		
		// session 정보가 없을 경우 로그인 페이지로 이동
		if(session.getAttribute("login") == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
			return false;
		}
		return true;
	}
	
	/*@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}*/
	
}
