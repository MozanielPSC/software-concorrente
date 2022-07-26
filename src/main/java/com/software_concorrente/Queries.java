package com.software_concorrente;

import java.sql.*;
public class Queries {
    public void teste(){
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
}
