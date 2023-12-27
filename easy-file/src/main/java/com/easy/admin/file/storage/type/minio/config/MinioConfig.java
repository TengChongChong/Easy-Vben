package com.easy.admin.file.storage.type.minio.config;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.file.storage.common.type.FileStorageEnum;
import com.easy.admin.file.storage.properties.FileStorageProperties;
import com.easy.admin.file.storage.properties.storage.FileStorageOSSProperties;
import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO 对象存储
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
@Configuration
public class MinioConfig {

    @Bean
    public MinioClient minioClient(FileStorageProperties fileStorageProperties, FileStorageOSSProperties ossProperties) {
        if (!fileStorageProperties.enableOss() || !FileStorageEnum.MINIO.getCode().equals(ossProperties.getType())) {
            return null;
        }
        MinioClient.Builder builder = MinioClient.builder();
        builder.endpoint(ossProperties.getEndpoint());
        if (StrUtil.isNotBlank(ossProperties.getAccessKey()) && StrUtil.isNotBlank(ossProperties.getSecretKey())) {
            builder.credentials(ossProperties.getAccessKey(), ossProperties.getSecretKey());
        }
        return builder.build();
    }
}
