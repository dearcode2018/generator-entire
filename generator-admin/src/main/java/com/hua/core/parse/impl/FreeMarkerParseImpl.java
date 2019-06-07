package com.hua.core.parse.impl;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hua.core.model.GenBeanEntity;
import com.hua.core.model.GenerationEntity;
import com.hua.core.parse.IParse;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FREEMARK 解析
 *
 * @author JueYue
 * @date 2014年12月25日
 */
public class FreeMarkerParseImpl implements IParse {

	protected static final Logger LOGGER = LogManager.getLogger(FreeMarkerParseImpl.class.getName());

    private static final StringTemplateLoader resourceLoader = new StringTemplateLoader();

    private static Configuration cfg;

    static {
        try {
            cfg = new Configuration();
            cfg.setTemplateLoader(resourceLoader);
            cfg.setLocale(Locale.CHINA);
            cfg.setDefaultEncoding("UTF-8");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public List<String> parse(GenerationEntity generationEntity, GenBeanEntity tableEntity, List<String> fileList) {
        List<String> renderList = new ArrayList<String>();
        Template t;
        try {
            for (String file : fileList) {
                resourceLoader.putTemplate(file.hashCode() + "_FTL+KEY", file);
                t = cfg.getTemplate(file.hashCode() + "_FTL+KEY");
                Writer write = new StringWriter();
                Map<String, Object> paramsMap = new HashMap<String, Object>();
                paramsMap.put(IParse.GEN_PARAMS, generationEntity);
                paramsMap.put(IParse.TABLE_DETAIL, tableEntity);
                t.process(paramsMap, write);
                renderList.add(write.toString());
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return renderList;
    }

}
