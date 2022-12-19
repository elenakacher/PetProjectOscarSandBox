package com.telran.oscar.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> regUserDataWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/userData.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> regInvalidUserEmailWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/regWithInvalidUserEmail.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> regInvalidUserPasswordWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/regWithInvalidUserPassword.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> EditProfileWithInvalidEmailWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/invalidUserEmail.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewAddressWithMissingRequiredFieldsWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/addressWithMissinigRequeredFields.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginInvalidDataWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/loginInvalidData.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> ReviewForLoggedUserWithMissingRequiredFieldsWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/reviewWithMissingRequiredFieldsData.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> ReviewForUnloggedUserWithMissingRequiredFieldsWithCsv() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/dataProviderFiles/reviewWithMissingRequiredFieldsUnloggedUserData.csv")
        ));
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = reader.readLine();

        while(line != null) {
            userData.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return userData.iterator();
    }

}
