package com.zoe.controller;

import com.zoe.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class transactionSheetController {

    @PostMapping("/upload")
    public Result uploadSheet(String name, Integer type, MultipartFile image) throws IOException {
        log.info("upload sheet: {}-{}, {}", type, name, image);
        String fileName = image.getOriginalFilename();
        fileName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID().toString() + fileName;
        log.info("upload file: {}", fileName);
        image.transferTo(new File("E:\\dbtest\\" + fileName));
        return Result.success();
    }
}
