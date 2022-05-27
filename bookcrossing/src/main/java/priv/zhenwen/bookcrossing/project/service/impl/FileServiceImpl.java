package priv.zhenwen.bookcrossing.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import priv.zhenwen.bookcrossing.common.constant.Constants;
import priv.zhenwen.bookcrossing.common.util.file.FileUploadUtils;
import priv.zhenwen.bookcrossing.common.util.file.FileUtils;
import priv.zhenwen.bookcrossing.framework.config.ApplicationProperties;
import priv.zhenwen.bookcrossing.project.service.BookService;
import priv.zhenwen.bookcrossing.project.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhenwen
 * @date 2022/5/22
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Autowired
    BookService bookService;

    @Override
    public String updateBookPdf(MultipartFile file) {
        try {
            String filename = FileUploadUtils.upload(file);
            return Constants.DOMAIN_PREFIX + Constants.DOWNLOAD_PREFIX + "?url=" + filename;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void downloadBookPdf(String url, HttpServletResponse response) {
        try {
            String localPath = ApplicationProperties.getProfile();
            String downloadPath = localPath + url;
            String filename = url.substring(12);
            filename = new String(filename.getBytes("GBK"),"ISO-8859-1");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment; fileName=" + filename);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
