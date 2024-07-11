package fitnesse.components;

import java.util.Calendar;

public class LogDataBuilder {
  private String host;
  private final Calendar time;
  private String requestLine;
  private final int status;
  private final int size;

  // Optional parameters - initialized to default values
  private String username = null;

  public LogDataBuilder(Calendar time, int status, int size) {
    this.time = time;
    this.status = status;
    this.size = size;
  }
  public LogDataBuilder host(String host) {
    this.host = host;
    return this;
  }
  public LogDataBuilder requestLine(String requestLine) {
    this.requestLine = requestLine;
    return this;
  }
  public LogDataBuilder username(String username) {
    this.username = username;
    return this;
  }

  public LogData build() {
    return new LogData(this);
  }

  public String getHost() {
    return host;
  }

  public Calendar getTime() {
    return time;
  }

  public String getRequestLine() {
    return requestLine;
  }

  public int getStatus() {
    return status;
  }

  public int getSize() {
    return size;
  }

  public String getUsername() {
    return username;
  }

}
