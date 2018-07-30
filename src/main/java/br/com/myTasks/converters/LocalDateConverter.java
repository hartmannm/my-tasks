package br.com.myTasks.converters;

import java.time.LocalDate;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

@RequestScoped
@Convert(LocalDate.class)
public class LocalDateConverter implements Converter<LocalDate>{

	@Override
	public LocalDate convert(String value, Class<? extends LocalDate> type) {
		if (value == null || value.isEmpty()) {
            return null;
        }
		
		try {
			return LocalDate.parse(value);
		} catch(Exception e) {
			throw new ConversionException(new ConversionMessage("is_not_a_valid_date", value));
		}
	}

}
