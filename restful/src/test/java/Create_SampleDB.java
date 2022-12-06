import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_SampleDB
{
    public static void main( String args[] )
    {
        StringBuilder sb = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            Class.forName( "org.sqlite.JDBC" );
            conn = DriverManager.getConnection( "jdbc:sqlite:sample.db" );
            stmt = conn.createStatement();
            System.out.println("Opened database successfully");

            sb = new StringBuilder();
            sb.append( "create table dept(" );
            sb.append( "deptno integer primary key not null" );
            sb.append( ", dname text not null" );
            sb.append( ", loc text)" );
            stmt.executeUpdate( sb.toString() );
            System.out.println("Table created successfully");

            sb = new StringBuilder();
            sb.append( "create table emp(" );
            sb.append( "empno integer primary key not null" );
            sb.append( ", ename text not null" );
            sb.append( ", job text" );
            sb.append( ", mgr integer" );
            sb.append( ", hiredate text" );
            sb.append( ", sal integer" );
            sb.append( ", comm integer" );
            sb.append( ", deptno integer references dept)" );
            stmt.executeUpdate( sb.toString() );
            System.out.println("Table created successfully");

            sb = new StringBuilder();
            sb.append( "create table emp_audit(" );
            sb.append( "empno integer primary key not null" );
            sb.append( ", ename text not null" );
            sb.append( ", job text" );
            sb.append( ", mgr integer" );
            sb.append( ", hiredate text" );
            sb.append( ", sal integer" );
            sb.append( ", comm integer" );
            sb.append( ", deptno integer references dept" );
            sb.append( ", create_id text not null" );
            sb.append( ", create_ip text not null" );
            sb.append( ", create_dt text not null" );
            sb.append( ", update_id text not null" );
            sb.append( ", update_ip text not null" );
            sb.append( ", update_dt text not null)" );
            stmt.executeUpdate( sb.toString() );
            System.out.println("Table created successfully");

            stmt.executeUpdate( "insert into dept(deptno, dname, loc) values(10,'ACCOUNTING','NEW YORK')" );
            stmt.executeUpdate( "insert into dept(deptno, dname, loc) values(20,'RESEARCH','DALLAS')" );
            stmt.executeUpdate( "insert into dept(deptno, dname, loc) values(30,'SALES','CHICAGO')" );
            stmt.executeUpdate( "insert into dept(deptno, dname, loc) values(40,'OPERATIONS','BOSTON')" );
            System.out.println("Records created successfully");

            stmt.execute( "PRAGMA foreign_keys = ON" );
            stmt.executeUpdate( "insert into emp values(7782,'CLARK','MANAGER',7839,'1981-06-09 00:00:00',2450,NULL,10)" );
            stmt.executeUpdate( "insert into emp values(7839,'KING','PRESIDENT',NULL,'1981-11-17 00:00:00',5000,NULL,10)" );
            stmt.executeUpdate( "insert into emp values(7934,'MILLER','CLERK',7782,'1982-01-23 00:00:00',1300,NULL,10)" );
            stmt.executeUpdate( "insert into emp values(7369,'SMITH','CLERK',7902,'1980-12-17 00:00:00',800,NULL,20)" );
            stmt.executeUpdate( "insert into emp values(7566,'JONES','MANAGER',7839,'1981-04-02 00:00:00',2975,NULL,20)" );
            stmt.executeUpdate( "insert into emp values(7788,'SCOTT','ANALYST',7566,'1987-07-13 00:00:00',3000,NULL,20)" );
            stmt.executeUpdate( "insert into emp values(7876,'ADAMS','CLERK',7788,'1987-07-13 00:00:00',1100,NULL,20)" );
            stmt.executeUpdate( "insert into emp values(7902,'FORD','ANALYST',7566,'1981-12-03 00:00:00',3000,NULL,20)" );
            stmt.executeUpdate( "insert into emp values(7499,'ALLEN','SALESMAN',7698,'1981-02-20 00:00:00',1600,300,30)" );
            stmt.executeUpdate( "insert into emp values(7521,'WARD','SALESMAN',7698,'1981-02-22 00:00:00',1250,500,30)" );
            stmt.executeUpdate( "insert into emp values(7654,'MARTIN','SALESMAN',7698,'1981-09-28 00:00:00',1250,1400,30)" );
            stmt.executeUpdate( "insert into emp values(7698,'BLAKE','MANAGER',7839,'1981-05-01 00:00:00',2850,NULL,30)" );
            stmt.executeUpdate( "insert into emp values(7844,'TURNER','SALESMAN',7698,'1981-09-08 00:00:00',1500,0,30)" );
            stmt.executeUpdate( "insert into emp values(7900,'JAMES','CLERK',7698,'1981-12-03 00:00:00',950,NULL,30)" );
            System.out.println("Records created successfully");

            rs = stmt.executeQuery( "select * from dept" );
            System.out.println( "deptno|dname|loc" );
            while ( rs.next() )
            {
                System.out.println( rs.getInt( "deptno" ) + "|" + rs.getString( "dname" ) + "|" + rs.getString( "loc" ) );
            }

            rs = stmt.executeQuery( "select * from emp" );
            System.out.println( "empno|ename|job|mgr|hiredate|sal|comm|deptno" );
            while ( rs.next() )
            {
                System.out.println( rs.getInt( "empno" ) + "|" + rs.getString( "ename" ) + "|" + rs.getString( "job" ) + "|" + rs.getString( "mgr" ) + "|" + rs.getString( "hiredate" ) + "|" + rs.getString( "sal" ) + "|" + rs.getString( "comm" ) + "|" + rs.getInt( "deptno" ) );
            }
            System.out.println( "Operation done successfully" );

        } catch ( Exception e )
        {
            e.printStackTrace();
        }finally{
            try
            {
                rs.close();
            } catch ( SQLException e )
            {
                e.printStackTrace();
            }
            try
            {
                stmt.close();
            } catch ( SQLException e )
            {
                e.printStackTrace();
            }
            try
            {
                conn.close();
            } catch ( SQLException e )
            {
                e.printStackTrace();
            }
        }
        System.out.println("DONE");
    }
}
