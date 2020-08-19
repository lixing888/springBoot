package cn.huanzi.qch.springbootmybatis.pojo;

import cn.huanzi.qch.springbootmybatis.dataobject.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by lixing
 * 2019/1/10 15:02
 */
public interface UploadFileRepository extends JpaRepository<UploadFile, String> {

    UploadFile findByFileMd5(String fileMd5);

    void deleteByFileMd5(String fileMd5);
}
