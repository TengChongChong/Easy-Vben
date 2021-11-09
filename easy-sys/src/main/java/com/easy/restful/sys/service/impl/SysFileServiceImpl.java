package com.easy.restful.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.dao.SysFileMapper;
import com.easy.restful.sys.model.SysFile;
import com.easy.restful.sys.service.SysFileService;
import com.easy.restful.util.file.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * 文件
 *
 * @author 系统管理员
 * @date 2021-02-21
 */
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

    @Override
    public List<SysFile> select(String pId, String type) {
        QueryWrapper<SysFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("p_id", pId).eq("type", type).orderByAsc("order_no");
        return getBaseMapper().select(queryWrapper);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean delete(String pId, String type) {
        List<SysFile> sysFileList = select(pId, type);
        QueryWrapper<SysFile> remove = new QueryWrapper<>();
        remove.eq("p_id", pId).eq("type", type);
        boolean isSuccess = remove(remove);
        if (isSuccess) {
            sysFileList.forEach(sysFile -> {
                File file = new File(sysFile.getPath());
                if (file.exists() && !file.delete()) {
                    throw new EasyException("文件删除失败[" + file.getPath() + "]");
                }
            });
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public List<SysFile> saveData(List<SysFile> object) {
        object.forEach(sysFile -> {
            File file = new File(sysFile.getPath());
            if (!file.exists()) {
                throw new EasyException("保存文件失败，文件不存在[" + sysFile.getPath() + "]");
            }
            sysFile.setSize(file.length());
            sysFile.setName(file.getName());
            // 检查文件是否在临时目录
            if (FileUtil.inTemporaryPath(sysFile.getPath())) {
                sysFile.setPath(FileUtil.moveToFormal(sysFile.getPath()));
            }
        });
        saveBatch(object);
        return object;
    }
}