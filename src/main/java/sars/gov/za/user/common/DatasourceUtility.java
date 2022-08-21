/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.user.common;

import com.zaxxer.hikari.HikariDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author S2028398
 */
public class DatasourceUtility {

    public static DataSource getDatasource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setInitializationFailTimeout(0);
        dataSource.setMaximumPoolSize(10);
        dataSource.setDataSourceClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");

        dataSource.addDataSourceProperty("url", "jdbc:sqlserver://LPTAXN73\\SQLEXPRESS14:2010;databaseName=USER_DB");
        dataSource.addDataSourceProperty("user", "terry");
        dataSource.addDataSourceProperty("password", "P@sswords.");

        return dataSource;
    }

    public static DataSource getDatasourceLookup() {
        try {
            InitialContext initialContext = new InitialContext();
            //DataSource dataSource = (DataSource) initialContext.lookup("jdbc/userDS");
            DataSource dataSource = (DataSource) initialContext.lookup("java:/userDS");
            return dataSource;
        } catch (NamingException ex) {
            Logger.getLogger(DatasourceUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
