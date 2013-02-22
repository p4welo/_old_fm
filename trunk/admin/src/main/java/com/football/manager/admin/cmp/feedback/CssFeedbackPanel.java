package com.football.manager.admin.cmp.feedback;

/**
 * Created with IntelliJ IDEA.
 * User: Barbara
 * Date: 22.02.13
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class CssFeedbackPanel extends FeedbackPanel
{

    public CssFeedbackPanel(String id)
    {
        super(id);
    }

    public CssFeedbackPanel(String id, IFeedbackMessageFilter filter)
    {
        super(id, filter);
    }

    @Override
    protected String getCSSClass(final FeedbackMessage message)
    {
        String messageLevel = message.getLevelAsString();

        if (messageLevel.equals("INFO"))
        {
            return "alert alert-info";
        }
        else if (messageLevel.equals("ERROR"))
        {
            return "alert alert-error";
        }
        else if (messageLevel.equals("WARNING"))
        {
            return "alert alert-warning";
        }
        else if (messageLevel.equals("SUCCESS"))
        {
            return "alert alert-success";
        }
        else
        {
            return " ";
        }
    }
}