package br.com.myTasks.models.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.myTasks.exceptions.EncryptionException;
import br.com.myTasks.exceptions.UserExistenceExcepion;
import br.com.myTasks.interfaces.IEncrypt;
import br.com.myTasks.interfaces.ILoginRepository;
import br.com.myTasks.interfaces.ILoginService;
import br.com.myTasks.models.entityes.LoggedUser;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class LoginService implements ILoginService {

	private IEncrypt encrypt;
	private ILoginRepository loginRepository;
	private LoggedUser loggedUser;
	
	@Deprecated
	public LoginService() {
		this(null, null, null);
	}

	@Inject
	public LoginService(IEncrypt encrypt, ILoginRepository loginRepository, LoggedUser loggeduser) {
		this.encrypt = encrypt;
		this.loginRepository = loginRepository;
		this.loggedUser = loggeduser;
	}

	@Override
	public User login(User user) throws EncryptionException, UserExistenceExcepion {
		User dbUser = null;
		try {
			user.setPassword(encrypt.encryptPassword(user.getPassword()));
			dbUser = loginRepository.getUser(user);
			loggedUser.setUser(dbUser);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new EncryptionException("Erro interno no sistema, desculpe pelo transtorno");
		}catch (NoResultException e) {
			throw new UserExistenceExcepion("Usuário não encontrado. Verifique seu email e senha");
		}
		
		return dbUser;
	}

}
