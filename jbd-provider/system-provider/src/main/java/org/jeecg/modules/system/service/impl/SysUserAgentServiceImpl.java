package org.jeecg.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.jeecg.modules.system.entity.SysUserAgent;
import org.jeecg.modules.system.mapper.SysUserAgentMapper;
import org.jeecg.modules.system.service.ISysUserAgentService;

/**
 * @Description: 用户代理人设置
 * @Author: jeecg-boot
 * @Date:  2019-04-17
 * @Version: V1.0
 */
//@Service
@Service(version = "${ksf.service.version}")
public class SysUserAgentServiceImpl extends ServiceImpl<SysUserAgentMapper, SysUserAgent> implements ISysUserAgentService {

}
