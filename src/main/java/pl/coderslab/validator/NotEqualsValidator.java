package pl.coderslab.validator;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NotEqualsValidator implements
        ConstraintValidator<NotEquals, Number> {

    private static final String DEC_PT = ".";

    List<BigDecimal> rejectValues = null;

    @Override
    public void initialize(NotEquals constraintAnnotation) {
        rejectValues = new ArrayList<BigDecimal>();
        for (double number : constraintAnnotation.rejectValues()) {
            rejectValues.add(new BigDecimal(number)
                    .setScale(findScale(String.valueOf(number)), BigDecimal.ROUND_HALF_UP));
        }
    }

    /* (non-Javadoc)
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        boolean isValid = false;

        if (!CollectionUtils.isEmpty(rejectValues) && value != null) {

            boolean found = false;
            for (BigDecimal rejectValue : rejectValues) {
                String valueString = String.valueOf(value);
                if (rejectValue.compareTo(new BigDecimal(valueString).setScale(
                        findScale(valueString), BigDecimal.ROUND_HALF_UP)) == 0) {
                    found = true;
                    break;
                }
            }
            isValid = !found;

        } else {
            isValid = true;
        }
        return isValid;

    }

    private int findScale(String numString) {
        int scale = 0;
        if (numString.contains(DEC_PT)) {
            scale = numString.substring(numString.indexOf(DEC_PT), numString.length()).length() - 1;
        }

        return scale;
    }

}