/**
 * @ClassName:     ImageUtil.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author CRY 
 * @Date 2019-08-11
 */
package com.cry.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片处理工具类
 * @author CRY
 * @since 2019-08-11
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final Random r = new Random();

    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /** 
     * 生成带有水印的图片
     * 
     * @param thumbnailInputStream
     * @param fileName
     * @param targetAddr
     * @return 加水印后的图片的相对路径地址
     * @author CRY
     * @since 2019-10-06
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(fileName);
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is :" + PathUtil.getImgBasePath() + relativeAddr);
        // 调用Thumbnails生成带有水印的图片
        try {
            /*
             * 当我们使用ClassLoader的getResource方法获取路径时，获取到的路径被URLEncoder.encode(path,"utf-8")编码了
             * 当路径中存在中文和空格时，他会对这些字符进行转换，这样，得到的往往不是我们想要的真实路径 
             * 所以我们可以调用URLDecoder.decode()方法进行解码，以便得到原始的中文及空格路径。
             */
            basePath = URLDecoder.decode(basePath, "utf-8");
            logger.debug("basePath is :" + basePath + "watermark.jpg");
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        // 返回图片相对路径地址
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/xiangze/xxx.jpg, 那么 home work xiangze
     * 这三个文件夹都得自动创建
     * 
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * 
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     * 
     * @return
     */
    public static String getRandomFileName() {
        // 获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    /** 
     * storePath是文件的路径还是目录的路径， 如果storePath是文件路径则删除该文件，
     * 如果storePath是目录路径则删除该目录下的所有文件
     * 
     * @param storepath
     * @author CRY
     * @since 2019-10-06
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrDir = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrDir.exists()) {
            if (fileOrDir.isDirectory()) {
                // fileOrDir为目录路径时 先删除目录下所有文件
                File files[] = fileOrDir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            // 删除空目录
            fileOrDir.delete();
        }
    }

    public static void main(String[] args) throws IOException {
        // String dest = PathUtil.getShopImagePath(123);
        // File file = new File("D:/bishePic/1_1.jpg");
        // InputStream ins = new FileInputStream(file);
        // ImageUtil.generateThumbnail(ins, file.getName(), dest);
        //
        ImageUtil.deleteFileOrPath("\\upload\\images\\item\\shop\\8");
    }

}
