package cn.nwafulive.zq.db;

import cn.nwafulive.zq.bean.Student;

import java.sql.*;

/**
 * @Author ZhangQiong nwsuafzq@hotmail.com
 * @Date 2017/4/1
 * @Time 22:45.
 */
public class DBmanager {
    private static final String username = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/cobra?useUnicode=true&characterEncoding=utf8";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static Statement stmt = null;


    private static Connection getConn() {
        /**
         * @methodName getConn
         * @param []
         * @return java.sql.Connection
         * 2017/4/1 22:48
         */

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void insert(String sid, String sname, float score) {
        /**
         * @methodName insert
         * @param [sid, sname, score]
         * @return void
         * 2017/4/1 23:13
         */

        String sql = "insert into stutable values('" + sid + "','" + sname + "', " + score + ")";
        conn = getConn();
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    public static String check(String sid) {
        /**
         * @methodName check
         * @param [sid]
         * @return java.lang.String
         * 2017/4/1 23:13
         */

        String sql = "select * from stutable where sid = " + sid;
        conn = getConn();
        Student student = new Student();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                student.setSid(rs.getString(1));
                student.setSname(rs.getString(2));
                student.setScore(rs.getFloat(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student.toString();
    }

}

