package br.com.myTasks.models.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.myTasks.exceptions.UserExistenceExcepion;
import br.com.myTasks.interfaces.IEncrypt;
import br.com.myTasks.interfaces.ILoginRepository;
import br.com.myTasks.interfaces.ILoginService;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class LoginService implements ILoginService {

	private IEncrypt encrypt;
	private ILoginRepository loginRepository;

	@Deprecated
	public LoginService() {
		this(null, null);
	}

	@Inject
	public LoginService(IEncrypt encrypt, ILoginRepository loginRepository) {
		this.encrypt = encrypt;
		this.loginRepository = loginRepository;
	}

	@Override
	public User login(User user) throws UserExistenceExcepion {
		User dbUser = null;
		user.setPassword(encrypt.encryptPassword(user.getPassword()));
		dbUser = loginRepository.getUser(user);

		if (dbUser == null) {
			throw new UserExistenceExcepion("Usuário não encontrado, verifique seu email e senha");
		}

		return dbUser;
	}

}
