package com.fm.security.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

public class AuthenticationProviderImpl extends DaoAuthenticationProvider
{
   private SaltSource saltSource;

   private PasswordEncoder passwordEncoder;

   @Override
   protected void doAfterPropertiesSet() throws Exception
   {
      super.doAfterPropertiesSet();
      Assert.notNull(getPasswordEncoder());
      Assert.notNull(getSaltSource());
   }

   @Override
   protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                 UsernamePasswordAuthenticationToken authentication)
           throws AuthenticationException
   {
      Object salt = null;

      if (this.saltSource != null)
      {
         salt = this.saltSource.getSalt(userDetails);
      }

      if (authentication.getCredentials() == null)
      {
         logger.debug("Authentication failed: no credentials provided");

         throw new BadCredentialsException(messages.getMessage(
                 "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
      }

      String presentedPassword = authentication.getCredentials().toString();

      String encoded = passwordEncoder.encodePassword(presentedPassword, salt);
      if (!StringUtils.equals(userDetails.getPassword(), encoded))
      {
//      if (!passwordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
         logger.debug("Authentication failed: password does not match stored value");

         throw new BadCredentialsException(messages.getMessage(
                 "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
      }
   }

   public SaltSource getSaltSource()
   {
      return saltSource;
   }

   public void setSaltSource(SaltSource saltSource)
   {
      this.saltSource = saltSource;
   }

   public PasswordEncoder getPasswordEncoder()
   {
      return passwordEncoder;
   }

   public void setPasswordEncoder(PasswordEncoder passwordEncoder)
   {
      this.passwordEncoder = passwordEncoder;
   }
}
