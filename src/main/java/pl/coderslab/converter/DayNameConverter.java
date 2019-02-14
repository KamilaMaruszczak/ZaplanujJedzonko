package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.DayName;
import pl.coderslab.repository.DayNameRepository;


public class DayNameConverter implements Converter<String, DayName> {
    @Autowired
    DayNameRepository dayNameRepository;

    @Override
    public DayName convert(String s) {
        return dayNameRepository.findOne(Long.parseLong(s));
    }
}
