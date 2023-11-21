package com.example.jspproject.dao;

import com.example.jspproject.Util.JDBCUtil;
import com.example.jspproject.bean.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class MemberDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String MEMBER_INSERT = "insert into member (name, photo, email, phone, rc, detail) values (?,?,?,?,?,?)";
    private final String MEMBER_UPDATE = "update member set name=?, photo=?, email=?, phone=?, rc=?, detail=? where sid=?";
    private final String MEMBER_DELETE = "delete from member where sid=?";
    private final String MEMBER_GET = "select * from member where sid=?";
    private final String MEMBER_LIST = "select * from member order by regdate desc";

    public int insertMember(MemberVO vo) {
        int result = 0;
        System.out.println("===> JDBC로 insertMember() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setString(1, vo.getName());
            stmt.setString(2, vo.getPhoto());
            stmt.setString(3, vo.getEmail());
            stmt.setString(4, vo.getPhone());
            stmt.setString(5, vo.getRc());
            stmt.setString(6, vo.getDetail());
            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteMember(int sid) {
        System.out.println("===> JDBC로 deleteMember() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setInt(1, sid);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateMember(MemberVO vo) {
        System.out.println("===> JDBC로 updateMember() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_UPDATE);
            stmt.setString(1, vo.getName());
            stmt.setString(2, vo.getPhoto());
            stmt.setString(3, vo.getEmail());
            stmt.setString(4, vo.getPhone());
            stmt.setString(5, vo.getRc());
            stmt.setString(6, vo.getDetail());
            stmt.setInt(7, vo.getSid());
            System.out.println(vo.getName() + "-" + vo.getEmail() + "-" + vo.getPhone() + "-" + vo.getRc() + "-" + vo.getDetail());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public MemberVO getMember(int sid) {
        MemberVO one = new MemberVO();
        System.out.println("===> JDBC로 getMember() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_GET);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setSid(rs.getInt("sid"));
                one.setName(rs.getString("name"));
                one.setPhoto(rs.getString("photo"));
                one.setEmail(rs.getString("email"));
                one.setPhone(rs.getString("phone"));
                one.setRc(rs.getString("rc"));
                one.setDetail(rs.getString("detail"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }

    public List<MemberVO> getMemberList(){
        List<MemberVO> list = new ArrayList<MemberVO>();
        System.out.println("===> JDBC로 getMemberList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                MemberVO one = new MemberVO();
                one.setSid(rs.getInt("sid"));
                one.setName(rs.getString("name"));
                one.setEmail(rs.getString("email"));
                one.setPhone(rs.getString("phone"));
                one.setRc(rs.getString("rc"));
                one.setDetail(rs.getString("detail"));
                one.setRegdate(rs.getDate("regdate"));
                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getPhotoFilename(int sid) {
        String filename = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_GET);
            stmt.setInt(1, sid);
            rs = stmt.executeQuery();
            if(rs.next()) {
                filename = rs.getString("photo");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
        return filename;
    }
}
