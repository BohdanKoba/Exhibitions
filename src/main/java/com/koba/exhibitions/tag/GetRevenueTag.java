package com.koba.exhibitions.tag;

import com.koba.exhibitions.bean.Exhibition;
import org.apache.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class GetRevenueTag extends TagSupport {
    private static final long serialVersionUID = 7838125001779537088L;

    private static final Logger logger = Logger.getLogger(GetRevenueTag.class);

    private Exhibition exhibition;

    public void setExhibition(Exhibition exhibition) {
        this.exhibition = exhibition;
    }

    @Override
    public int doStartTag() {
        int price = exhibition.getPrice();
        int count = exhibition.getTicketsSold();
        int revenue = price * count;
        try {
            pageContext.getOut().println(revenue);
        } catch (IOException e) {
            logger.error("Can't do tag", e);
        }
        return SKIP_BODY;
    }

}
