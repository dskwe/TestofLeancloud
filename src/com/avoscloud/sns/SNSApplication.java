package com.avoscloud.sns;

import com.avos.avoscloud.AVOSCloud;

import android.app.Application;

public class SNSApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    AVOSCloud.initialize(this, "qna3o5qdyxge867drns2apd5jzft4am7cpqexdfxyfouhyof",
        "caui9gvintvdanblfuwne63b4es47cid8v7yvf73n1wro6cu");
  }
}
