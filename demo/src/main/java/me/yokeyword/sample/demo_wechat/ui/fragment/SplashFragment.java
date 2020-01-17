package me.yokeyword.sample.demo_wechat.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.sample.R;

/**
 * create by xuexuan
 * time 2019/3/19 13:44
 */

public class SplashFragment extends SupportFragment {

    private Button mBtnGoLogin, mBtnGoMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtnGoLogin = (Button) view.findViewById(R.id.btn_go_login);
        mBtnGoMain = (Button) view.findViewById(R.id.btn_go_main);

        mBtnGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithPop(LoginFragment.newInstance());
            }
        });
        mBtnGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithPop(MainFragment.newInstance());
            }
        });
    }


    public static SplashFragment newInstance() {

        Bundle args = new Bundle();

        SplashFragment fragment = new SplashFragment();
        fragment.setArguments(args);
        return fragment;
    }

}