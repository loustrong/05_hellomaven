package com.wistron.web.simpletag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author gacl
 * 开发if标签
 */
public class IFTag extends SimpleTagSupport {

    /**
     * if标签的test属性
     */
    private boolean test;
    
    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
            this.getJspBody().invoke(null);
        }
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}