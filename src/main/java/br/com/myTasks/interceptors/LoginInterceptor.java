package br.com.myTasks.interceptors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.myTasks.annotations.NeedToBeLogged;
import br.com.myTasks.controllers.LoginController;
import br.com.myTasks.interfaces.ISession;

@AcceptsWithAnnotations(NeedToBeLogged.class)
@RequestScoped
@Intercepts(before=TransactionInterceptor.class)
public class LoginInterceptor {

	private ISession session;
	private Result result;
	
	@Deprecated
	public LoginInterceptor() {
		this(null, null);
	}
	
	@Inject
	public LoginInterceptor(ISession session, Result result) {
		this.session = session;
		this.result = result;
	}
	
	@AroundCall
	public void interceptLogin(SimpleInterceptorStack stack) {
		if(!session.isLogged()) {
			result.include("errorMessage", "Ops, parece que você não está logado. Faça login para continuar.");
			result.redirectTo(LoginController.class).login();
		} else {
			stack.next();
		}
	}
	
}
