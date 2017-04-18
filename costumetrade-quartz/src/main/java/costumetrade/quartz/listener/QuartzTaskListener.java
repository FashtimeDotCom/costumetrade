/*package costumetrade.quartz.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import costumetrade.common.context.ApplicationContextUtil;
import costumetrade.common.util.QuartzUtil;
import costumetrade.common.util.StringUtil;
import costumetrade.common.Enum.EnumAutoTask;

import java.util.HashMap;
import java.util.Map;

import org.quartz.SchedulerException;

import costumetrade.quartz.job.AutoDownloadMaterialsJob;
import costumetrade.quartz.job.AutoBankTaskJob;
import costumetrade.quartz.job.RemoveJobByCode;
import costumetrade.bank.domain.BankDownloadMaterialsTaskConfig;
import costumetrade.bank.service.IBankDownloadMaterialsTaskConfigService;

*//**
 * 定时任务监听器
 *//*
public class QuartzTaskListener implements ServletContextListener {
	
	private static final Logger logger = LoggerFactory.getLogger(QuartzTaskListener.class);
	
	private IBankDownloadMaterialsTaskConfigService downloadTaskConfigService;

    public void contextDestroyed(ServletContextEvent arg0) {

    }

    public void contextInitialized(ServletContextEvent sce) {
    	logger.info("定时触发任务开始");
        try {
            //定时自动下载材料
            addAutoTaskJob(EnumAutoTask.AUTO_DOWN_FILE_TASK);
            
             //银行任务,用户查询任务信息记录是否被更改
            addAutoTaskJob(EnumAutoTask.AUTOI_BANK_TASK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("定时触发任务错误:" + e.getMessage());
        }
    }
    
    *//**
     * 添加定时任务
     * @throws SchedulerException
     * @throws Exception
     *//*
    public void addAutoTaskJob(EnumAutoTask autoTask) throws SchedulerException, Exception {
    	String cronExpression = "0 * * * * ?";     //触发器时间设定
        Map<Object, Object> params = new HashMap<Object, Object>();
        RemoveJobByCode.removeAutoTaskJob(autoTask); //移除定时任务
        //增加相应的任务
        if(autoTask.equals(EnumAutoTask.AUTOI_BANK_TASK)){
        	cronExpression = "0 * * * * ?"; //每分钟触发
        	QuartzUtil.addJob(autoTask.getKey(), new AutoBankTaskJob(), cronExpression, params);
        }else if(autoTask.equals(EnumAutoTask.AUTO_DOWN_FILE_TASK)){
            BankDownloadMaterialsTaskConfig task = getDownloadTaskConfigService().selectByTaskCode(EnumAutoTask.AUTO_DOWN_FILE_TASK.getKey());
            if(task!=null&&task.getIsStart()==1){
                //每{0}分钟执行一次
                cronExpression="0 0/{0} * * * ?";
                cronExpression = StringUtil.format(cronExpression, task.getStartInterval());
                QuartzUtil.addJob(autoTask.getKey(), new AutoDownloadMaterialsJob(), cronExpression, params);
            }
        }
    }

    public IBankDownloadMaterialsTaskConfigService getDownloadTaskConfigService() {
        if(downloadTaskConfigService==null){
            downloadTaskConfigService = ApplicationContextUtil.getBean(IBankDownloadMaterialsTaskConfigService.class);
        }
        return downloadTaskConfigService;
    }

}
*/