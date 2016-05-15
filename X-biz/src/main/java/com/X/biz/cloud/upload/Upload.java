package com.X.biz.cloud.upload;

import com.X.biz.cloud.CloudConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author donahue ldz2012yn@gmail.com
 * @create 2016-05-15 12:24 PM
 **/
public abstract class Upload {
    private static final Logger log = LoggerFactory.getLogger(Upload.class);
    //设置好账号的ACCESS_KEY和SECRET_KEY
    protected String ACCESS_KEY = CloudConfig.ACCESS_KEY;
    protected String SECRET_KEY = CloudConfig.SECRET_KEY;
    //密钥配置
    protected Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    protected String getUpToken() {
        return auth.uploadToken(getBucketName());
    }

    public void service() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(getBytes(), getKey(), getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());

        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    /**
     * 上传的文件bytes
     * @return
     */
    protected abstract byte [] getBytes();

    /**
     * 上传的文件key
     * @return
     */
    protected abstract String getKey();

    protected abstract  String getBucketName();
}
