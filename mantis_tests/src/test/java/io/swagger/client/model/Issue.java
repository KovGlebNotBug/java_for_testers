/*
 * MantisBT REST API
 * For the sandbox to work, MantisBT must be hosted at the root folder of the host. For example: http://mantishost/ rather http://host/mantisbt.  If that is not the case, then create a host alias to map it as such or edit swagger.json to change basePath to include the mantisbt folder name.
 *
 * OpenAPI spec version: 1.1.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.AccountRef;
import io.swagger.client.model.Identifier;
import io.swagger.client.model.UploadableFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Issue
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-02-11T23:01:10.294+03:00")
public class Issue {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("project")
  private Identifier project = null;

  @SerializedName("category")
  private Identifier category = null;

  @SerializedName("priority")
  private Identifier priority = null;

  @SerializedName("severity")
  private Identifier severity = null;

  @SerializedName("reproducibility")
  private Identifier reproducibility = null;

  @SerializedName("version")
  private Identifier version = null;

  @SerializedName("os")
  private String os = null;

  @SerializedName("os_build")
  private String osBuild = null;

  @SerializedName("platform")
  private String platform = null;

  @SerializedName("summary")
  private String summary = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("steps_to_reproduce")
  private String stepsToReproduce = null;

  @SerializedName("additional_information")
  private String additionalInformation = null;

  @SerializedName("reporter")
  private AccountRef reporter = null;

  @SerializedName("handler")
  private AccountRef handler = null;

  @SerializedName("files")
  private List<UploadableFile> files = null;

  public Issue id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Issue project(Identifier project) {
    this.project = project;
    return this;
  }

   /**
   * Get project
   * @return project
  **/
  @ApiModelProperty(required = true, value = "")
  public Identifier getProject() {
    return project;
  }

  public void setProject(Identifier project) {
    this.project = project;
  }

  public Issue category(Identifier category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  public Identifier getCategory() {
    return category;
  }

  public void setCategory(Identifier category) {
    this.category = category;
  }

  public Issue priority(Identifier priority) {
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @ApiModelProperty(value = "")
  public Identifier getPriority() {
    return priority;
  }

  public void setPriority(Identifier priority) {
    this.priority = priority;
  }

  public Issue severity(Identifier severity) {
    this.severity = severity;
    return this;
  }

   /**
   * Get severity
   * @return severity
  **/
  @ApiModelProperty(value = "")
  public Identifier getSeverity() {
    return severity;
  }

  public void setSeverity(Identifier severity) {
    this.severity = severity;
  }

  public Issue reproducibility(Identifier reproducibility) {
    this.reproducibility = reproducibility;
    return this;
  }

   /**
   * Get reproducibility
   * @return reproducibility
  **/
  @ApiModelProperty(value = "")
  public Identifier getReproducibility() {
    return reproducibility;
  }

  public void setReproducibility(Identifier reproducibility) {
    this.reproducibility = reproducibility;
  }

  public Issue version(Identifier version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public Identifier getVersion() {
    return version;
  }

  public void setVersion(Identifier version) {
    this.version = version;
  }

  public Issue os(String os) {
    this.os = os;
    return this;
  }

   /**
   * Get os
   * @return os
  **/
  @ApiModelProperty(value = "")
  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public Issue osBuild(String osBuild) {
    this.osBuild = osBuild;
    return this;
  }

   /**
   * Get osBuild
   * @return osBuild
  **/
  @ApiModelProperty(value = "")
  public String getOsBuild() {
    return osBuild;
  }

  public void setOsBuild(String osBuild) {
    this.osBuild = osBuild;
  }

  public Issue platform(String platform) {
    this.platform = platform;
    return this;
  }

   /**
   * Get platform
   * @return platform
  **/
  @ApiModelProperty(value = "")
  public String getPlatform() {
    return platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
  }

  public Issue summary(String summary) {
    this.summary = summary;
    return this;
  }

   /**
   * Get summary
   * @return summary
  **/
  @ApiModelProperty(required = true, value = "")
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Issue description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Issue stepsToReproduce(String stepsToReproduce) {
    this.stepsToReproduce = stepsToReproduce;
    return this;
  }

   /**
   * Get stepsToReproduce
   * @return stepsToReproduce
  **/
  @ApiModelProperty(value = "")
  public String getStepsToReproduce() {
    return stepsToReproduce;
  }

  public void setStepsToReproduce(String stepsToReproduce) {
    this.stepsToReproduce = stepsToReproduce;
  }

  public Issue additionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
    return this;
  }

   /**
   * Get additionalInformation
   * @return additionalInformation
  **/
  @ApiModelProperty(value = "")
  public String getAdditionalInformation() {
    return additionalInformation;
  }

  public void setAdditionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  public Issue reporter(AccountRef reporter) {
    this.reporter = reporter;
    return this;
  }

   /**
   * Get reporter
   * @return reporter
  **/
  @ApiModelProperty(value = "")
  public AccountRef getReporter() {
    return reporter;
  }

  public void setReporter(AccountRef reporter) {
    this.reporter = reporter;
  }

  public Issue handler(AccountRef handler) {
    this.handler = handler;
    return this;
  }

   /**
   * Get handler
   * @return handler
  **/
  @ApiModelProperty(value = "")
  public AccountRef getHandler() {
    return handler;
  }

  public void setHandler(AccountRef handler) {
    this.handler = handler;
  }

  public Issue files(List<UploadableFile> files) {
    this.files = files;
    return this;
  }

  public Issue addFilesItem(UploadableFile filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<UploadableFile>();
    }
    this.files.add(filesItem);
    return this;
  }

   /**
   * Get files
   * @return files
  **/
  @ApiModelProperty(value = "")
  public List<UploadableFile> getFiles() {
    return files;
  }

  public void setFiles(List<UploadableFile> files) {
    this.files = files;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Issue issue = (Issue) o;
    return Objects.equals(this.id, issue.id) &&
        Objects.equals(this.project, issue.project) &&
        Objects.equals(this.category, issue.category) &&
        Objects.equals(this.priority, issue.priority) &&
        Objects.equals(this.severity, issue.severity) &&
        Objects.equals(this.reproducibility, issue.reproducibility) &&
        Objects.equals(this.version, issue.version) &&
        Objects.equals(this.os, issue.os) &&
        Objects.equals(this.osBuild, issue.osBuild) &&
        Objects.equals(this.platform, issue.platform) &&
        Objects.equals(this.summary, issue.summary) &&
        Objects.equals(this.description, issue.description) &&
        Objects.equals(this.stepsToReproduce, issue.stepsToReproduce) &&
        Objects.equals(this.additionalInformation, issue.additionalInformation) &&
        Objects.equals(this.reporter, issue.reporter) &&
        Objects.equals(this.handler, issue.handler) &&
        Objects.equals(this.files, issue.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, project, category, priority, severity, reproducibility, version, os, osBuild, platform, summary, description, stepsToReproduce, additionalInformation, reporter, handler, files);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Issue {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    reproducibility: ").append(toIndentedString(reproducibility)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    osBuild: ").append(toIndentedString(osBuild)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    stepsToReproduce: ").append(toIndentedString(stepsToReproduce)).append("\n");
    sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
    sb.append("    reporter: ").append(toIndentedString(reporter)).append("\n");
    sb.append("    handler: ").append(toIndentedString(handler)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

