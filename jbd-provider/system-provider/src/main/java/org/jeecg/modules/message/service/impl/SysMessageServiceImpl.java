package org.jeecg.modules.message.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.jeecg.common.system.base.service.JeecgService;
import org.jeecg.common.system.base.service.impl.JeecgServiceImpl;
import org.jeecg.modules.message.entity.SysMessage;
import org.jeecg.modules.message.mapper.SysMessageMapper;
import org.jeecg.modules.message.service.ISysMessageService;

/**
 * @Description: 消息
 * @Author: jeecg-boot
 * @Date:  2019-04-09
 * @Version: V1.0
 */
@Service(version = "${ksf.service.version}")
public class SysMessageServiceImpl extends JeecgServiceImpl<SysMessageMapper, SysMessage> implements ISysMessageService {

}
