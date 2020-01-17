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
 * time 2019/3/18 19:28
 */
public class LoginFragment extends SupportFragment {

    private Button  mBtnGoMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login1, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtnGoMain = (Button) view.findViewById(R.id.btn_go_main);

        mBtnGoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWithPop(MainFragment.newInstance());
            }
        });
    }

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }
}