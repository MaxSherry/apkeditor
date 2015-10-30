package com.zzzmode.apkeditor;


import com.zzzmode.apkeditor.apksigner.KeyHelper;
import com.zzzmode.apkeditor.axmleditor.asrc.*;
import com.zzzmode.apkeditor.utils.*;

import java.io.*;
import java.nio.*;

/**
 * Created by zl on 15/9/8.
 */
public class ApkEdirotMain {


    public static void main(String[] args)throws Exception{
        if(true){
            aaa();
            return;
        }

        //test code
        //如何生成 key，具体方法见KeyHelper
        ApkEditor editor=new ApkEditor(KeyHelper.privateKey,KeyHelper.sigPrefix);

        File unsignFile=new File(ClassLoader.getSystemClassLoader().getResource("tap_unsign.apk").toURI());
        File tempFile = File.createTempFile("tap_sign", ".apk",ApkEditor.getWorkDir());

        editor.setOrigFile(unsignFile.getAbsolutePath());
        editor.setOutFile(tempFile.getAbsolutePath());
        editor.setAppName("custom app name");
        editor.setAppIcon(new File(ClassLoader.getSystemClassLoader().getResource("ic_launcher.png").toURI()).getAbsolutePath());
        final boolean b = editor.create();
        System.out.println("apkeditor rebuild "+b+"    output apk path "+tempFile.getAbsolutePath());
    }



    private static void aaa()throws Exception{
        File f=new File(ClassLoader.getSystemClassLoader().getResource("resources.arsc").toURI());
        ApkResourceFinder finder=new ApkResourceFinder();



        System.out.println(finder.initialize(f));

    }
}
