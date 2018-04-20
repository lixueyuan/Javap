package com.zzz.test2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.zzz.test2.Fragment.ActivityFragment;
import com.zzz.test2.Fragment.HomeFragment;
import com.zzz.test2.Fragment.MyFragment;
import com.zzz.test2.Fragment.ReleaseFragment;
import com.zzz.test2.Fragment.TipsFragment;

public class MainActivity extends AppCompatActivity {

    private RadioButton homeButton,tipsButton,releaseButton,activityButton,myButton;
    private Fragment[] allFragment;
    private FragmentManager activityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customButton();
        initFramentManager();
    }

    private void customButton () {
        homeButton = findViewById(R.id.bar_home_button);
        tipsButton = findViewById(R.id.bar_tips_button);
        releaseButton = findViewById(R.id.bar_release_button);
        activityButton = findViewById(R.id.bar_activity_button);
        myButton = findViewById(R.id.bar_my_button);
    }

    private void initFramentManager () {
        allFragment = new Fragment[5];
        allFragment[0] = new HomeFragment();
        allFragment[1] = new TipsFragment();
        allFragment[2] = new ReleaseFragment();
        allFragment[3] = new ActivityFragment();
        allFragment[4] = new MyFragment();
        //get Frament action
        activityManager = getFragmentManager();
        FragmentTransaction ft = activityManager.beginTransaction();
        for (int i = 0; i < allFragment.length; i++) {
            ft.add(R.id.main_fragment1, allFragment[i]);
            ft.show(allFragment[0]);
            ft.hide(allFragment[i]);
            homeButton.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.shouye2_03, 0, 0);
        }
        ft.commit();
    }

    public void selectActionForButton (View v) {
        hideFrag();
        FragmentTransaction ft = activityManager.beginTransaction();
        switch (v.getId()) {
            case R.id.bar_home_button:
                ft.show(allFragment[0]);
                homeButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.shouye2_03,0,0);
                break;
            case R.id.bar_tips_button:
                ft.show(allFragment[1]);
                tipsButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.zhuanti2_03,0,0);
                break;
            case R.id.bar_release_button:
                ft.show(allFragment[2]);
                releaseButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.fabu2_03,0,0);
                break;
            case R.id.bar_activity_button:
                ft.show(allFragment[3]);
                activityButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.huodong2_03,0,0);
                break;
            case R.id.bar_my_button:
                ft.show(allFragment[4]);
                myButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.wode2_03,0,0);
                break;
            default:
                break;
        }
        ft.commit();
    }

    private void hideFrag() {
        FragmentTransaction ft = activityManager.beginTransaction();
        defaultImage();
        for (Fragment f : allFragment) {
            ft.hide(f);
        }
        ft.commit();
    }

    private void defaultImage() {
        homeButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.shouye1_03,0,0);
        tipsButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.zhuanti1_03,0,0);
        releaseButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.fabu1_03,0,0);
        activityButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.huodong1_03,0,0);
        myButton.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.wode1_03,0,0);
    }
}
