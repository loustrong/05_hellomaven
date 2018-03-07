package com.wistron.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo5 extends SimpleTagSupport {
	
	  /**
     * 定义标签的属性
     */
    private int count;
    
    /**count属性对应的set方法
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    /* 简单标签使用这个方法就可以完成所有的业务逻辑
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     * 重写doTag方法，通过标签的属性控制标签体的执行次数
     */
    @Override
    public void doTag() throws JspException, IOException {
        for (int i = 0; i < count; i++) {
            this.getJspBody().invoke(null);
        }
    }

	
}
