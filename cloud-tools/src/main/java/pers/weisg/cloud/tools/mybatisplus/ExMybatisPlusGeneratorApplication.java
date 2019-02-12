package pers.weisg.cloud.tools.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 功能描述 mybatisplus自动生成代码
 * author WEISANGENG
 * date 2019/2/10
 */
public class ExMybatisPlusGeneratorApplication {


    public static void main(String[] args) throws IOException {
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        Properties prop = getProperties();
        String projectPath = new File("").getCanonicalPath();
        String outputDir = prop.getProperty("output_path");
        final String viewOutputDir = outputDir + "view/";
        ExAutoGenerator mpg = new ExAutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(outputDir);
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(true);
        // XML 二级缓存
        globalConfig.setEnableCache(false);
        // XML ResultMap
        globalConfig.setBaseResultMap(true);
        // XML columList
        globalConfig.setBaseColumnList(true);
        globalConfig.setAuthor(prop.getProperty("author"));

        if (!serviceNameStartWithI) {
            globalConfig.setServiceName("%sService");
        }

        mpg.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        if (DbType.MYSQL.getDb().equalsIgnoreCase(prop.getProperty("db_type"))) {
            dsc.setDbType(DbType.MYSQL);
        } else if (DbType.ORACLE.getDb().equalsIgnoreCase(prop.getProperty("db_type"))) {
            dsc.setDbType(DbType.ORACLE);
        } else {
            dsc.setDbType(DbType.MYSQL);
        }
        dsc.setDriverName(prop.getProperty("db_driver_name"));
        dsc.setUsername(prop.getProperty("db_user_name"));
        dsc.setPassword(prop.getProperty("db_password"));
        dsc.setUrl(prop.getProperty("db_url"));
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setSuperControllerClass(prop.getProperty("super_controller_class"));
        strategy.setInclude(scanner("表名"));
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);
        //表前缀
        strategy.setTablePrefix(new String[] { "t_" });



        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(prop.getProperty("package_parent"));
        pc.setController("controller");
        pc.setModuleName(prop.getProperty("module_name"));
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);
        TemplateConfig tc = new TemplateConfig();
        tc.setService("/templates/service.java");
        tc.setServiceImpl("/templates/serviceImpl.java");
        mpg.setTemplate(tc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
//                Map map = this.getMap();
//                if(map == null) {
//                    map = new HashMap();
//                }
//                map.put("moduleName","sys");
//                this.setMap(map);
            }
        };
        // 生成的模版路径，不存在时需要先新建
        File viewDir = new File(viewOutputDir);
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/listvue.vue.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getGeneratorViewPath(viewOutputDir, tableInfo, ".vue");
            }
        });
        focList.add(new FileOutConfig("/templates/controllerApi.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outputDir + pc.getParent().replace(".", "/") + "/" + pc.getController() + "/" + tableInfo.getControllerName() + "Api.java";
            }
        });
        cfg.setFileOutConfigList(focList);

        mpg.setCfg(cfg);

        //生成controller相关
        mpg.execute();
    }

    /**
     * 获取配置文件
     *
     * @return 配置Props
     */
    private static Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("/config/mybatis-plus.properties");
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * 页面生成的文件名
     */
    private static String getGeneratorViewPath(String viewOutputDir, TableInfo tableInfo, String suffixPath) {
        String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
        String path = viewOutputDir + "/" + name + "/index" + suffixPath;
        File viewDir = new File(path).getParentFile();
        if (!viewDir.exists()) {
            viewDir.mkdirs();
        }
        return path;
    }


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
