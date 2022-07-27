package com.software_concorrente;

import java.nio.charset.Charset;
import java.sql.*;
import java.util.Random;
public class Queries {
    public void selectPessoas(){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from contas");
            int idPessoa;
            int id;
            int numeroConta;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                idPessoa = resultSet.getInt("idPessoa");
                numeroConta = resultSet.getInt("numeroConta");
                System.out.println("Id : " + id
                        + "idPessoa : " + idPessoa
                        + "numeroConta : " + numeroConta
                        );
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public String[] signIn(){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            Random rand = new Random();
            Random rand2 = new Random();
            String name = String.valueOf(Math.abs(rand2.nextInt()));
            int id = Math.abs(rand.nextInt());
            String[] response = new String[]{String.valueOf(id),name,"D"};
             statement.execute(
                "insert into login(id,login,password) values('"+ id+"','"+name+"','D')"
            );
            statement.close();
            connection.close();
            return response;
        }catch(Exception exception){
            System.out.println(exception);
            return new String[]{"error"};
        }

    }
    public void login(String[]info){
        try{
            Connection connection = Connect.startConnection();
            Statement statement;
            statement = connection.createStatement();
            String id = info[0];
            String password = info[2];
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from login where id = '"+ id+"' and password = '"+ password+"'");
                while (resultSet.next()) {
                    int idUser = resultSet.getInt("id");
                    String name = resultSet.getString("login");
                        System.out.println("Id : " + id
                        + "idUser : " + idUser
                        + "name : " + name
                );
            }
                    resultSet.close();
                    statement.close();
                    connection.close();
        }catch(Exception error){
            System.out.println(error);
        }
       

    }
    public void selectAll(){

    }
    public void delete(){

    }

    public void create(){

    }
}
