package br.com.myTasks.models.services;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.myTasks.exceptions.EncryptionException;
import br.com.myTasks.exceptions.UserExistenceExcepion;
import br.com.myTasks.interfaces.IEncrypt;
import br.com.myTasks.interfaces.IUserRepository;
import br.com.myTasks.interfaces.IUserService;
import br.com.myTasks.models.entityes.User;

@RequestScoped
public class UserService implements IUserService {

	private IUserRepository userRepository;
	private IEncrypt encrypt;

	@Deprecated
	public UserService() {
		this(null, null);
	}

	@Inject
	public UserService(IUserRepository userRepository, IEncrypt encrypt) {
		this.userRepository = userRepository;
		this.encrypt = encrypt;
	}

	@Override
	public void createUser(User user) throws UserExistenceExcepion, EncryptionException {
		if (userRepository.userExist(user)) {
			throw new UserExistenceExcepion("Usuário inválido, escolha outro endereço de email");
		}
		user.setPassword(encrypt.encryptPassword(user.getPassword()));
		userRepository.insert(user);
	}

}
