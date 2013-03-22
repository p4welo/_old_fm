import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * User: pawel.radomski
 * Date: 22.03.13
 * Time: 14:11
 */
public class PasswordTest
{
   @Test
   public void testSpringEncoder()
   {

      PasswordEncoder encoder = new ShaPasswordEncoder(256);
      String hashedPass = encoder.encodePassword("test", null);

      Assert.assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", hashedPass);
   }
}
