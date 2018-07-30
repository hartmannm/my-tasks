package br.com.myTasks.validators;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.myTasks.interfaces.ITaskValidator;
import br.com.myTasks.models.entityes.Task;

public class TaskValidator implements ITaskValidator {

	private Validator validator;
	
	@Deprecated
	public TaskValidator() {
		this(null);
	}
	
	@Inject
	public TaskValidator(Validator validator) {
		this.validator = validator;
	}
	
	@Override
	public void validate(Task task) {
		validator.validate(task);
		
		//nome
		if(task.getName() == null || task.getName().length() < 5 || task.getName().length() > 50) {
			validator.add(new I18nMessage("task.name", "task.name.invalid"));
		}
		
		//data
		if(task.getDate() == null) {
			validator.add(new I18nMessage("task.date", "task.date.null"));
		}
		if(task.getDate() != null && task.getDate().isBefore(LocalDate.now())) {
			validator.add(new I18nMessage("task.date", "task.date.past"));
		}
		
		//horario
		//valida horário sem data
		if(task.getDate() == null && task.getHour() != null) {
			validator.add(new I18nMessage("task.date", "task.hour.without.date"));
		}
		//valida data e hora
		if(task.getDate() != null && task.getHour() != null) {
			if(task.getDate().isEqual(LocalDate.now()) && task.getHour().isBefore(LocalTime.now())) {
				validator.add(new I18nMessage("task.hour", "task.hour"));
			}
		}
		
		//observaçoes
		if(task.getDetails() != null && (task.getDetails().length() < 5 || task.getDetails().length() > 100)) {
			validator.add(new I18nMessage("task.details", "task.details.length"));
		}
	}
	
	@Override
	public <T> T onErrorRedirectTo(T controller) {
		return validator.onErrorRedirectTo(controller);
	}

}
