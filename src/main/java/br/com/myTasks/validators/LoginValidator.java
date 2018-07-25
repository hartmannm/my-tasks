package br.com.myTasks.validators;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.myTasks.interfaces.ILoginValidator;
import br.com.myTasks.models.entityes.User;

public class LoginValidator implements ILoginValidator {

	private Validator validator;

	@Deprecated
	public LoginValidator() {
		this(null);
	}

	@Inject
	public LoginValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void validate(User user) {
		validator.validate(user);

		// email
		if (user.getEmail() == null || !user.getEmail().matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			validator.add(new I18nMessage("user.email", "email.message"));
		}
		// password
		if (user.getPassword() == null || user.getPassword().length() < 5 || user.getPassword().length() > 50) {
			validator.add(new I18nMessage("user.password", "password.message"));
		}
	}

	@Override
	public <T> T onErrorRedirectTo(T controller) {
		return validator.onErrorRedirectTo(controller);
	}

}
