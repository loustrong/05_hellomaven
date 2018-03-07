package com.wistron.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {
	
	 /**
     * test属性，该属性值为true时，输出标签体中的内容
     */
    private boolean test;
    
    @Override
    public void doTag() throws JspException, IOException {
        //获取标签的父标签
        ChooseTag parentTag = (ChooseTag) this.getParent();
        if (test == true && parentTag.isExecute() == false) {
            //输出标签体中的内容
            this.getJspBody().invoke(null);
            //将父标签的isExecute属性设置为true，告诉父标签，我(when标签)已经执行过了
            parentTag.setExecute(true);
        }
    }

    public void setTest(boolean test) {
        this.test = test;
    }

}
