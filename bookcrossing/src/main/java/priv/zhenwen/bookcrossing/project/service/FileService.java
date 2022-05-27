package priv.zhenwen.bookcrossing.project.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhenwen
 * @date 2022/5/22
 */

public interface FileService {
    String updateBookPdf(MultipartFile file);

    void downloadBookPdf(String url, HttpServletResponse response);
}
