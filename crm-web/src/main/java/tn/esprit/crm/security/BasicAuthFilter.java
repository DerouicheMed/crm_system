package tn.esprit.crm.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

/**
 * This filter will activate each time a request is made to the server it will
 * check the http request header for an authorization token it will then proceed
 * to verify the token if the token is not valid http error messages will be
 * sent in the response header
 * 
 * @author Derouiche
 *
 */
@Provider
//@PreMatching
public class BasicAuthFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Inject
	private HttpServletRequest request;

	@Inject
	private AuthenticationService authService;

	/**
	 * This will override the filter method in ContainerRequestFilter interface
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println(request.getRequestURI());
		String uri = request.getRequestURI();
		// For the verification we skip /authenticate and /register
		if (!(uri.equals("/crm-web/rest/user/authenticate") || uri.equals("/crm-web/rest/user/register"))) {
			// Get authorization token for request header
			String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
			// If token is null throw exception and send null token message back
			if (authHeader == null)
				throw new NotAuthorizedException("null_token");
			// If token not null decode using base64
			String token = parseToken(authHeader);
			// if token is not verified throw exception send back invalid token message
			if (verifyToken(token) == false) {
				throw new NotAuthorizedException("invalid_token");
			}
			Method method = resourceInfo.getResourceMethod();
			if (!method.isAnnotationPresent(PermitAll.class)) {
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				List<String> roleList = new ArrayList<String>();
				if (rolesAnnotation != null) {
					roleList = Arrays.asList(rolesAnnotation.value());
				}
				String role = authService.getAuthenticated().getRole().getRoleName();
				if (!roleList.contains(role)) {
					throw new NotAuthorizedException("role_not_authorized");
				}
			}
		}
	}

	/**
	 * This method will decode the encoded token using base64
	 * 
	 * @param encodedBytes
	 * @return
	 */
	private String parseToken(String encodedBytes) {
		return new String(Base64.getDecoder().decode(encodedBytes));

	}

	/**
	 * This method will verify if the token is valid. If so it will create a session
	 * object
	 * 
	 * @param token
	 * @return
	 */
	private boolean verifyToken(String token) {
		String[] attributes = token.split(":");
		String username = attributes[0];
		String passwd = attributes[1];
		System.out.println(username + " " + passwd);
		if (authService.authenticate(username, passwd) != null)
			return true;
		else
			return false;
	}

}
