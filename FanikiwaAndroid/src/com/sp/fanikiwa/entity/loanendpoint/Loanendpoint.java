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
 * on 2015-03-15 at 18:49:03 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.loanendpoint;

/**
 * Service definition for Loanendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link LoanendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Loanendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the loanendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://fanikiwaweb.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "loanendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Loanendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Loanendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getLoanByID".
   *
   * This request holds the parameters needed by the loanendpoint server.  After setting any optional
   * parameters, call the {@link GetLoanByID#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetLoanByID getLoanByID(java.lang.Long id) throws java.io.IOException {
    GetLoanByID result = new GetLoanByID(id);
    initialize(result);
    return result;
  }

  public class GetLoanByID extends LoanendpointRequest<com.sp.fanikiwa.entity.loanendpoint.model.Loan> {

    private static final String REST_PATH = "loan/{id}";

    /**
     * Create a request for the method "getLoanByID".
     *
     * This request holds the parameters needed by the the loanendpoint server.  After setting any
     * optional parameters, call the {@link GetLoanByID#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetLoanByID#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetLoanByID(java.lang.Long id) {
      super(Loanendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.loanendpoint.model.Loan.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetLoanByID setAlt(java.lang.String alt) {
      return (GetLoanByID) super.setAlt(alt);
    }

    @Override
    public GetLoanByID setFields(java.lang.String fields) {
      return (GetLoanByID) super.setFields(fields);
    }

    @Override
    public GetLoanByID setKey(java.lang.String key) {
      return (GetLoanByID) super.setKey(key);
    }

    @Override
    public GetLoanByID setOauthToken(java.lang.String oauthToken) {
      return (GetLoanByID) super.setOauthToken(oauthToken);
    }

    @Override
    public GetLoanByID setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetLoanByID) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetLoanByID setQuotaUser(java.lang.String quotaUser) {
      return (GetLoanByID) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetLoanByID setUserIp(java.lang.String userIp) {
      return (GetLoanByID) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetLoanByID setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetLoanByID set(String parameterName, Object value) {
      return (GetLoanByID) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertLoan".
   *
   * This request holds the parameters needed by the loanendpoint server.  After setting any optional
   * parameters, call the {@link InsertLoan#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.loanendpoint.model.Loan}
   * @return the request
   */
  public InsertLoan insertLoan(com.sp.fanikiwa.entity.loanendpoint.model.Loan content) throws java.io.IOException {
    InsertLoan result = new InsertLoan(content);
    initialize(result);
    return result;
  }

  public class InsertLoan extends LoanendpointRequest<com.sp.fanikiwa.entity.loanendpoint.model.Loan> {

    private static final String REST_PATH = "loan";

    /**
     * Create a request for the method "insertLoan".
     *
     * This request holds the parameters needed by the the loanendpoint server.  After setting any
     * optional parameters, call the {@link InsertLoan#execute()} method to invoke the remote
     * operation. <p> {@link
     * InsertLoan#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.loanendpoint.model.Loan}
     * @since 1.13
     */
    protected InsertLoan(com.sp.fanikiwa.entity.loanendpoint.model.Loan content) {
      super(Loanendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.loanendpoint.model.Loan.class);
    }

    @Override
    public InsertLoan setAlt(java.lang.String alt) {
      return (InsertLoan) super.setAlt(alt);
    }

    @Override
    public InsertLoan setFields(java.lang.String fields) {
      return (InsertLoan) super.setFields(fields);
    }

    @Override
    public InsertLoan setKey(java.lang.String key) {
      return (InsertLoan) super.setKey(key);
    }

    @Override
    public InsertLoan setOauthToken(java.lang.String oauthToken) {
      return (InsertLoan) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertLoan setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertLoan) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertLoan setQuotaUser(java.lang.String quotaUser) {
      return (InsertLoan) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertLoan setUserIp(java.lang.String userIp) {
      return (InsertLoan) super.setUserIp(userIp);
    }

    @Override
    public InsertLoan set(String parameterName, Object value) {
      return (InsertLoan) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listLoan".
   *
   * This request holds the parameters needed by the loanendpoint server.  After setting any optional
   * parameters, call the {@link ListLoan#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public ListLoan listLoan() throws java.io.IOException {
    ListLoan result = new ListLoan();
    initialize(result);
    return result;
  }

  public class ListLoan extends LoanendpointRequest<com.sp.fanikiwa.entity.loanendpoint.model.CollectionResponseLoan> {

    private static final String REST_PATH = "loan";

    /**
     * Create a request for the method "listLoan".
     *
     * This request holds the parameters needed by the the loanendpoint server.  After setting any
     * optional parameters, call the {@link ListLoan#execute()} method to invoke the remote operation.
     * <p> {@link
     * ListLoan#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListLoan() {
      super(Loanendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.loanendpoint.model.CollectionResponseLoan.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListLoan setAlt(java.lang.String alt) {
      return (ListLoan) super.setAlt(alt);
    }

    @Override
    public ListLoan setFields(java.lang.String fields) {
      return (ListLoan) super.setFields(fields);
    }

    @Override
    public ListLoan setKey(java.lang.String key) {
      return (ListLoan) super.setKey(key);
    }

    @Override
    public ListLoan setOauthToken(java.lang.String oauthToken) {
      return (ListLoan) super.setOauthToken(oauthToken);
    }

    @Override
    public ListLoan setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListLoan) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListLoan setQuotaUser(java.lang.String quotaUser) {
      return (ListLoan) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListLoan setUserIp(java.lang.String userIp) {
      return (ListLoan) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListLoan setCount(java.lang.Integer count) {
      this.count = count;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListLoan setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListLoan set(String parameterName, Object value) {
      return (ListLoan) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeLoan".
   *
   * This request holds the parameters needed by the loanendpoint server.  After setting any optional
   * parameters, call the {@link RemoveLoan#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveLoan removeLoan(java.lang.Long id) throws java.io.IOException {
    RemoveLoan result = new RemoveLoan(id);
    initialize(result);
    return result;
  }

  public class RemoveLoan extends LoanendpointRequest<Void> {

    private static final String REST_PATH = "loan/{id}";

    /**
     * Create a request for the method "removeLoan".
     *
     * This request holds the parameters needed by the the loanendpoint server.  After setting any
     * optional parameters, call the {@link RemoveLoan#execute()} method to invoke the remote
     * operation. <p> {@link
     * RemoveLoan#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveLoan(java.lang.Long id) {
      super(Loanendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveLoan setAlt(java.lang.String alt) {
      return (RemoveLoan) super.setAlt(alt);
    }

    @Override
    public RemoveLoan setFields(java.lang.String fields) {
      return (RemoveLoan) super.setFields(fields);
    }

    @Override
    public RemoveLoan setKey(java.lang.String key) {
      return (RemoveLoan) super.setKey(key);
    }

    @Override
    public RemoveLoan setOauthToken(java.lang.String oauthToken) {
      return (RemoveLoan) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveLoan setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveLoan) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveLoan setQuotaUser(java.lang.String quotaUser) {
      return (RemoveLoan) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveLoan setUserIp(java.lang.String userIp) {
      return (RemoveLoan) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveLoan setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveLoan set(String parameterName, Object value) {
      return (RemoveLoan) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateLoan".
   *
   * This request holds the parameters needed by the loanendpoint server.  After setting any optional
   * parameters, call the {@link UpdateLoan#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.loanendpoint.model.Loan}
   * @return the request
   */
  public UpdateLoan updateLoan(com.sp.fanikiwa.entity.loanendpoint.model.Loan content) throws java.io.IOException {
    UpdateLoan result = new UpdateLoan(content);
    initialize(result);
    return result;
  }

  public class UpdateLoan extends LoanendpointRequest<com.sp.fanikiwa.entity.loanendpoint.model.Loan> {

    private static final String REST_PATH = "loan";

    /**
     * Create a request for the method "updateLoan".
     *
     * This request holds the parameters needed by the the loanendpoint server.  After setting any
     * optional parameters, call the {@link UpdateLoan#execute()} method to invoke the remote
     * operation. <p> {@link
     * UpdateLoan#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.loanendpoint.model.Loan}
     * @since 1.13
     */
    protected UpdateLoan(com.sp.fanikiwa.entity.loanendpoint.model.Loan content) {
      super(Loanendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.loanendpoint.model.Loan.class);
    }

    @Override
    public UpdateLoan setAlt(java.lang.String alt) {
      return (UpdateLoan) super.setAlt(alt);
    }

    @Override
    public UpdateLoan setFields(java.lang.String fields) {
      return (UpdateLoan) super.setFields(fields);
    }

    @Override
    public UpdateLoan setKey(java.lang.String key) {
      return (UpdateLoan) super.setKey(key);
    }

    @Override
    public UpdateLoan setOauthToken(java.lang.String oauthToken) {
      return (UpdateLoan) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateLoan setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateLoan) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateLoan setQuotaUser(java.lang.String quotaUser) {
      return (UpdateLoan) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateLoan setUserIp(java.lang.String userIp) {
      return (UpdateLoan) super.setUserIp(userIp);
    }

    @Override
    public UpdateLoan set(String parameterName, Object value) {
      return (UpdateLoan) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Loanendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Loanendpoint}. */
    @Override
    public Loanendpoint build() {
      return new Loanendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link LoanendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setLoanendpointRequestInitializer(
        LoanendpointRequestInitializer loanendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(loanendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
