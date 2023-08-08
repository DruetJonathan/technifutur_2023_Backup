package com.babiarzdruet.labojavadataweb;

import com.babiarzdruet.labojavadataweb.models.entities.Role;
import com.babiarzdruet.labojavadataweb.models.entities.User;
import com.babiarzdruet.labojavadataweb.models.forms.UserForm;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
//        String username = System.getProperty("user.name");
//        System.out.println("C:\\Users\\"+username+"\\Documents\\LaboJavaDataWeb\\src\\main\\webapp\\WEB-INF\\pages\\images\\");
//
        Role userRole = new Role();
        userRole.setName("User");
        //
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(userRole);
        UserForm userForm = UserForm.builder()
                .firstname("firstname")
                .lastname("lastname")
                .email("email")
                .password("password")
                .profileImage("fileName")
                .build();
        Set<Role> roles = userForm.toEntity().getRoles();
        for (Role role :
                roles) {
            System.out.println(role.getName());
        }
    }
}
