package com.javajaider;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Auth {

    public static String authUser(String username, String password)
            throws FileNotFoundException, NoSuchAlgorithmException, UnsupportedEncodingException {
        UserModel user = getUserByUsername(username);
        if (user == null)
            return "User doesn't exist";

        String passwordSalt = password + user.saltPassword;
        String passwordHashAttempt = SecurityAuth.generateHash(passwordSalt);

        if (user.hashedPassword.equals(passwordHashAttempt))
            return "Welcome, " + user.fullName;

        return "Password incorrect";
    }

    private static List<UserModel> getUsers() throws FileNotFoundException {
        try {
            List<String> rowsCsvFile = CsvReader.readFrom("users.csv");
            return convertRowsCsvToUserModels(rowsCsvFile);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Cannot connect to database");
        }
    }

    private static List<UserModel> convertRowsCsvToUserModels(List<String> rowsCsvFile) {
        List<UserModel> userModels = new ArrayList<>();
        for (String string : rowsCsvFile) {
            String[] data = string.split(",");
            userModels.add(new UserModel(data[0], data[1], data[2], data[3]));
        }
        return userModels;
    }

    private static UserModel getUserByUsername(String username) throws FileNotFoundException {
        List<UserModel> users = getUsers();
        for (UserModel userModel : users) {
            if (userModel.userName.equals(username))
                return userModel;
        }
        return null;
    }

}
