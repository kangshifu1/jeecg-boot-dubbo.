package org.jeecg.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.jeecg.modules.system.entity.SysPosition;
import org.jeecg.modules.system.mapper.SysPositionMapper;
import org.jeecg.modules.system.service.ISysPositionService;

/**
 * @Description: 职务表
 * @Author: jeecg-boot
 * @Date: 2019-09-19
 * @Version: V1.0
 */
//@Service
@Service(version = "${ksf.service.version}")
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements ISysPositionService {

}
