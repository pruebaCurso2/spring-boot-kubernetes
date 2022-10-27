package org.soyphea.k8s.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soyphea.k8s.config.UserConfig;
import org.soyphea.k8s.domain.User;
import org.soyphea.k8s.srevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.List;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private UserService userService;

    public Controller(){
        log.info("Initialised Bean.");
    }
    @GetMapping("/k8s/{name}")
    public String k8sGreeting(@PathVariable("name") String name) {

        byte[] salt = "notrandom".getBytes();

        PBEParameterSpec cipherSpec = new PBEParameterSpec(salt, 10000); // Noncompliant, predictable salt
        PBEKeySpec spec = new PBEKeySpec(chars, salt, 10000, 256); // Noncompliant, predictable salt
        log.info("Got the request with name:{}", name);
        return String.format("Hi %s- I am ConfigMap running in side k8s with value %s", name,userConfig);
    }

    @GetMapping("/users/{contain_name}")
    public List<User> getUsersByContainName(@PathVariable("contain_name") String containName){
        return userService.getUser(containName);
    }



}
