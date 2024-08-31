package cn.edu.tyut.controller;

import cn.edu.tyut.domain.Good;
import cn.edu.tyut.domain.GoodImage;
import cn.edu.tyut.service.GoodImageService;
import cn.edu.tyut.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodImageService goodImageService;

    @Value("${dirPath}")
    private String dirPath;

    @PostMapping("/upload")
    public String upload(@RequestParam(value = "fileUpload") MultipartFile[] fileUpload, Good good, Model model) throws FileNotFoundException {

        // 调用goodService的addGood方法，添加商品信息，并返回商品对象good1
        Good good1 = goodService.addGood(good);

        // 创建一个存储文件名的列表
        List<String> fileNames = new ArrayList<String>();

        // 初始化文件名为默认图片
        for (int i = 0; i < 10; i ++){
            fileNames.add(i,"UpLoadFiles/noImage.jpg");
        }

        // 遍历上传的文件数组
        for (int j = 0; j < fileUpload.length; j++) {
            // 获取当前文件对象
            MultipartFile file = fileUpload[j];
            // 获取原始文件名
            String fileName = file.getOriginalFilename();
            // 生成唯一的文件名
            fileName = UUID.randomUUID() + "_" +fileName;

            // 构建文件保存路径
            String dirPath1 = dirPath + good1.getGoodId()+"/";

            // 创建文件路径对象
            File filePath = new File(dirPath1);

            // 如果文件路径不存在，则创建目录
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                // 将文件保存到指定路径
                file.transferTo(new File(dirPath1+fileName));
                // 构建文件访问URL
                String url = "UpLoadFiles/"+good1.getGoodId()+"/"+fileName;
                // 更新文件名列表
                fileNames.set(j,url);
            }catch (Exception e){
                // 输出异常信息
                e.printStackTrace();
                // 将异常信息添加到model中
                model.addAttribute("message", e.getMessage());
            }
        }

        // 设置商品封面为上传的第一个文件
        good1.setGoodCover(fileNames.get(0));

        // 调用goodService的updateGood方法，更新商品信息
        int flag = goodService.updateGood(good1);

        // 创建GoodImage对象，并设置相关属性
        GoodImage goodImage = new GoodImage(good1.getGoodId(),fileNames.get(1),fileNames.get(2),fileNames.get(3),fileNames.get(4),fileNames.get(5),fileNames.get(6),fileNames.get(7),fileNames.get(8),fileNames.get(9));

        // 调用goodImageService的addGoodImage方法，添加商品图片信息
        int flag1 = goodImageService.addGoodImage(goodImage);

        // 将文件名列表添加到model中
        model.addAttribute("images", fileNames);

        model.addAttribute("flag",true);
        // 根据更新商品和添加商品图片的结果，返回不同的提示信息和页面
        if (flag == 1 && flag1 == 1) {
            model.addAttribute("message", "商品添加成功");
            return "/admin/goodAddList";
        }else {
            model.addAttribute("message", "商品添加失败");
            return "/admin/goodAddList";
        }
    }

    @PostMapping("/admin/reUpload")
    public String reUpload(@RequestParam(value = "fileUpload") MultipartFile[] fileUpload, Good good,GoodImage goodImage, Model model) throws FileNotFoundException {

        Good good1 = goodService.findGoodById(good.getGoodId());

        GoodImage goodImage1 = goodImageService.findGoodImage(good.getGoodId());

        if (fileUpload == null || fileUpload.length == 0) {
            model.addAttribute("good",good);
            model.addAttribute("goodImage",goodImage1);
            return "admin/goodPages";
        }

        // 创建一个存储文件名的列表
        List<String> fileNames = new ArrayList<String>();

        // 将已存在的商品封面和商品图片添加到文件名列表中
        fileNames.add(0,good1.getGoodCover());
        fileNames.add(1,goodImage1.getImage1());
        fileNames.add(2,goodImage1.getImage2());
        fileNames.add(3,goodImage1.getImage3());
        fileNames.add(4,goodImage1.getImage4());
        fileNames.add(5,goodImage1.getImage5());
        fileNames.add(6,goodImage1.getImage6());
        fileNames.add(7,goodImage1.getImage7());
        fileNames.add(8,goodImage1.getImage8());
        fileNames.add(9,goodImage1.getImage9());

        // 遍历上传的文件数组
        for (int j = 0; j < fileUpload.length; j++) {
            // 获取当前文件对象
            MultipartFile file = fileUpload[j];
            // 获取原始文件名
            String fileName = file.getOriginalFilename();

            if (fileName != null && !fileName.equals("")){
                System.out.println(fileName);
                // 生成唯一的文件名
                fileName = UUID.randomUUID() + "_" +fileName;

                // 构建文件保存路径
                String dirPath1 = dirPath + good1.getGoodId()+"/";
                // 创建文件路径对象
                File filePath = new File(dirPath1);

                // 如果文件路径不存在，则创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                try {
                    // 将文件保存到指定路径
                    file.transferTo(new File(dirPath1+fileName));
                    // 构建文件访问URL
                    String url = "UpLoadFiles/"+good1.getGoodId()+"/"+fileName;
                    // 更新文件名列表
                    fileNames.set(j,url);
                }catch (Exception e){
                    // 输出异常信息
                    e.printStackTrace();
                    // 将异常信息添加到model中
                    model.addAttribute("message", e.getMessage());
                }
            }
        }

        // 设置商品封面为上传的第一个文件
        good.setGoodCover(fileNames.get(0));

        // 调用goodService的updateGood方法，更新商品信息
        int flag = goodService.updateGood(good);

        // 创建GoodImage对象，并设置相关属性
        GoodImage goodImage2 = new GoodImage(goodImage1.getId(),fileNames.get(1),fileNames.get(2),fileNames.get(3),fileNames.get(4),fileNames.get(5),fileNames.get(6),fileNames.get(7),fileNames.get(8),fileNames.get(9));

        // 调用goodImageService的updateGoodImage方法，更新商品图片信息
        int flag1 = goodImageService.updateGoodImage(goodImage2);

        // 将文件名列表添加到model中
        model.addAttribute("good",good);
        model.addAttribute("goodImage",goodImage2);

        model.addAttribute("flag",true);
        // 根据更新商品和更新商品图片的结果，返回不同的提示信息和页面
        if (flag == 1 && flag1 == 1) {
            model.addAttribute("message", "商品修改成功");
        }else {
            model.addAttribute("message", "商品修改失败");
        }
        return "/admin/goodPages";
    }
}