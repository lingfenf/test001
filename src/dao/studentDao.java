package dao;

import entity.message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class studentDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/student";
    String user = "root";
    String password = "123";
    //登录验证
    public boolean login(Integer sno,String name) {
        boolean bol=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            String sql = "select * from message where sno=? and name=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sno);
            ps.setString(2,name);
            rs=ps.executeQuery();
            while(rs.next()){
                bol=true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bol;
    }
    //学生查询
    public List studentQuery() {
        List studentList = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            String sql = "select * from message";
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                Integer sno = rs.getInt("sno");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String province = rs.getString("province");
                String city = rs.getString("city");
                message ma = new message(id,sno,name,sex,province,city);
                studentList.add(ma);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }
    //学生id查询
    public message studentIdQuery( Integer id) {
        message ma=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            String sql = "select * from message where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                Integer sno = rs.getInt("sno");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String province = rs.getString("province");
                String city = rs.getString("city");
                ma = new message(id,sno,name,sex,province,city);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ma;
    }
    //学生信息修改
    public int studentUpdate( message ma) {
        int result=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            String sql = "update message set sno=?,name=?,sex=?,province=?,city=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,ma.getSno());
            ps.setString(2,ma.getName());
            ps.setString(3,ma.getSex());
            ps.setString(4,ma.getProvince());
            ps.setString(5,ma.getCity());
            ps.setInt(6,ma.getId());
            result=ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    //添加学生
    public int addStudent(message ma) {
        int result=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            String sql = "insert into message(sno,name,sex,province,city) values(?,?,?,?,?) ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,ma.getSno());
            ps.setString(2,ma.getName());
            ps.setString(3,ma.getSex());
            ps.setString(4,ma.getProvince());
            ps.setString(5,ma.getCity());
            result=ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    //删除学生
    public int deleteStudent(Integer id) {
        int result=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            String sql = "delete from message where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            result=ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
