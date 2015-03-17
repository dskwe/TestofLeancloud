package com.avoscloud.sns;

import java.util.Map;

import com.avos.sns.*;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.sns.SNS;
import com.avos.sns.SNSBase;
import com.avos.sns.SNSCallback;
import com.avos.sns.SNSException;
import com.avos.sns.SNSType;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
  private SNSType type = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    View sinaAuth = findViewById(R.id.loginWithSina);
    View qqAuth = findViewById(R.id.loginWithQQ);
    
    sinaAuth.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
  	//SSO
  	    final SNSCallback myCallback = new SNSCallback() {
  	        @Override
  	        public void done(SNSBase object, SNSException e) {
  	            if (e == null) {
  	            	Toast.makeText(MainActivity.this, "已经登录微博",Toast.LENGTH_LONG).show();
  	            	if(AVUser.getCurrentUser()==null)
  	            	{ 
  	            	Map<String, Object> authData = SNS.userInfo(SNSType.AVOSCloudSNSSinaWeibo);
  	            	SNS.loginWithAuthData(authData, new LogInCallback<AVUser>() {
  	                    @Override
  	                    public void done(AVUser avUser, AVException e) {
  	                        if (e == null) {
  	                        	Toast.makeText(MainActivity.this, "create new user with auth data done"+avUser.getUsername(),Toast.LENGTH_LONG).show();
  	                        } else {
  	                        	Toast.makeText(MainActivity.this, "create new user with auth data error: " + e.getMessage(),Toast.LENGTH_LONG).show();
  	                        }
  	                    }
  	                });
  	            	}
  	            	else
  	            	{
  	            		SNS.associateWithAuthData(AVUser.getCurrentUser(), object.userInfo(), null);
  	            		Toast.makeText(MainActivity.this, "get the current user done"+AVUser.getCurrentUser().getUsername(),Toast.LENGTH_LONG).show();
  	            	}
  	            }
  	        }
  	    };

  	    // 关联
  	    try {
  	    	type = SNSType.AVOSCloudSNSSinaWeibo;
  			SNS.setupPlatform(SNSType.AVOSCloudSNSSinaWeibo, "1357500563", "", "https://leancloud.cn/1.1/sns/callback/jqhpogm1nhnyv3r4");
  		} catch (AVException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
  	    SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSSinaWeibo, myCallback);
  	    //SSO END
  		
    	/*  general sign on
        try {
          type = SNSType.AVOSCloudSNSSinaWeibo;
          SNS.setupPlatform(SNSType.AVOSCloudSNSSinaWeibo,"https://leancloud.cn/1.1/sns/goto/jqhpogm1nhnyv3r4");
              //"https://leancloud.cn/1.1/sns/goto/70uczc8byq0bgchy");

          SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSSinaWeibo,
              new SNSCallback() {

                @Override
                public void done(SNSBase base, SNSException error) {
                  if (error == null) {
                    SNS.loginWithAuthData(base.userInfo(), new LogInCallback<AVUser>() {
                      @Override
                      public void done(AVUser user, AVException error) {

                      }
                    });
                  }
                }
              });
        } catch (AVException e) {
          e.printStackTrace();
        }*/
      }
    });

    qqAuth.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
    	//SSO
    	    final SNSCallback myCallback = new SNSCallback() {
    	        @Override
    	        public void done(SNSBase object, SNSException e) {
    	            if (e == null) {
    	            	Toast.makeText(MainActivity.this, "已经登录QQ",Toast.LENGTH_LONG).show();
    	            	if(AVUser.getCurrentUser()==null)
      	            	{ 
    	            		Map<String, Object> authData = SNS.userInfo(SNSType.AVOSCloudSNSQQ);
    	            		SNS.loginWithAuthData(authData, new LogInCallback<AVUser>() {
    	            		@Override
      	                    	public void done(AVUser avUser, AVException e) {
      	                        	if (e == null) {
      	                        		Toast.makeText(MainActivity.this, "create new user with auth data done"+avUser.getUsername(),Toast.LENGTH_LONG).show();
      	                        	} else {
      	                        		Toast.makeText(MainActivity.this, "create new user with auth data error: " + e.getMessage(),Toast.LENGTH_LONG).show();
      	                        	}
      	                    	}
    	            		});
      	            	}
      	            	else
      	            	{
      	            		SNS.associateWithAuthData(AVUser.getCurrentUser(), object.userInfo(), null);
      	            		Toast.makeText(MainActivity.this, "get the current user done"+AVUser.getCurrentUser().getUsername(),Toast.LENGTH_LONG).show();
      	            	}
    	            }
    	        }
    	    };

    	    // 关联
    	    try {
    	    	type = SNSType.AVOSCloudSNSQQ;
    			SNS.setupPlatform(SNSType.AVOSCloudSNSQQ, "1102836776", "", "https://leancloud.cn/1.1/sns/callback/vgultcnnz38u3eb8");
    		} catch (AVException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    	    SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSQQ, myCallback);
    	    //SSO END
    	  
    	  /* general sign on
        try {
          type = SNSType.AVOSCloudSNSQQ;
          SNS.setupPlatform(SNSType.AVOSCloudSNSQQ,
              "https://leancloud.cn/1.1/sns/goto/kspiihdtpzn4186e");
  

          SNS.loginWithCallback(MainActivity.this, SNSType.AVOSCloudSNSQQ,
              new SNSCallback() {

                @Override
                public void done(SNSBase base, SNSException error) {
                  if (error == null) {
                    SNS.loginWithAuthData(base.userInfo(), new LogInCallback<AVUser>() {
                      @Override
                      public void done(AVUser user, AVException error) {

                      }
                    });
                  }
                }
              });
        } catch (AVException e) {
          e.printStackTrace();
        }*/
      }
    });

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    SNS.onActivityResult(requestCode, resultCode, data, type);
    //Toast.makeText(MainActivity.this, type+"登录成功",Toast.LENGTH_LONG).show();
  }
}
