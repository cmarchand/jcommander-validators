/*
 * Licensed under Apache 2.0
 */
package top.marchand.cli.jcommander.validators;

import com.beust.jcommander.IParameterValidator2;
import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterDescription;
import com.beust.jcommander.ParameterException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * A validator that validates only paths that exist and is a regulare file 
 * or a directory.
 * @author cmarchand
 */
public class PathExistsValidator implements IParameterValidator2, IValueValidator<Path> {
    final FileSystem fs;
    
    public PathExistsValidator() {
        super();
        fs=FileSystems.getDefault();
    }

    @Override
    public void validate(String name, String value, ParameterDescription pd) throws ParameterException {
        validate(name, value);
    }

    @Override
    public void validate(String name, String value) throws ParameterException {
        Path p = fs.getPath(value);
        validate(name, p);
    }

    @Override
    public void validate(String string, Path t) throws ParameterException {
        if(!t.toFile().exists()) throw new ParameterException(t.toString()+" does not exist");
    }
    
}
