package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UsernameTest {
    UsernameValidator username_check;
    
    @Test
    public void noAtSign() {
        username_check = new UsernameValidator(); // Create an instance of UsernameValidator
        assertThat(username_check.validateUsername("SoftwareEngineering")).isFalse();
    }
    
    @Test
    public void withAtSign() {
        username_check = new UsernameValidator(); // Create an instance of UsernameValidator
        assertThat(username_check.validateUsername("SoftwareEngineering@gmail.com")).isTrue();
    }
}
