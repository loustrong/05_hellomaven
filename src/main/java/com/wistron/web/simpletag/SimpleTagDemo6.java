package com.wistron.web.simpletag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo6 extends SimpleTagSupport {
	
	 /**
     * 定义标签的属性
     */
    private Date date;
    
    /**date属性对应的set方法
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /* 简单标签使用这个方法就可以完成所有的业务逻辑
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     * 重写doTag方法，输出date属性值
     */
    @Override
    public void doTag() throws JspException, IOException {
        this.getJspContext().getOut().write(date.toLocaleString());
    }

}
