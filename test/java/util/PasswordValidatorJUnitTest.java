package com.example.demo.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorJUnitTest {
    
    @Test
    public void testValidPasswords() {
        assertTrue(PasswordValidator.isValid("Password123!"));
        assertTrue(PasswordValidator.isValid("MySecure@Pass1"));
        assertTrue(PasswordValidator.isValid("Complex#Pass99"));
        assertEquals("Valid password", PasswordValidator.getValidationMessage("Password123!"));
    }
    
    @Test
    public void testInvalidPasswords() {
        assertFalse(PasswordValidator.isValid(null));
        assertFalse(PasswordValidator.isValid(""));
        assertFalse(PasswordValidator.isValid("short"));
        assertFalse(PasswordValidator.isValid("password123!"));
        assertFalse(PasswordValidator.isValid("PASSWORD123!"));
        assertFalse(PasswordValidator.isValid("PasswordABC!"));
        assertFalse(PasswordValidator.isValid("Password123"));
        
        assertEquals("Password cannot be null", PasswordValidator.getValidationMessage(null));
        assertEquals("Password must be at least 8 characters", PasswordValidator.getValidationMessage("short"));
        assertEquals("Password must contain uppercase letter", PasswordValidator.getValidationMessage("password123!"));
        assertEquals("Password must contain lowercase letter", PasswordValidator.getValidationMessage("PASSWORD123!"));
        assertEquals("Password must contain digit", PasswordValidator.getValidationMessage("PasswordABC!"));
        assertEquals("Password must contain special character", PasswordValidator.getValidationMessage("Password123"));
    }
    
    @Test
    public void testPasswordLengthBoundary() {
        assertFalse(PasswordValidator.isValid("Pass1!a")); // 7 characters
        assertTrue(PasswordValidator.isValid("Pass1!ab")); // 8 characters
        assertTrue(PasswordValidator.isValid("VeryLongPassword123!WithManyCharacters"));
    }
}