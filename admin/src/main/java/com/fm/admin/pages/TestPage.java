package com.fm.admin.pages;

import com.fm.admin.cmp.breadcrumb.LeagueListBreadcrumb;
import com.fm.core.cmp.breadcrumb.BootstrapBreadcrumbPanel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.lang.Bytes;

import java.io.File;

/**
 * User: pawel.radomski
 * Date: 17.05.13
 * Time: 15:51
 */
public class TestPage extends AdminAbstractPage
{

   private FileUploadField fileUpload;

   private String UPLOAD_FOLDER = "/home/pawel/dupadupa/";

   public TestPage()
   {
      super();
   }

   @Override
   protected void onInitialize()
   {
      super.onInitialize();
      add(new FeedbackPanel("feedback"));

      Form<?> form = new Form<Void>("form")
      {
         @Override
         protected void onSubmit()
         {

            final FileUpload uploadedFile = fileUpload.getFileUpload();
            if (uploadedFile != null)
            {

               // write to a new file
               File newFile = new File(UPLOAD_FOLDER
                       + uploadedFile.getClientFileName());

               if (newFile.exists())
               {
                  newFile.delete();
               }

               try
               {
                  newFile.createNewFile();
                  uploadedFile.writeTo(newFile);

                  info("saved file: " + uploadedFile.getClientFileName());
               }
               catch (Exception e)
               {
                  throw new IllegalStateException("Error");
               }
            }

         }

      };

      // Enable multipart mode (need for uploads file)
      form.setMultiPart(true);

      // max upload size, 10k
      form.setMaxSize(Bytes.kilobytes(10));

      form.add(fileUpload = new FileUploadField("fileUpload"));

      add(form);
   }

   @Override
   protected BootstrapBreadcrumbPanel provideBreadcrumb(String id)
   {
      return new LeagueListBreadcrumb(id);
   }
}
