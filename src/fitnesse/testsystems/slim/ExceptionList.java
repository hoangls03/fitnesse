// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package fitnesse.testsystems.slim;

import fitnesse.html.HtmlUtil;
import fitnesse.wikitext.Utils;
import fitnesse.wikitext.parser.Collapsible;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class ExceptionList {
  private Map<String, String> exceptions;
  private boolean firstHtmlRequest = true;
  private int testNumber = 0;

  private StringBuffer buffer;

  public ExceptionList() {
    exceptions = new HashMap<String, String>();
  }

  public void addException(String key, String exceptionStack)  {
    exceptions.put(key, exceptionStack);
  }

  public String toHtml() {
    buffer = new StringBuffer();
    if (exceptions.size() == 0) {
      return "";
    }
    else if (firstHtmlRequest) {
      firstHtmlRequest = false;
      return writeExceptionDiv();
    }
    else {
      return writeUpdateExceptionDivHtml();
    }
  }

  public void resetForNewTest() {
    firstHtmlRequest = true;
    testNumber++;
  }

  private String writeExceptionDiv() {
    header();
    writeExceptions();
    footer();
    return buffer.toString();
  }

  private String writeUpdateExceptionDivHtml() {
    writeExceptions();
    return HtmlUtil.makeAppendElementScript(getDivName(), buffer.toString()).html();
  }

  private void footer() {
    buffer.append("</div><hr/>");
  }

  private void writeExceptions() {
    for (String key : exceptions.keySet()) {
      buffer.append(String.format("<a name=\"%s\"><b></b></a>", key));
      buffer.append(Collapsible.generateHtml(Collapsible.CLOSED, Utils.escapeHTML(key),
          "<pre>" + Utils.escapeHTML(exceptions.get(key)) + "</pre>"));
    }
    exceptions.clear();
  }

  private void header() {
    buffer.append("<div id=\"" + getDivName() + "\"><H3> <span class=\"fail\">Exceptions</span></H3><br/>");
  }

  private String getDivName() {
    return "test_exceptions" + testNumber;
  }
}
