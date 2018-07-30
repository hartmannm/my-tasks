package br.com.myTasks.converters;

import java.time.LocalTime;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

@RequestScoped
@Convert(LocalTime.class)
public class LocalTimeConverter implements Converter<LocalTime> {

	@Override
	public LocalTime convert(String value, Class<? extends LocalTime> type) {
		if (value == null || value.isEmpty()) {
            return null;
        }
		
		try {
			return LocalTime.parse(value);
		} catch(Exception e) {
			throw new ConversionException(new ConversionMessage("is_not_a_valid_time", value));
		}
	}

}
