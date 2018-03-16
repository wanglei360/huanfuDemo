package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
清单文件中application外面里面都可以，
    添加<meta-data android:name="MTA_CHANNEL" android:value="${MTA_CHANNEL_VALUE}"/>

module->buid->android->defaultConfig->flavorDimensions "versionCode"

module->buid->android->buildTypes->release
    android.applicationVariants.all { variant ->
                def name = variant.name
                variant.outputs.all {
                    def newApkName
                    newApkName = "${name}_${variant.versionCode}.apk"
                    outputFileName = newApkName
                }
            }

module->buid->android
    flavorDimensions "default"//这个名字貌似随便取，也可以有多个，总之一定要有..
    productFlavors {
        xiaomi {
            dimension "default"
            manifestPlaceholders([MTA_CHANNEL_VALUE:"xiaomi"])
        }
        other {
            dimension "default"  //如果有其他的渠道，也要做类似的声明
            manifestPlaceholders([MTA_CHANNEL_VALUE:"other"])
        }
    }


 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
