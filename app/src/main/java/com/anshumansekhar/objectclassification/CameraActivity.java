/* Copyright 2017 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package com.anshumansekhar.objectclassification;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;


import java.util.Locale;

/** Main {@code Activity} class for the Camera app. */
public class CameraActivity extends Activity {
  public static String code;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent i=getIntent();
    code=i.getStringExtra("code");
    Resources res = getApplicationContext().getResources();
    DisplayMetrics dm = res.getDisplayMetrics();
    Configuration conf = getApplicationContext().getResources().getConfiguration();
    conf.setLocale(new Locale(code));
    res.updateConfiguration(conf, dm);
    setContentView(R.layout.activity_camera);
    if (null == savedInstanceState) {
      Bundle bundle=new Bundle();
      bundle.putString("code","en");
      Camera2BasicFragment camera2BasicFragment=new Camera2BasicFragment();
      camera2BasicFragment.setArguments(bundle);
      getFragmentManager()
          .beginTransaction()
          .replace(R.id.container,camera2BasicFragment)
          .commit();
    }
  }
}
