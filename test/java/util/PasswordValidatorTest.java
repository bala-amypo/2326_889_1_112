package com.example.demo.util;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;

public class PasswordValidatorTest {
    
    @DataProvider(name = "validPasswords")
    public Object[][] validPasswords() {
        return new Object[][] {
            {"Password123!"},
            {"MySecure@Pass1"},
            {"Complex#Pass99"},
            {"Strong$Word8"},
            {"Valid&Test123"}
        };
    }
    
    @DataProvider(name = "invalidPasswords")
    public Object[][] invalidPasswords() {
        return new Object[][] {
            {null, "Password cannot be null"},
            {"", "Password must be at least 8 characters"},
            {"short", "Password must be at least 8 characters"},
            {"password123!", "Password must contain uppercase letter"},
            {"PASSWORD123!", "Password must contain lowercase letter"},
            {"PasswordABC!", "Password must contain digit"},
            {"Password123", "Password must contain special character"},
            {"Pass123", "Password must be at least 8 characters"}
        };
    }
    
    @Test(dataProvider = "validPasswords")
    public void testValidPasswords(String password) {
        assertTrue(PasswordValidator.isValid(password), 
                  "Password should be valid: " + password);
        assertEquals(PasswordValidator.getValidationMessage(password), 
                    "Valid password");
    }
    
    @Test(dataProvider = "invalidPasswords")
    public void testInvalidPasswords(String password, String expectedMessage) {
        assertFalse(PasswordValidator.isValid(password), 
                   "Password should be invalid: " + password);
        assertEquals(PasswordValidator.getValidationMessage(password), 
                    expectedMessage);
    }
    
    @Test
    public void testPasswordWithMinimumRequirements() {
        String password = "Aa1!aaaa";
        assertTrue(PasswordValidator.isValid(password));
        assertEquals(PasswordValidator.getValidationMessage(password), "Valid password");
    }
    
    @Test
    public void testPasswordWithAllSpecialCharacters() {
        String[] specialChars = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", 
                               ",", ".", "?", "\"", ":", "{", "}", "|", "<", ">"};
        
        for (String special : specialChars) {
            String password = "Password1" + special;
            assertTrue(PasswordValidator.isValid(password), 
                      "Password with " + special + " should be valid");
        }
    }
    
    @Test
    public void testPasswordLengthBoundary() {
        // 7 characters - should fail
        assertFalse(PasswordValidator.isValid("Pass1!a"));
        
        // 8 characters - should pass
        assertTrue(PasswordValidator.isValid("Pass1!ab"));
        
        // Very long password - should pass
        assertTrue(PasswordValidator.isValid("VeryLongPassword123!WithManyCharacters"));
    }
}