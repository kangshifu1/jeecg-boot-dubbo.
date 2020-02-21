package org.jeecg.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.Service;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.modules.system.entity.SysLog;
import org.jeecg.modules.system.mapper.SysLogMapper;
import org.jeecg.modules.system.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @Author zhangweijian
 * @since 2018-12-26
 */
//@Service
@Service(version = "${ksf.service.version}")
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

	@Resource
	private SysLogMapper sysLogMapper;
	
	/**
	 * @功能：清空所有日志记录
	 */
	@Override
	public void removeAll() {
		sysLogMapper.removeAll();
	}

	@Override
	public Long findTotalVisitCount() {
		return sysLogMapper.findTotalVisitCount();
	}

	//update-begin--Author:zhangweijian  Date:20190428 for：传入开始时间，结束时间参数
	@Override
	public Long findTodayVisitCount(Date dayStart, Date dayEnd) {
		return sysLogMapper.findTodayVisitCount(dayStart,dayEnd);
	}

	@Override
	public Long findTodayIp(Date dayStart, Date dayEnd) {
		return sysLogMapper.findTodayIp(dayStart,dayEnd);
	}
	//update-end--Author:zhangweijian  Date:20190428 for：传入开始时间，结束时间参数

	@Override
	public List<Map<String,Object>> findVisitCount(Date dayStart, Date dayEnd) {
		try {
			DataSource dataSource = SpringContextUtils.getApplicationContext().getBean(DataSource.class);
			String dbType =  getDatabaseTypeByDataSource(dataSource);
			return sysLogMapper.findVisitCount(dayStart, dayEnd,dbType);
		} catch (SQLException e) {
		}
		return null;
	}
	public static String DB_TYPE = "";
	public static final String DB_TYPE_MYSQL="MYSQL";
	public static final String DB_TYPE_ORACLE="ORACLE";
	public static final String DB_TYPE_POSTGRESQL="POSTGRESQL";
	public static final String DB_TYPE_SQLSERVER="SQLSERVER";
	/**
	 * 获取数据库类型
	 * @param dataSource
	 * @return
	 * @throws SQLException
	 */
	private String getDatabaseTypeByDataSource(DataSource dataSource) throws SQLException{
		if("".equals(DB_TYPE)) {
			Connection connection = dataSource.getConnection();
			try {
				DatabaseMetaData md = connection.getMetaData();
				String dbType = md.getDatabaseProductName().toLowerCase();
				if(dbType.indexOf("mysql")>=0) {
					DB_TYPE = DB_TYPE_MYSQL;
				}else if(dbType.indexOf("oracle")>=0) {
					DB_TYPE = DB_TYPE_ORACLE;
				}else if(dbType.indexOf("sqlserver")>=0||dbType.indexOf("sql server")>=0) {
					DB_TYPE = DB_TYPE_SQLSERVER;
				}else if(dbType.indexOf("postgresql")>=0) {
					DB_TYPE = DB_TYPE_POSTGRESQL;
				}else {
					throw new Exception("数据库类型:["+dbType+"]不识别!");
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}finally {
				connection.close();
			}
		}
		return DB_TYPE;

	}

}
