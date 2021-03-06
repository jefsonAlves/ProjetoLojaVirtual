package negocio;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class RedirecionamentoPaginaPadrao  implements AuthenticationSuccessHandler{

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if(roles.contains("ROLE_ADMINISTRADOR")) {
			response.sendRedirect("/ProjMinhaLoja/admin/index.xhtml");
		}else if(roles.contains("ROLE_CLIENTE")) {
			response.sendRedirect("/ProjMinhaLoja/cliente/index.xhtml");
		}
	}


}
