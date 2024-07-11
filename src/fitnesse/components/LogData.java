// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package fitnesse.components;

import java.util.Calendar;

public class LogData {
  public final String host;
  public final Calendar time;
  public final String requestLine;
  public final int status;
  public final int size;
  public final String username;

  public LogData(LogDataBuilder logDataBuilder) {
    this.host = logDataBuilder.getHost();
    this.time = logDataBuilder.getTime();
    this.requestLine = logDataBuilder.getRequestLine();
    this.status = logDataBuilder.getStatus();
    this.size = logDataBuilder.getSize();
    this.username = logDataBuilder.getUsername();
  }
}
