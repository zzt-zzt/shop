package com.zzt.Utils;

import com.zzt.pro.Client;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UploadUtils {
    //创建多层目录
    public static String getDir(String name) {
        int i = name.hashCode();//每一个字符串都有其hashcode编码
        String hex = Integer.toHexString(i);
        int j = hex.length();
        for (int k = 0; k < 4 - j; k++) {
            hex = "0" + hex;
        }
        return "/" + hex.charAt(0) + "/" + hex.charAt(1) + "/" + hex.charAt(2) + "/";
    }

    //获取随机名称
    public static String newFilename(String name) {
        //获取后缀名
        int index = name.lastIndexOf(".");
        if (index == -1) {

        } else {
            //生成随机文件名
            return UUID.randomUUID().toString().replace("-", "").toUpperCase() + name.substring(index);
        }
        return null;
    }


}

