package com.example.obcifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;


public class EncryptionTest{
    /**
     * BCrypt genera su propio salt de 16 bytes
     * El resultado de cifrar con Bcrypt será un string 60 caracteres:
     * $a version
     * $10 fuerza (+ fuerza + requerimientos computacionales, va de 4 a 31, por defecto 10)
     * Los 22 siguientes caracteres son el salt generado
     */
    @Test
    void bcryptTest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
        boolean matches = passwordEncoder.matches("user", hashedPassword);
        String str = String.valueOf(matches);
        System.out.println("¿Las passwords coinciden? \n" +
                str.toUpperCase().charAt(0)+str.substring(1).toLowerCase()
        );
    }

@Test
   void testPbdkf2() {
    int DEFAULT_SALT_LENGTH = 20;
    int DEFAULT_ITERATIONS = 10;
    int DEFAULT_ALGORITHM = 256;
    String Passw = "admin";
    Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder( Passw, DEFAULT_SALT_LENGTH, DEFAULT_ITERATIONS, DEFAULT_ALGORITHM);
    boolean matches = passwordEncoder.matches("user", passwordEncoder.encode(Passw));
    System.out.println(passwordEncoder.encode(Passw));
    String str = String.valueOf(matches);
    System.out.println("¿Las passwords coinciden? \n" +
            str.toUpperCase().charAt(0) + str.substring(1).toLowerCase()
        );
    }

//    @Test
//    void asgqArgnsa(){
//        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(16,32,1,4,2);
//        String as = passwordEncoder.encode( "rawPassword");
//        System.out.println(as);
//    }

    @Test
    void springPasswordEncoders(){
        Map<String, PasswordEncoder> enconders = new HashMap<>();
        enconders.put("bcrypt", new BCryptPasswordEncoder());
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", enconders);
        String as = passwordEncoder.encode("admin");
        System.out.println(as);
    }


}
