package pers.weisg.cloud.tools.mybatisplus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述 代码生成器
 * author WEISANGENG
 * date 2019/2/10
 */
public class ExAutoGenerator extends AutoGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ExAutoGenerator.class);

    @Override
    public void execute() {
        logger.debug("==========================准备生成文件...==========================");
        if (null == this.config) {
            this.config = new ConfigBuilder(this.getPackageInfo(), this.getDataSource(), this.getStrategy(), this.getTemplate(), this.getGlobalConfig());
            if (null != this.injectionConfig) {
                this.injectionConfig.setConfig(this.config);
            }
        }

        if (null == this.getTemplateEngine()) {
            this.setTemplateEngine( new VelocityTemplateEngine());
        }
        this.getTemplateEngine().init(this.pretreatmentConfigBuilder(this.config));
        this.getCfg().getConfig().getTableInfoList().stream().forEach(t -> t.setServiceName(t.getServiceName().replace("Service","Service")));
        this.getCfg().getConfig().getTableInfoList().stream().forEach(t -> t.setServiceImplName(t.getServiceImplName().replace("Service","Service")));

        this.getTemplateEngine().mkdirs().batchOutput().open();
        logger.debug("==========================文件生成完成！！！==========================");
    }
}
