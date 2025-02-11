package com.postgresql.cruddb.postgres;

import java.sql.*;

public class conexaoPostgres {
    public static void main (String[] args) {
        String url = "jdbc:postgresql://localhost:5432/escola";
        String user = "postgres";
        String pwd = "postgres";



        try(Connection connection = DriverManager.getConnection(url, user, pwd)) {
            System.out.println("Conexão bem sucedida com o Postgres!");

            String sql = "SELECT * FROM alunos;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                System.out.print("id: " + resultSet.getInt("id"));
                System.out.print("nome: " + resultSet.getString("nome"));
                System.out.println(("idade: " + resultSet.getInt("idade")));

            }

        } catch (SQLException error) {
            System.out.println("Erro ao conectar com o banco de dados: " + error.getMessage());
        }

    }
}
//1,45