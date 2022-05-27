package priv.zhenwen.bookcrossing.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import priv.zhenwen.bookcrossing.framework.web.domain.AjaxResult;
import priv.zhenwen.bookcrossing.project.service.FileService;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhenwen
 * @date 2022/5/22
 */
@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload_book_pdf")
    public AjaxResult uploadBookPdf(MultipartFile file) {
        return AjaxResult.ok("上传成功！", fileService.updateBookPdf(file));
    }

    @GetMapping("/download")
    public void downloadBookPdf(String url, HttpServletResponse response) {
        fileService.downloadBookPdf(url, response);
    }
}
