package org.jeecg.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.jeecg.modules.system.entity.SysFillRule;
import org.jeecg.modules.system.mapper.SysFillRuleMapper;
import org.jeecg.modules.system.service.ISysFillRuleService;

/**
 * @Description: 填值规则
 * @Author: jeecg-boot
 * @Date: 2019-11-07
 * @Version: V1.0
 */
//@Service("sysFillRuleServiceImpl")
@Service(version = "${ksf.service.version}")
public class SysFillRuleServiceImpl extends ServiceImpl<SysFillRuleMapper, SysFillRule> implements ISysFillRuleService {

}
