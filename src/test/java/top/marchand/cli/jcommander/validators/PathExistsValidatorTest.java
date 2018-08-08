/*
 * Licensed under Apache 2.0
 */
package top.marchand.cli.jcommander.validators;

import com.beust.jcommander.ParameterException;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmarchand
 */
public class PathExistsValidatorTest {
    
    private static PathExistsValidator validator;
    
    @BeforeClass
    public static void before() {
        validator = new PathExistsValidator();
    }
    
    @Test
    public void testExistingStringAbsolutePath() {
        File f = new File(System.getProperty("user.dir"));
        String value = f.getAbsolutePath();
        validator.validate("paramName", value);
        assertTrue(true);
    }

    @Test(expected = ParameterException.class)
    public void testNonExistingStringAbsolutePath() {
        File userDir = new File(System.getProperty("user.dir"));
        File f = new File(userDir,"fakeFileThatShouldn't exist");
        String value = f.getAbsolutePath();
        validator.validate("paramName", value);
        fail("This should have throw a ParameterException");
    }
}
