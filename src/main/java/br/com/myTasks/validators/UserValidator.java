package br.com.myTasks.validators;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.myTasks.interfaces.IUserValidator;
import br.com.myTasks.models.entityes.User;

public class UserValidator implements IUserValidator{

	private Validator validator;

	public UserValidator() {
		this(null);
	}

	@Inject
	public UserValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void validate(User user) {
		validator.validate(user);
		// nome
		if(user.getName() == null || user.getName().length() < 5 || user.getName().length() > 50) {
			validator.add(new I18nMessage("user.name", "name.message"));
		}
		// email
		if(user.getEmail() == null || !user.getEmail().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
												+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			validator.add(new I18nMessage("user.email", "email.message"));
		}
		//password
		if(user.getPassword() == null || user.getPassword().length() < 5 || user.getPassword().length() > 50) {
			validator.add(new I18nMessage("user.password", "password.message"));
		}
		//confirmPassword
		if((user.getPassword() != null && !user.getPassword().equals(user.getPasswordConfirm()) 
				|| user.getPasswordConfirm() == null)) {
			validator.add(new I18nMessage("user.passwordConfirm", "password.dont.match"));
		}
	}

	@Override
	public <T> T onErrorRedirectTo(T controller) {
		return validator.onErrorRedirectTo(controller);
	}

}