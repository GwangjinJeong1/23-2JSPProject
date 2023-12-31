package com.example.jspproject.common;
import com.example.jspproject.bean.MemberVO;
import com.example.jspproject.dao.MemberDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public MemberVO uploadPhoto(HttpServletRequest request) {
        String filename = "";
        int sizeLimit = 15 * 1024 * 1024;

        String realPath = request.getServletContext().getRealPath("upload");

        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdirs();

        MemberVO one = null;
        MultipartRequest multipartRequest = null;
        try {
            multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
            filename = multipartRequest.getFilesystemName("photo");
            one = new MemberVO();
            String sid = multipartRequest.getParameter("seq");
            if(sid!=null && !sid.isEmpty()) one.setSid(Integer.parseInt(sid));
            one.setName(multipartRequest.getParameter("name"));
            one.setEmail(multipartRequest.getParameter("email"));
            one.setPhone(multipartRequest.getParameter("phone"));
            one.setRc(multipartRequest.getParameter("rc"));
            one.setDetail(multipartRequest.getParameter("detail"));
            if (sid!=null && sid.isEmpty()) {
                MemberDAO dao = new MemberDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(sid));
                if(filename != null && oldfilename != null) FileUpload.deleteFile(request, oldfilename);
                else if(filename == null && oldfilename != null) filename = oldfilename;
            }
            one.setPhoto(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return one;
    }

    public static void deleteFile(HttpServletRequest request, String filename) {
        String filePath = request.getServletContext().getRealPath("upload");

        File f = new File(filePath + "/" + filename);
        if(f.exists()) f.delete();
    }
}
