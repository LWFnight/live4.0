package com.example.live.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class ImgToJson {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    /**
     * 将图片转换为字节数组
     * @return
     */
    private byte[] loadImage(File file){
        //用于返回的字节数组
        byte[] data=null;
        //打开文件输入流
        FileInputStream fin=null;
        //打开字节输出流
        ByteArrayOutputStream bout=null;
        try{
            //文件输入流获取对应文件
            fin=new FileInputStream(file);
            //输出流定义缓冲区大小
            bout=new ByteArrayOutputStream((int)file.length());
            //定义字节数组，用于读取文件流
            byte[] buffer=new byte[1024];
            //用于表示读取的位置
            int len=-1;
            //开始读取文件
            while((len=fin.read(buffer))!=-1){
                //从buffer的第0位置开始，读取至第len位置，结果写入bout
                bout.write(buffer,0,len);
            }
            //将输出流转为字节数组
            data=bout.toByteArray();
            //关闭输入输出流
            fin.close();
            bout.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 把字节数组转化为字符串----"ISO-8859-1"
     * @param data
     * @return
     */
    private String byteToString(byte[] data){
        String dataString=null;
        try{
            //将字节数组转为字符串，编码格式为ISO-8859-1
            dataString=new String(data,"UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataString;
    }

    /**
     * 压缩字符串----"ISO-8859-1"
     * @param data
     * @return
     */
    private String compress(String data){
        String finalData=null;
        try{
            //打开字节输出流
            ByteArrayOutputStream bout=new ByteArrayOutputStream();
            //打开压缩用的输出流,压缩后的结果放在bout中
            GZIPOutputStream gout=new GZIPOutputStream(bout);
            //写入待压缩的字节数组
            gout.write(data.getBytes("UTF-8"));
            //完成压缩写入
            gout.finish();
            //关闭输出流
            gout.close();
            finalData=bout.toString("UTF-8");
        }catch(Exception e){
            e.printStackTrace();
        }
        return finalData;
    }

    public String imgToJson(File file){
        ImgToJson img = new ImgToJson();
        String finalData=null;
        finalData = img.compress(img.byteToString(img.loadImage(file)));
        return finalData;
    }

    public String getImageBinary(String Imgpath){
        File f = new File(Imgpath);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Imgpath;
    }

    public void base64StringToImage(String savePath,String base64String){
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 =ImageIO.read(bais);
            File w2 = new File(savePath);//可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
