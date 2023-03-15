package com.marcos.VintedAPI.Model;

public class FactoryConection {
    public static Motor getConnection(String motor) {
        switch (motor) {
            case "mysql":
                return new Motor("com.mysql.jdbc.Driver", "root","root","jdbc:mysql://oracle:3306/","Vinted");
                case "oracle":
                return new Motor("oracle.jdbc.OracleDriver", "marcos","0770","jdbc:oracle:thin:@localhost:1521:XE","");
            default:
                return null;
        }
    }
}



