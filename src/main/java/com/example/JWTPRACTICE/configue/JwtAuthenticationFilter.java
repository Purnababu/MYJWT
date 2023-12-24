package com.example.JWTPRACTICE.configue;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.JWTPRACTICE.excptions.JwtExpiredException;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private CustomeUserSecrviceImple customeUserSecrviceImple;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requesttokenheader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;

		if (requesttokenheader != null && requesttokenheader.startsWith("Bearer ")) {
			jwtToken = requesttokenheader.substring(7);
 
			try { 
				username = this.jwtUtil.extractUsername(jwtToken);

			} catch (ExpiredJwtException e) {
				throw new JwtExpiredException("token has expired");
			} catch (Exception e) {
				throw new RuntimeException("some thing went wrong", e);
			}
		} else {
			System.out.println("invalid token , not strted with bearer");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.customeUserSecrviceImple.loadUserByUsername(username);
			if (this.jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println("token is not vlaid");
			}
		}

		filterChain.doFilter(request, response);

	}

}
