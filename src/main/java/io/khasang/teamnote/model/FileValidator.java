package io.khasang.teamnote.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author gothmog on 29.08.2017.
 */
@Component
public class FileValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return FileBucket.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FileBucket file = (FileBucket) target;

        if (file.getFile() != null){
            if (file.getFile().getSize() == 0){
                errors.rejectValue("file", "missing.file");
            }
        }
    }
}
