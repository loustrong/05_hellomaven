package com.wistron.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

/**
 * Created by want on 2016/12/9.
 */
public class ViewIPTag implements Tag {

    private PageContext pc = null;

    private String name;
    private String value;


    public String getName() {
        System.out.println("【getName()】");
        return name;
    }

    public String getValue() {
        System.out.println("【getValue()】");
        return value;
    }


    public void setName(String name) {
        System.out.println("【setName()】name = " + name);
        this.name = name;
    }

    public void setValue(String value) {
        System.out.println("【setValue()】value = " + value);
        this.value = value;
    }

    /**
     * JSP引擎实例化标签处理器后，
     * 将调用setPageContext方法将JSP页面的pageContext对象传递给标签处理器，
     * 标签处理器以后可以通过这个pageContext对象与JSP页面进行通信。
     *
     * @param pageContext
     */
    @Override
    public void setPageContext(PageContext pageContext) {
        System.out.println("【setPageContext()】pageContext = " + pageContext);
        this.pc = pageContext;
    }

    /**
     * setPageContext方法执行完后，
     * WEB容器接着调用的setParent方法将当前标签的父标签传递给当前标签处理器，
     * 如果当前标签没有父标签，
     * 则传递给setParent方法的参数值为null。
     *
     * @param tag
     */
    @Override
    public void setParent(Tag tag) {
        System.out.println("【setParent()】");
        System.out.println("【setParent()】tag = " + tag);
    }

    @Override
    public Tag getParent() {
        System.out.println("【getParent()】");
        return null;
    }

    /**
     * doStartTag()，
     * 调用了setPageContext方法和setParent方法之后，
     * WEB容器执行到自定义标签的开始标记时，
     * 就会调用标签处理器的doStartTag方法。
     *
     * @return
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        System.out.println("【doStartTag()】");
        try {
            String ip = this.pc.getRequest().getRemoteAddr();

            //向页面输出
            this.pc.getOut().write("<h4>当前IP：" + ip + "</h4>");

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Eval_Body_Include -- 开始标签之后的标签体需要执行
        //Skip_Body -- 开始标签之后的标签体不需要执行

        return 5;
    }

    /**
     * WEB容器执行完自定义标签的标签体后，
     * 就会接着去执行自定义标签的结束标记，
     * 此时，WEB容器会去调用标签处理器的doEndTag方法。
     *
     * @return
     * @throws JspException
     */
    @Override
    public int doEndTag() throws JspException {
        System.out.println("【doEndTag()】");
        //EVAL_PAGE -- 结束标签之后的剩余页面需要去执行
        //SKIP_PAGE -- 结束标签之后的剩余页面不要去执行
//        int SKIP_BODY = 0;
//        int EVAL_BODY_INCLUDE = 1;
//        int SKIP_PAGE = 5;
//        int EVAL_PAGE = 6;
        String value = this.getValue();
        if (value == null) {
            throw new RuntimeException("无效的value值");
        }
        try {
            this.pc.getOut().write("<ul>");
            switch (value) {
                case "1":
                    this.pc.getOut().write("<li>" + this.getName() + "</li>");
                    break;
                case "2":
                    this.pc.getOut().write("<li>" + this.getName() + "</li>");
                    break;
                case "3":
                    this.pc.getOut().write("<li>" + this.getName() + "</li>");
                    break;
                default:
                    this.pc.getOut().write("<li>不在范围中的值</li>");
            }
            this.pc.getOut().write("</ul>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 6;
    }

    /**
     * 通常WEB容器执行完自定义标签后，
     * 标签处理器会驻留在内存中，
     * 为其它请求服务器，
     * 直至停止web应用时，
     * web容器才会调用release方法。
     */
    @Override
    public void release() {
        System.out.println("【release()】");
    }
}
