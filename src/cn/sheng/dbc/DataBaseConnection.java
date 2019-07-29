package cn.sheng.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {
        private final String DRIVER="com.mysql.jdbc.Driver";
        private final String ULR="jdbc:mysql://localhost:3306/sjw666?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull";
        private final String USER="root";
        private final String PASS="123";
        public Connection conn;
        public DataBaseConnection() {
        	try {
				Class.forName(DRIVER);
				this.conn=DriverManager.getConnection(ULR, USER, PASS);
			} catch (Exception e) {
		
				e.printStackTrace();
			}
        }


        public Connection getConnection(){
                return this.conn;
        }
        
        public void close(){
        	if(this.conn!=null){
        		try {
					this.conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
        	}
        }
}