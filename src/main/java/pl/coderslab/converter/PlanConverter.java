package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Plan;
import pl.coderslab.repository.PlanRepository;

public class PlanConverter implements Converter<String, Plan> {
    @Autowired
    PlanRepository planRepository;

    @Override
    public Plan convert(String s) {
        return planRepository.findOne(Long.parseLong(s));
    }
}