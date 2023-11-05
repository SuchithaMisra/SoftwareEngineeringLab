package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UsernameValidator {
    public UsernameValidator() {
    }

    public boolean validateUsername(String username) {
        Pattern format = Pattern.compile("^(.+)@(.+)$");
        Matcher match = format.matcher(username);
        return match.matches();
    }
}
