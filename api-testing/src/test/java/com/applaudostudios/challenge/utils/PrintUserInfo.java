package com.applaudostudios.challenge.utils;

import com.applaudostudios.challenge.poi.User;

public class PrintUserInfo {

public static boolean printUserEmail(User user){
    System.out.print(user.getFirst_name());
    System.out.print(" " + user.getLast_name());
    System.out.print("´s email: " + user.getEmail());
    System.out.println("");
    System.out.println("------------------------------------------------------");
    return true;
}

    public static User findUser(User[] users, String firstName, String lastName){
    if (users.length > 0){
            for (User user : users) {
                if (user.getFirst_name().equals(firstName)
                        && user.getLast_name().equals(lastName)) {
                    return user;
                }
            }
    }
        return null;
    }

    public static boolean printUserAvatar(User user){
        System.out.print("Username: \"");
        System.out.print(user.getFirst_name());
        System.out.print(" " + user.getLast_name());
        System.out.println("\"");
        System.out.println("Avatar: " + user.getAvatar());
        System.out.println("------------------------------------------------------");
        return true;
    }

}
