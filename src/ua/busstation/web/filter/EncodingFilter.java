package ua.busstation.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Encoding filter.
 * 
 * @author O.Soklakov
 * 
 */
public class EncodingFilter implements Filter {

	private static final Logger log = Logger.getLogger(EncodingFilter.class);

	private String encoding;

	public void destroy() {
		log.debug("Filter destruction starts");
		// do nothing
		log.debug("Filter destruction finished");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		log.debug("Filter starts");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		log.trace("Request uri --> " + httpRequest.getRequestURI());
		
		String requestEncoding = request.getCharacterEncoding();
		if (requestEncoding == null) {
			log.trace("Request encoding = null, set encoding --> " + encoding);
			request.setCharacterEncoding(encoding);
		}
		
		log.debug("Filter finished");		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log.debug("Filter initialization starts");
		encoding = fConfig.getInitParameter("encoding");
		log.trace("Encoding from web.xml --> " + encoding);
		log.debug("Filter initialization finished");
	}

}