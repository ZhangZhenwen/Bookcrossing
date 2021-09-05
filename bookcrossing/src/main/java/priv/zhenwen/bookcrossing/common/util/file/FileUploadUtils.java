package priv.zhenwen.bookcrossing.common.util.file;

import org.springframework.web.multipart.MultipartFile;
import priv.zhenwen.bookcrossing.common.constant.Constants;
import priv.zhenwen.bookcrossing.common.util.Md5Utils;
import priv.zhenwen.bookcrossing.common.util.StringUtils;
import priv.zhenwen.bookcrossing.framework.config.ApplicationConfig;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传工具类
 *
 * @author zhenwen
 * @date 2020/11/20
 */

public class FileUploadUtils {

    private static String defaultBaseDir = ApplicationConfig.getProfile();

    private static int counter = 0;

    public static String getDefaultBaseDir() {
        return defaultBaseDir;
    }

    public static void setDefaultBaseDir(String defaultBaseDir) {
        FileUploadUtils.defaultBaseDir = defaultBaseDir;
    }

    /**
     * 以默认配置进行文件上传
     *
     * @param file 上传的文件
     * @return 文件名称
     * @throws IOException io
     */
    public static String upload(MultipartFile file) throws IOException
    {
        try
        {
            return upload(getDefaultBaseDir(), file, FileTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        }
        catch (Exception e)
        {
            throw new IOException(e);
        }
    }

    /**
     * 根据文件路径上传
     *
     * @param baseDir 相对应用的基目录
     * @param file 上传的文件
     * @return 文件名称
     * @throws IOException e
     */
    public static String upload(String baseDir, MultipartFile file) throws IOException
    {
        try
        {
            return upload(baseDir, file, FileTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        }
        catch (Exception e)
        {
            throw new IOException(e);
        }
    }

    /**
     * 文件上传
     *
     * @param baseDir 相对应用的基目录
     * @param file 上传的文件
     * @return 返回上传成功的文件名
     * @throws IOException io
     */
    public static String upload(String baseDir, MultipartFile file, String[] allowedExtension)
            throws IOException
    {
        String fileName = extractFilename(file);

        File desc = getAbsoluteFile(baseDir, fileName);
        file.transferTo(desc);
        return getPathFileName(baseDir, fileName);
    }

    /**
     * 编码文件名
     */
    public static String extractFilename(MultipartFile file)
    {
        String fileName = file.getOriginalFilename();
        String extension = FileUtils.getExtension(file);
        fileName = DateUtils.datePath() + "/" + encodingFilename(fileName) + "." + extension;
        return fileName;
    }

    /**
     * 获取文件
     * @param uploadDir 上传文件夹
     * @param fileName 文件名
     * @return 文件
     * @throws IOException
     */
    private static File getAbsoluteFile(String uploadDir, String fileName) throws IOException
    {
        File file = new File(uploadDir + File.separator + fileName);

        if (!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        if (!file.exists())
        {
            file.createNewFile();
        }
        return file;
    }

    private static String getPathFileName(String uploadDir, String fileName)
    {
        int dirLastIndex = ApplicationConfig.getProfile().length() + 1;
        String currentDir = StringUtils.substring(uploadDir, dirLastIndex);
        return Constants.RESOURCE_PREFIX + "/" + currentDir + "/" + fileName;
    }

    /**
     * 编码文件名
     */
    private static String encodingFilename(String fileName)
    {
        fileName = fileName.replace("_", " ");
        fileName = Md5Utils.hash(fileName + System.nanoTime() + counter++);
        return fileName;
    }


}
