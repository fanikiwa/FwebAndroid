/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-01-14 17:53:03 UTC)
 * on 2015-03-15 at 18:58:57 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.userprofileendpoint.model;

/**
 * Model definition for Userprofile.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the userprofileendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Userprofile extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String confirmationToken;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime createDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String password;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime passwordChangedDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String passwordFailuresSinceLastSuccess;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String passwordSalt;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String passwordVerificationToken;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime passwordVerificationTokenExpirationDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String userId;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getConfirmationToken() {
    return confirmationToken;
  }

  /**
   * @param confirmationToken confirmationToken or {@code null} for none
   */
  public Userprofile setConfirmationToken(java.lang.String confirmationToken) {
    this.confirmationToken = confirmationToken;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getCreateDate() {
    return createDate;
  }

  /**
   * @param createDate createDate or {@code null} for none
   */
  public Userprofile setCreateDate(com.google.api.client.util.DateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPassword() {
    return password;
  }

  /**
   * @param password password or {@code null} for none
   */
  public Userprofile setPassword(java.lang.String password) {
    this.password = password;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getPasswordChangedDate() {
    return passwordChangedDate;
  }

  /**
   * @param passwordChangedDate passwordChangedDate or {@code null} for none
   */
  public Userprofile setPasswordChangedDate(com.google.api.client.util.DateTime passwordChangedDate) {
    this.passwordChangedDate = passwordChangedDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPasswordFailuresSinceLastSuccess() {
    return passwordFailuresSinceLastSuccess;
  }

  /**
   * @param passwordFailuresSinceLastSuccess passwordFailuresSinceLastSuccess or {@code null} for none
   */
  public Userprofile setPasswordFailuresSinceLastSuccess(java.lang.String passwordFailuresSinceLastSuccess) {
    this.passwordFailuresSinceLastSuccess = passwordFailuresSinceLastSuccess;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPasswordSalt() {
    return passwordSalt;
  }

  /**
   * @param passwordSalt passwordSalt or {@code null} for none
   */
  public Userprofile setPasswordSalt(java.lang.String passwordSalt) {
    this.passwordSalt = passwordSalt;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPasswordVerificationToken() {
    return passwordVerificationToken;
  }

  /**
   * @param passwordVerificationToken passwordVerificationToken or {@code null} for none
   */
  public Userprofile setPasswordVerificationToken(java.lang.String passwordVerificationToken) {
    this.passwordVerificationToken = passwordVerificationToken;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getPasswordVerificationTokenExpirationDate() {
    return passwordVerificationTokenExpirationDate;
  }

  /**
   * @param passwordVerificationTokenExpirationDate passwordVerificationTokenExpirationDate or {@code null} for none
   */
  public Userprofile setPasswordVerificationTokenExpirationDate(com.google.api.client.util.DateTime passwordVerificationTokenExpirationDate) {
    this.passwordVerificationTokenExpirationDate = passwordVerificationTokenExpirationDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getUserId() {
    return userId;
  }

  /**
   * @param userId userId or {@code null} for none
   */
  public Userprofile setUserId(java.lang.String userId) {
    this.userId = userId;
    return this;
  }

  @Override
  public Userprofile set(String fieldName, Object value) {
    return (Userprofile) super.set(fieldName, value);
  }

  @Override
  public Userprofile clone() {
    return (Userprofile) super.clone();
  }

}
