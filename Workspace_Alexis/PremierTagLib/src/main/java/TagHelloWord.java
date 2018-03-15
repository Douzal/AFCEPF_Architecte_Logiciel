import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHelloWord extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("Hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY; // pas besoin 
    }
}
